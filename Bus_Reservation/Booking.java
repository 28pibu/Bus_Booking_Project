package Bus_Reservation;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Booking {
    String passengerName;
    int busNo;
    Date date;

    public Booking() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of passenger: ");
        passengerName = scanner.next();
        System.out.println("Enter bus No: ");
        busNo = scanner.nextInt();
        System.out.println("Enter Date (dd-MM-yyyy): ");
        String dateInput = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        date = dateFormat.parse(dateInput);
    }

    public boolean isAvailable() throws SQLException {
        busDAO busdao = new busDAO();
        BookingDAO bookingdao = new BookingDAO();

        int capacity = busdao.getCapacity(busNo);
        int booked = bookingdao.getBookedCount(busNo, date);

        return booked < capacity;
    }
}
