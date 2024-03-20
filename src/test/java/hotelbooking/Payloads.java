package hotelbooking;

import com.github.javafaker.Faker;
import hotelbooking.pojos.BookHotel;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

import java.util.HashMap;
import java.util.Map;

public class Payloads {
    public static String getCreateHotelBookingPayloadFromString(String firstname, String lastname, String totalprice, Boolean depositpaid,
                                                                String checkin, String checkout, String additionalneeds) {
        String payload = "{\n" +
                "    \"firstname\" : \"" + firstname + "\",\n" +
                "    \"lastname\" : \"" + lastname + "\",\n" +
                "    \"totalprice\" : " + totalprice + ",\n" +
                "    \"depositpaid\" : " + depositpaid + ",\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"" + checkin + "\",\n" +
                "        \"checkout\" : \"" + checkout + "\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"" + additionalneeds + "\"\n" +
                "}";
        return payload;
    }

    public static Map<String, Object> getCreateHotelBookingPayloadFromMap(String firstname, String lastname, String totalprice, Boolean depositpaid,
                                                                          String checkin, String checkout, String additionalneeds) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("firstname", firstname);
        payload.put("lastname", lastname);
        payload.put("totalprice", totalprice);
        payload.put("depositpaid", depositpaid);
        payload.put("checkin", checkin);
        payload.put("checkout", checkout);
        payload.put("additionalneeds", additionalneeds);

        return payload;
    }

    public static Map<String, Object> getCreateHotelBookingPayloadFromMap() {
        Map<String, Object> payload = new HashMap<>();
        Faker faker = new Faker();
        payload.put("firstname", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME));
        payload.put("lastname", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.LASTNAME));
        payload.put("totalprice", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.TOTALPRICE));
        payload.put("depositpaid", RandomDataGenerator.getRandomDataForDeposit(RandomDataTypeNames.DEPOSITPAID));
        payload.put("checkin", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECKIN));
        payload.put("checkout", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECKOUT));
        payload.put("additionalneeds", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.ADDITIONALNEEDS));

        return payload;
    }

    public static BookHotel getCreateHotelBookingPayloadFromPojo() {
        return new BookHotel(
                RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME),
                RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.LASTNAME),
                RandomDataGenerator.getRandomDataForTotalPrice(RandomDataTypeNames.TOTALPRICE),
                RandomDataGenerator.getRandomDataForDeposit(RandomDataTypeNames.DEPOSITPAID),
                new BookHotel.BookingDates(
                        RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECKIN),
                        RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECKOUT)
                ),
                RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.ADDITIONALNEEDS)
        );

//        return BookHotel
//                .builder()
//                .firstname(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME))
//                .lastname(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.LASTNAME))
//                .totalprice(RandomDataGenerator.getRandomDataForTotalPrice(RandomDataTypeNames.TOTALPRICE))
//                .depositpaid(RandomDataGenerator.getRandomDataForDeposit(RandomDataTypeNames.DEPOSITPAID))
//                .bookingdates(
//                        BookHotel.BookingDates.builder()
//                                .checkin(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECKIN))
//                                .checkout(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECKOUT))
//                                .build()
//                )
//                .additionalneeds(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.ADDITIONALNEEDS))
//                .build();
    }

}
