package Bus_Reservation;

import java.util.Scanner;

public class CancelBooking {
    String passengerName;
    int busNo;
    String dateInput;

    CancelBooking() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of passenger: ");
        passengerName = scanner.next();
        System.out.println("Enter bus No: ");
        busNo = scanner.nextInt();
        System.out.println("Enter Date - dd-mm-yyyy: ");
        dateInput = scanner.next();
    }
}
