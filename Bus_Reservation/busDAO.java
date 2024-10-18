package Bus_Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class busDAO {
    public void displayBusInfo() throws SQLException {
        Connection con = dbconnection.getConnection();
        String query = "SELECT * FROM bus";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Bus bus = new Bus(rs.getInt("id"), rs.getBoolean("ac"), rs.getInt("capacity"));
            bus.displayBusInfo();
        }
    }

    public int getCapacity(int busNo) throws SQLException {
        String query = "SELECT capacity FROM bus WHERE id = ?";
        Connection con = dbconnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, busNo);
        ResultSet rs = pst.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
}
