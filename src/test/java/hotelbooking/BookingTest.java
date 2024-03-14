package hotelbooking;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class BookingTest extends  HotelApis{
    @Test
    public void createBooking() throws IOException {
        Map<String, Object> requestPayLoad = Payloads.getCreateHotelBookingPayloadFromMap("Manoj","Kumar","250","50","2024-03-01","2024-03-06","Dinner");
       Response response = createHotelBooking(requestPayLoad);
        Assert.assertEquals(response.statusCode(),200);
    }
}
