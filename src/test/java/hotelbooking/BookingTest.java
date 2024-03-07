package hotelbooking;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BookingTest {
    @Test
    public void createBooking() throws IOException {
        String env = System.getProperty("env") == null ? "qa": System.getProperty("env");
        Map<String,String> data = JsonUtils.getJsonDataAsMap("/"+env+"/hotelApiData.json");
        String endpoint = data.get("createHotelBookingEndpoint");
        Map<String, Object> requestPayLoad = Payloads.getCreateHotelBookingPayloadFromMap("Manoj","Kumar","250","50","2024-03-01","2024-03-06","Dinner");
       Response response = RestUtils.performPost(endpoint, requestPayLoad, new HashMap<>());
        Assert.assertEquals(response.statusCode(),200);
    }
}
