public class Room {
    private int roomNumber;
    private int numberOfBeds;
    private boolean hasBalcony;
    private double pricePerNight;
    private boolean isBooked;
    private String bookedBy;

    @Override
    public String toString() {
        return "Room-Number: " + roomNumber + ", Number of beds: " + numberOfBeds +
                ", Balcony:  " + hasBalcony + ", Price: " + pricePerNight + ", Booked: " + isBooked + ", Booked by: " + bookedBy;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public Room(int roomNumber, int numberOfBeds, boolean hasBalcony, Double pricePerNight) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.hasBalcony = hasBalcony;
        this.pricePerNight = pricePerNight;
    }
}
