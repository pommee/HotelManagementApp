public class Room {
    private int roomNumber;
    private int numberOfBeds;
    private boolean hasBalcony;
    private double pricePerNight;
    private boolean isBooked;
    private String bookedBy;
    String customerNote;

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public String getCustomerNote() {
        return customerNote;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    @Override
    public String toString() {
        return "Room-Number: " + roomNumber + ", Number of beds: " + numberOfBeds +
                ", Balcony:  " + hasBalcony + ", Price: " + pricePerNight + ", Booked: " + isBooked + ", Booked by: " + bookedBy + ", Customer note: " + customerNote;
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

    public boolean isBookedBy(String bookedBy) {
        return bookedBy.equals(this.bookedBy);
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public Room(int roomNumber, int numberOfBeds, boolean hasBalcony, Double pricePerNight) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.hasBalcony = hasBalcony;
        this.pricePerNight = pricePerNight;
    }
}
