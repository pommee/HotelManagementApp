import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
    private int bookingId;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;
    private String bookedBy;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

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

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    @Override
    public String toString() {

        return "Booking-Id: " + bookingId + ", Check-in date: " + dateFormat.format(checkInDate) + ", Check-Out date: " + dateFormat.format(checkOutDate) + ", Total price [kr]: " + totalPrice + ", Booked by (SSN): " + bookedBy;
    }

    public Booking(int bookingId, Date checkInDate, Date checkOutDate, double totalPrice, String bookedBy) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.bookedBy = bookedBy;
    }
}
