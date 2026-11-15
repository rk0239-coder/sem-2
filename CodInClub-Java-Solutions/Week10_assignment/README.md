# Attendance tracker

This project includes a Java HTTP backend, a browser frontend, and a MySQL
database accessed through JDBC. At startup, the backend creates the attendance
table if needed. The page loads records from `GET /api/attendance` and saves
new records with `POST /api/attendance`.

Required:

- `ATTENDANCE_JDBC_URL`, for example `jdbc:mysql://localhost:3306/attendance`
- `ATTENDANCE_DB_USER`

Optional:

- `ATTENDANCE_DB_PASSWORD` (defaults to an empty password)
- `PORT` (defaults to `8080`)

Set these variables in the terminal (do not put database credentials in the
source code), then from this directory run:

```sh
export ATTENDANCE_JDBC_URL='jdbc:mysql://localhost:3306/attendance'
export ATTENDANCE_DB_USER='root'
export ATTENDANCE_DB_PASSWORD='your-local-password'
mvn compile exec:java -Dexec.mainClass=AttendanceServer
```

Open [http://localhost:8080](http://localhost:8080) in a browser. The frontend
and backend share the same server, so no separate frontend server or CORS setup
is needed. The attendance list is fetched from MySQL through the Java API.
