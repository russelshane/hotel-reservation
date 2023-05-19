// Darsler Russel Shane S. Fortes
// BSCS - 1D
// Final Task

import java.util.ArrayList;
import java.util.List;

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
