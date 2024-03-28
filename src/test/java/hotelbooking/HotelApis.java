package hotelbooking;

import hotelbooking.pojos.BookHotel;
import hotelbooking.pojos.ManojPojo;
import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class HotelApis {
    public Response createHotelBooking(Map<String, Object> CreateHotelBookingPayload) {
            String endpoint = (String) Base.dataFromJsonFile.get("createHotelBookingEndpoint");
            return RestUtils.performPost(endpoint, CreateHotelBookingPayload, new HashMap<>());

    }
    public Response createHotelBooking(BookHotel createHotelBookingPayload) {
        String endpoint = (String) Base.dataFromJsonFile.get("createHotelBookingEndpoint");
        return RestUtils.performPost(endpoint, createHotelBookingPayload, new HashMap<>());

    }
    public Response createHotelBooking(ManojPojo createHotelBookingPayload) {
        String endpoint = (String) Base.dataFromJsonFile.get("createHotelBookingEndpoint");
        return RestUtils.performPost(endpoint, createHotelBookingPayload, new HashMap<>());

    }
}
