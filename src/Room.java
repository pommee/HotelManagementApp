public class Room {
    private int roomNumber;
    private int numberOfBeds;
    private boolean hasBalcony;
    private double pricePerNight;
    private boolean isBooked;
    private String bookedBy;
    private String customerNote;

    public Room(int roomNumber, int numberOfBeds, boolean hasBalcony, Double pricePerNight, boolean isBooked, String bookedBy, String customerNote) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.hasBalcony = hasBalcony;
        this.pricePerNight = pricePerNight;
        this.isBooked = isBooked;
        this.bookedBy = bookedBy;
        this.customerNote = customerNote;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
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

    public boolean isBookedBy(String bookedBy) {
        return bookedBy.equals(this.bookedBy);
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    @Override
    public String toString() {
        return "Room-Number: " + roomNumber + ", Number of beds: " + numberOfBeds +
                ", Balcony: " + hasBalcony + ", Price: " + pricePerNight + ", Booked: " + isBooked + ", Booked by: " + bookedBy + ", Customer note: " + customerNote;
    }

}
