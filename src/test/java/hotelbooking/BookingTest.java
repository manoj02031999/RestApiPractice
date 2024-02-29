package hotelbooking;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.util.HashMap;

public class BookingTest {
    @Test
    public void createBooking(){
        String endpoint = "https://restful-booker.herokuapp.com/booking";
        String requestPayLoad = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
       Response response = RestUtils.performPost(endpoint, requestPayLoad, new HashMap<>());
        Assert.assertEquals(response.statusCode(),200);
    }
}
