import java.util.Date;

public class Booking {
    private int bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;

    public Booking(int bookingId, Date checkInDate, Date checkOutDate, double totalPrice) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
    }
}
