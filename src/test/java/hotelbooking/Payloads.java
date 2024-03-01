package hotelbooking;

import java.util.HashMap;
import java.util.Map;

public class Payloads {
    public static String getCreateHotelBookingPayloadFromString(String firstname,String lastname, String totalprice, String depositpaid,
                                                       String checkin, String checkout, String additionalneeds){
        String payload = "{\n" +
                "    \"firstname\" : \""+firstname+"\",\n" +
                "    \"lastname\" : \""+lastname+"\",\n" +
                "    \"totalprice\" : "+totalprice+",\n" +
                "    \"depositpaid\" : "+depositpaid+",\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \""+checkin+"\",\n" +
                "        \"checkout\" : \""+checkout+"\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \""+additionalneeds+"\"\n" +
                "}";
        return payload;
    }

    public static Map<String,Object> getCreateHotelBookingPayloadFromMap(String firstname,String lastname, String totalprice, String depositpaid,
                                                      String checkin, String checkout, String additionalneeds){
        Map<String,Object> payload = new HashMap<>();
        payload.put("firstname", firstname);
        payload.put("lastname", lastname);
        payload.put("totalprice", totalprice);
        payload.put("depositpaid", depositpaid);
        payload.put("checkin", checkin);
        payload.put("checkout", checkout);
        payload.put("additionalneeds", additionalneeds);

        return payload;
    }

}
