import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class AttendanceServer {
    private static final Gson GSON = new Gson();
    private static final int MAX_REQUEST_BYTES = 16 * 1024;
    private static final String JDBC_URL = requiredEnvironmentVariable("ATTENDANCE_JDBC_URL");
    private static final String DB_USER = requiredEnvironmentVariable("ATTENDANCE_DB_USER");
    private static final String DB_PASSWORD = System.getenv().getOrDefault("ATTENDANCE_DB_PASSWORD", "");

    public static void main(String[] args) throws IOException, SQLException {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
        initializeDatabase();

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/api/attendance", AttendanceServer::handleAttendance);
        server.createContext("/", AttendanceServer::serveFrontend);
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
        System.out.println("Attendance app is available at http://localhost:" + port);
    }

    private static void initializeDatabase() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS attendance_records ("
                + "id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                + "student_name VARCHAR(100) NOT NULL, "
                + "attendance_date DATE NOT NULL, "
                + "present BOOLEAN NOT NULL)";
        try (Connection connection = openConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        }
    }

    private static void handleAttendance(HttpExchange exchange) throws IOException {
        try {
            String path = exchange.getRequestURI().getPath();
            if (!"/api/attendance".equals(path)) {
                sendJson(exchange, 404, new ErrorResponse("Not found."));
            } else if ("GET".equals(exchange.getRequestMethod())) {
                sendJson(exchange, 200, getAttendanceRecords());
            } else if ("POST".equals(exchange.getRequestMethod())) {
                AttendanceRequest request = readRequest(exchange);
                AttendanceRecord record = saveAttendanceRecord(request);
                sendJson(exchange, 201, record);
            } else {
                exchange.getResponseHeaders().set("Allow", "GET, POST");
                sendJson(exchange, 405, new ErrorResponse("Use GET or POST."));
            }
        } catch (IllegalArgumentException | JsonParseException exception) {
            sendJson(exchange, 400, new ErrorResponse(exception.getMessage()));
        } catch (SQLException exception) {
            exception.printStackTrace(System.err);
            sendJson(exchange, 500, new ErrorResponse("Database request failed."));
        } finally {
            exchange.close();
        }
    }

    private static AttendanceRequest readRequest(HttpExchange exchange) throws IOException {
        byte[] body;
        try (InputStream input = exchange.getRequestBody()) {
            body = input.readNBytes(MAX_REQUEST_BYTES + 1);
        }
        if (body.length > MAX_REQUEST_BYTES) {
            throw new IllegalArgumentException("Request body is too large.");
        }
        AttendanceRequest request = GSON.fromJson(
                new String(body, StandardCharsets.UTF_8), AttendanceRequest.class);
        if (request == null) {
            throw new IllegalArgumentException("A JSON request body is required.");
        }
        return request;
    }

    private static List<AttendanceRecord> getAttendanceRecords() throws SQLException {
        String sql = "SELECT id, student_name, attendance_date, present "
                + "FROM attendance_records ORDER BY attendance_date DESC, id DESC";
        List<AttendanceRecord> records = new ArrayList<>();
        try (Connection connection = openConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                records.add(new AttendanceRecord(
                        results.getLong("id"),
                        results.getString("student_name"),
                        results.getDate("attendance_date").toLocalDate().toString(),
                        results.getBoolean("present")));
            }
        }
        return records;
    }

    private static AttendanceRecord saveAttendanceRecord(AttendanceRequest request)
            throws SQLException {
        if (request.studentName == null || request.studentName.isBlank()) {
            throw new IllegalArgumentException("Student name is required.");
        }
        String studentName = request.studentName.trim();
        if (studentName.length() > 100) {
            throw new IllegalArgumentException("Student name must be 100 characters or fewer.");
        }
        if (request.date == null || request.date.isBlank()) {
            throw new IllegalArgumentException("Attendance date is required.");
        }
        if (request.present == null) {
            throw new IllegalArgumentException("Attendance status is required.");
        }

        LocalDate date;
        try {
            date = LocalDate.parse(request.date);
        } catch (DateTimeParseException exception) {
            throw new IllegalArgumentException("Date must use YYYY-MM-DD format.");
        }

        String sql = "INSERT INTO attendance_records "
                + "(student_name, attendance_date, present) VALUES (?, ?, ?)";
        try (Connection connection = openConnection();
             PreparedStatement statement = connection.prepareStatement(
                     sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, studentName);
            statement.setDate(2, Date.valueOf(date));
            statement.setBoolean(3, request.present);
            statement.executeUpdate();
            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (!keys.next()) {
                    throw new SQLException("The database did not return the new record ID.");
                }
                return new AttendanceRecord(keys.getLong(1), studentName, date.toString(),
                        request.present);
            }
        }
    }

    private static void serveFrontend(HttpExchange exchange) throws IOException {
        try {
            if (!"/".equals(exchange.getRequestURI().getPath())
                    || !"GET".equals(exchange.getRequestMethod())) {
                exchange.getResponseHeaders().set("Allow", "GET");
                exchange.sendResponseHeaders(404, -1);
                return;
            }
            try (InputStream page = AttendanceServer.class.getResourceAsStream("/index.html")) {
                if (page == null) {
                    exchange.sendResponseHeaders(500, -1);
                    return;
                }
                byte[] content = page.readAllBytes();
                exchange.getResponseHeaders().set("Content-Type", "text/html; charset=utf-8");
                exchange.sendResponseHeaders(200, content.length);
                exchange.getResponseBody().write(content);
            }
        } finally {
            exchange.close();
        }
    }

    private static void sendJson(HttpExchange exchange, int status, Object body)
            throws IOException {
        byte[] content = GSON.toJson(body).getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
        exchange.sendResponseHeaders(status, content.length);
        exchange.getResponseBody().write(content);
    }

    private static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
    }

    private static String requiredEnvironmentVariable(String name) {
        String value = System.getenv(name);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Set the " + name + " environment variable.");
        }
        return value;
    }

    private static final class AttendanceRequest {
        private String studentName;
        private String date;
        private Boolean present;
    }

    private static final class AttendanceRecord {
        private final long id;
        private final String studentName;
        private final String date;
        private final boolean present;

        private AttendanceRecord(long id, String studentName, String date, boolean present) {
            this.id = id;
            this.studentName = studentName;
            this.date = date;
            this.present = present;
        }
    }

    private static final class ErrorResponse {
        private final String error;

        private ErrorResponse(String error) {
            this.error = error;
        }
    }
}
