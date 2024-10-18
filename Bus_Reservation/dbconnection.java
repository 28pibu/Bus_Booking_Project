package Bus_Reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
    private static final String url = "jdbc:mysql://localhost:3306/busresv";
    private static final String username = "root";
    private static final String password = "shan@28112000";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
