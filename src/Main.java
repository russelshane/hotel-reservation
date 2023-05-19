// Darsler Russel Shane S. Fortes
// BSCS - 1D
// Final Task


import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rooms in the hotel: ");
        int numberOfRooms = scanner.nextInt();

        Hotel hotel = new Hotel(numberOfRooms);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        boolean exit = false;

        while (!exit) {
            System.out.println("1. DISPLAY ALL ROOMS");
            System.out.println("2. RESERVE A ROOM");
            System.out.println("3. CHECK-OUT A GUEST");
            System.out.println("4. EXIT/CANCEL");
            System.out.print("ENTER YOUR CHOICE: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.displayRooms();
                    break;
                case 2:
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter full guest name: ");
                    String guestName = scanner.nextLine();
                    hotel.checkIn(roomNumber, guestName, dtf.format(now));
                    break;
                case 3:
                    System.out.print("Enter room number: ");
                    roomNumber = scanner.nextInt();
                    hotel.checkOut(roomNumber);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}