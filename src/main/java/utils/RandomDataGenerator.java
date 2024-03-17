package utils;

import com.github.javafaker.Faker;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class RandomDataGenerator {
    public static Faker faker = new Faker();
    public static String getRandomDataFor(RandomDataTypeNames dataTypeNames){
        switch (dataTypeNames){
            case FIRSTNAME:
                return faker.name().firstName();
            case LASTNAME:
                return faker.name().lastName();
            case TOTALPRICE:
                return faker.number().digits(4);
            case DEPOSITPAID:
                return faker.number().digits(4);
            case CHECKIN:
                return String.valueOf(faker.date().future(1, TimeUnit.of(ChronoUnit.DAYS)));
            case CHECKOUT:
                return String.valueOf(faker.date().future(3, TimeUnit.of(ChronoUnit.DAYS)));
            case ADDITIONALNEEDS:
                return faker.name().name();
            default:
                return "data is not available";
        }
    }

}
