public class Room extends HotelLogic{
    private int roomNumber;
    private int numberOfBeds;
    private boolean hasBalcony;
    private boolean isBooked;

    public Room(int roomNumber, int numberOfBeds, boolean hasBalcony) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.hasBalcony = hasBalcony;
    }
}
