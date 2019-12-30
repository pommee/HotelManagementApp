import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
    private int bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    @Override
    public String toString() {
        return "Booking-Id: " + bookingId + ", Check-in date: " + checkInDate + ", Check-Out date: " + checkOutDate + ", Total price: " + totalPrice;
    }

    public Booking(int bookingId, Date checkInDate, Date checkOutDate, double totalPrice) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
    }
}
