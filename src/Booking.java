import java.util.Date;

public class Booking {
    private int bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getBookingId() {
        return bookingId;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId;
    }

    public Booking(int bookingId, Date checkInDate) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
    }
}
