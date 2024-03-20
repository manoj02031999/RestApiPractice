package hotelbooking;

import hotelbooking.pojos.BookHotel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BookingTest extends HotelApis {
    @Test
    public void createBooking() throws IOException {
       // BookHotel requestPayLoad = Payloads.getCreateHotelBookingPayloadFromPojo(); // "Manoj","Kumar","250","50","2024-03-01","2024-03-06","Dinner"
        BookHotel requestPayLoad = new BookHotel();
        //BookHotel requestPayLoad = new BookHotel().toBuilder().firstname("Manoj").build();
        System.out.println(requestPayLoad);
        Response response = createHotelBooking(requestPayLoad);

        Assert.assertEquals(response.statusCode(), 200);
    }
}
