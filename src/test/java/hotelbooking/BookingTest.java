package hotelbooking;

import com.fasterxml.jackson.databind.ObjectMapper;
import hotelbooking.pojos.BookHotel;
import hotelbooking.pojos.ManojPojo;
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

        ObjectMapper objectMapper = new ObjectMapper();
        ManojPojo createBookHotelResponse = objectMapper.readValue(response.getBody().asString(), ManojPojo.class);
        Assert.assertEquals(createBookHotelResponse.getBooking().getFirstname(), requestPayLoad.getFirstname());
        Assert.assertEquals(createBookHotelResponse.getBooking().getLastname(), requestPayLoad.getLastname());
        Assert.assertEquals(createBookHotelResponse.getBooking().getTotalprice(), requestPayLoad.getTotalprice());
        Assert.assertEquals(createBookHotelResponse.getBooking().getDepositpaid(),requestPayLoad.getDepositpaid());
        Assert.assertEquals(createBookHotelResponse.getBooking().getBookingdates().getCheckin(), requestPayLoad.getBookingdates().getCheckin());
        Assert.assertEquals(createBookHotelResponse.getBooking().getBookingdates().getCheckout(), requestPayLoad.getBookingdates().getCheckout());
        Assert.assertEquals(createBookHotelResponse.getBooking().getAdditionalneeds(), requestPayLoad.getAdditionalneeds());
       // MatcherAssert.assertThat(createBookHotelResponse, samePropertyValuesAs(requestPayLoad.getBoo));
        Assert.assertEquals(response.statusCode(), 200);
    }

//    @Test
//    public void createBookingAndVerifyResponse() throws IOException {
//        try {
//            BookHotel requestPayLoad = new BookHotel();
//            System.out.println("===================request==================");
//            System.out.println(requestPayLoad);
//            Response response = createHotelBooking(requestPayLoad);
//
//            // first way
//            Assert.assertEquals(response.jsonPath().getString("firstname"), requestPayLoad.getFirstname());
//
//            System.out.println("********* responsedfg  ************* \n" + response.getBody());
//            ObjectMapper objectMapper = new ObjectMapper();
//            String res = "{\"bookingid\":1011,\"booking\":{\"firstname\":\"Kristel\",\"lastname\":\"Wilkinson\",\"totalprice\":1285,\"depositpaid\":false,\"bookingdates\":{\"checkin\":\"2024-03-22\",\"checkout\":\"2024-03-22\"},\"additionalneeds\":\"Willy Hills\"}}";
//            ManojPojo createBookHotelResponse = objectMapper.readValue(res, ManojPojo.class);
//            System.out.println("===================createBookHotelResponse==================");
//            System.out.println(createBookHotelResponse);
//            Assert.assertEquals(createBookHotelResponse, requestPayLoad);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//    }
}

