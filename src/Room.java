// Darsler Russel Shane S. Fortes
// BSCS - 1D
// Final Task

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