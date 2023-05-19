// Darsler Russel Shane S. Fortes
// BSCS - 1D
// Final Task

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

class Room {
    private int number;
    private boolean available;
    private String guestName;
    private String checkInDate;

    public Room(int number) {
        this.number = number;
        this.available = true;
        this.guestName = "";
        this.checkInDate = "";
    }

    public int getNumber() {
        return number;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getCheckInDate(){
        return checkInDate;
    }

    public void checkIn(String guestName, String checkInDate) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.available = false;
    }

    public void checkOut() {
        this.guestName = "";
        this.available = true;
        this.checkInDate = "";
    }
}

class Hotel {
    private List<Room> rooms;

    public Hotel(int numberOfRooms) {
        rooms = new ArrayList<>();
        for (int i = 1; i <= numberOfRooms; i++) {
            rooms.add(new Room(i));
        }
    }

    public void displayRooms() {
        System.out.println("Room\tAvailability\tGuest Name\tCheck-In Date");
        for (Room room : rooms) {
            System.out.printf("%d\t %s\t \t%s \t%s\t%n", room.getNumber(),
                    room.isAvailable() ? "Available" : "Occupied",
                    room.getGuestName(), room.getCheckInDate());

        }
        System.out.println();
    }



    public void checkIn(int roomNumber, String guestName, String checkInDate) {
        Room room = getRoomByNumber(roomNumber);
        if (room == null) {
            System.out.println("Invalid room number.");
            return;
        }
        if (!room.isAvailable()) {
            System.out.println("Room is already occupied.");
            return;
        }
        room.checkIn(guestName, checkInDate);
        System.out.println("Check-in successful.");
    }

    public void checkOut(int roomNumber) {
        Room room = getRoomByNumber(roomNumber);
        if (room == null) {
            System.out.println("Invalid room number.");
            return;
        }
        if (room.isAvailable()) {
            System.out.println("Room is already vacant.");
            return;
        }
        room.checkOut();
        System.out.println("Check-out successful.");
    }

    private Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}

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