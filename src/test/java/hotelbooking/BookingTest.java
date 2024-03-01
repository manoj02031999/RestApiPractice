package hotelbooking;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class BookingTest {
    @Test
    public void createBooking(){
        String endpoint = "https://restful-booker.herokuapp.com/booking";
        Map<String, Object> requestPayLoad = Payloads.getCreateHotelBookingPayloadFromMap("Manoj","Kumar","250","50","2024-03-01","2024-03-06","Dinner");
       Response response = RestUtils.performPost(endpoint, requestPayLoad, new HashMap<>());
        Assert.assertEquals(response.statusCode(),200);
    }
}
