package Bus_Reservation;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BusDemo {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            busDAO busdao = new busDAO();
            busdao.displayBusInfo();

            int userOption;
            do {
                System.out.println("Enter 1 to Book, 2 to Cancel, 3 to Exit: ");
                userOption = scanner.nextInt();

                switch (userOption) {
                    case 1: // Booking
                        Booking booking = new Booking();
                        if (booking.isAvailable()) {
                            BookingDAO bookingdao = new BookingDAO();
                            bookingdao.addBooking(booking);
                            System.out.println("Your booking is Confirmed");
                        } else {
                            System.out.println("Sorry, the bus is full. Try another bus or date.");
                        }
                        break;

                    case 2: // Cancellation
                        System.out.println("Enter passenger name to cancel: ");
                        String passengerName = scanner.next();
                        System.out.println("Enter bus No: ");
                        int busNo = scanner.nextInt();
                        System.out.println("Enter Date (dd-MM-yyyy): ");
                        String dateInput = scanner.next();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        Date date = dateFormat.parse(dateInput);

                        BookingDAO bookingdao = new BookingDAO();
                        bookingdao.cancelBooking(passengerName, busNo, date);
                        System.out.println("Your booking has been cancelled.");
                        break;

                    case 3: // Exit
                        System.out.println("Exiting the system.");
                        break;

                    default:
                        System.out.println("Invalid option! Please try again.");
                }
            } while (userOption != 3);

            scanner.close();
        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }
    }
}
