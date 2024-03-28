package hotelbooking;

import hotelbooking.pojos.BookHotel;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import restUtils.AssertionUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BookingTest extends HotelApis {
    @Test
    public void createBooking() throws IOException {
       // BookHotel requestPayLoad = Payloads.getCreateHotelBookingPayloadFromPojo(); // "Manoj","Kumar","250","50","2024-03-01","2024-03-06","Dinner"
        BookHotel requestPayLoad = new BookHotel();
        //BookHotel requestPayLoad = new ManojPojo().getBooking();
        //BookHotel requestPayLoad = new BookHotel().toBuilder().firstname("Manoj").build();
        System.out.println(requestPayLoad);
        Response response = createHotelBooking(requestPayLoad);
        // This allows you to handle null values more gracefully by providing a way to explicitly check for the presence or absence of a value without encountering null pointer exceptions.
        /*Optional bookingid = Optional.ofNullable(response.jsonPath().get("bookingid"));
        if (bookingid.isPresent()){
            System.out.println("id is present: "+bookingid);
        }else{
            System.out.println("id is not present");
        }*/
        Map<String,Object> expectedValueMap = new HashMap<>();
        expectedValueMap.put("firstname", requestPayLoad.getFirstname());
        expectedValueMap.put("lastname",requestPayLoad.getLastname());
        expectedValueMap.put("totalprice",requestPayLoad.getTotalprice());
        expectedValueMap.put("depositpaid",requestPayLoad.getDepositpaid());
        expectedValueMap.put("checkin",requestPayLoad.getBookingdates().getCheckin());
        expectedValueMap.put("checkout",requestPayLoad.getBookingdates().getCheckout());
        expectedValueMap.put("additionalneeds",requestPayLoad.getAdditionalneeds());
        AssertionUtils.assertExpectedValuesWithJsonPath(response,expectedValueMap);
        /*ObjectMapper objectMapper = new ObjectMapper();
        ManojPojo createBookHotelResponse = objectMapper.readValue(response.getBody().asString(), ManojPojo.class);
        Assert.assertEquals(createBookHotelResponse.getBooking().getFirstname(), requestPayLoad.getFirstname());
        Assert.assertEquals(createBookHotelResponse.getBooking().getLastname(), requestPayLoad.getLastname());
        Assert.assertEquals(createBookHotelResponse.getBooking().getTotalprice(), requestPayLoad.getTotalprice());
        Assert.assertEquals(createBookHotelResponse.getBooking().getDepositpaid(),requestPayLoad.getDepositpaid());
        Assert.assertEquals(createBookHotelResponse.getBooking().getBookingdates().getCheckin(), requestPayLoad.getBookingdates().getCheckin());
        Assert.assertEquals(createBookHotelResponse.getBooking().getBookingdates().getCheckout(), requestPayLoad.getBookingdates().getCheckout());
        Assert.assertEquals(createBookHotelResponse.getBooking().getAdditionalneeds(), requestPayLoad.getAdditionalneeds());
       // MatcherAssert.assertThat(createBookHotelResponse.getBooking(), samePropertyValuesAs(requestPayLoad));
        Assert.assertEquals(response.statusCode(), 200);*/

       /* Javers javers = JaversBuilder.javers().build();   //  using javers to compare the objects
        Diff diff = javers.compare(requestPayLoad,response);
        System.out.println("%%%%%%%%%%%%%%%%%%%%% JAVERS %%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println(diff.prettyPrint());*/
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

