package Bus_Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BookingDAO {
    public int getBookedCount(int busNo, Date date) throws SQLException {
        String query = "SELECT COUNT(passenger_name) FROM booking WHERE bus_no = ? AND travel_date = ?";
        Connection con = dbconnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        pst.setInt(1, busNo);
        pst.setDate(2, sqlDate);
        ResultSet rs = pst.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public void addBooking(Booking booking) throws SQLException {
        String query = "INSERT INTO booking (passenger_name, bus_no, travel_date) VALUES (?, ?, ?)";
        Connection con = dbconnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        java.sql.Date sqlDate = new java.sql.Date(booking.date.getTime());

        pst.setString(1, booking.passengerName);
        pst.setInt(2, booking.busNo);
        pst.setDate(3, sqlDate);

        pst.executeUpdate();
    }

    public void cancelBooking(String passengerName, int busNo, Date date) throws SQLException {
        String query = "DELETE FROM booking WHERE passenger_name = ? AND bus_no = ? AND travel_date = ?";
        Connection con = dbconnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        pst.setString(1, passengerName);
        pst.setInt(2, busNo);
        pst.setDate(3, sqlDate);

        pst.executeUpdate();
    }
}
