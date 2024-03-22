package hotelbooking.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ManojPojo {

    private int bookingid;

    private BookHotel booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public BookHotel getBooking() {
        return booking;
    }

    public void setBooking(BookHotel booking) {
        this.booking = booking;
    }
}
