import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Problem6_AttendanceTracker {

    private static final String JDBC_URL_ENV = "ATTENDANCE_JDBC_URL";
    private static final String DB_USER_ENV = "ATTENDANCE_DB_USER";
    private static final String DB_PASSWORD_ENV = "ATTENDANCE_DB_PASSWORD";

    public static int[] attendanceSummary(int[] days) {
        int present = 0, streak = 0, longest = 0;
        for (int d : days) {
            if (d == 1) {
                present++;
                streak++;
                longest = Math.max(longest, streak);
            } else {
                streak = 0;
            }
        }
        return new int[]{present, longest};
    }

    private static int checkDatabaseConnection() throws SQLException {
        String jdbcUrl = requiredEnvironmentVariable(JDBC_URL_ENV);
        String username = requiredEnvironmentVariable(DB_USER_ENV);
        String password = System.getenv(DB_PASSWORD_ENV);
        if (password == null) {
            password = "";
        }

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT 1");
             ResultSet resultSet = statement.executeQuery()) {
            if (!resultSet.next()) {
                throw new SQLException("The database connectivity check returned no rows.");
            }
            return resultSet.getInt(1);
        }
    }

    private static String requiredEnvironmentVariable(String name) {
        String value = System.getenv(name);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Set the " + name + " environment variable before running this program.");
        }
        return value;
    }

    public static void main(String[] args) throws SQLException {
        int[] r1 = attendanceSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1});
        System.out.println("Present: " + r1[0] + ", Longest streak: " + r1[1]);
        int[] r2 = attendanceSummary(new int[]{0, 0, 0});
        System.out.println("Present: " + r2[0] + ", Longest streak: " + r2[1]);

        int response = checkDatabaseConnection();
        System.out.println("Database responded: " + response);
    }
}
