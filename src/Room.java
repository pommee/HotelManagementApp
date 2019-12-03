public class Room{
    private int roomNumber;
    private int numberOfBeds;
    private double pricePerNight;
    private boolean hasBalcony;
    private boolean isBooked;

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", numberOfBeds=" + numberOfBeds +
                ", pricePerNight=" + pricePerNight +
                ", hasBalcony=" + hasBalcony +
                ", isBooked=" + isBooked +
                '}';
    }

    public Room(int roomNumber, int numberOfBeds, double pricePerNight, boolean hasBalcony, boolean isBooked) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.pricePerNight = pricePerNight;
        this.hasBalcony = hasBalcony;
        this.isBooked = isBooked;
    }

    public boolean getIsBooked() {
        return isBooked;
    }

}
