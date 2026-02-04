
import java.sql.*;

public class DatabaseHandler {
    private static DatabaseHandler instance;
    private Connection connection;

    private DatabaseHandler() throws SQLException {
        connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/police_archive",
            "postgres",
            "12345"
        );
    }

    public static DatabaseHandler getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseHandler();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
