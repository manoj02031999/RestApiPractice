package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RandomDataGenerator {
    public static Faker faker = new Faker();
    static SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
    public static String getRandomDataFor(RandomDataTypeNames dataTypeNames){

        System.out.println("-------------- RandomDataGenerator CLASS  -------------------");
        switch (dataTypeNames){
            case FIRSTNAME:
                return faker.name().firstName();
            case LASTNAME:
                return faker.name().lastName();
 //           case TOTALPRICE:
 //               return faker.number().digits(4);
//            case DEPOSITPAID:
//                return faker.number().digits(4);
            case CHECKIN:
                Date randomCheckinDate = faker.date().future(1, TimeUnit.of(ChronoUnit.DAYS));
                String formatedCheckinDate = dateFormate.format(randomCheckinDate);
                return formatedCheckinDate;
                //return String.valueOf(faker.date().future(1, TimeUnit.of(ChronoUnit.DAYS)));
            case CHECKOUT:
                Date randomCheckoutDate = faker.date().future(3, TimeUnit.of(ChronoUnit.DAYS));
//                return dateFormate.format(randomCheckoutDate);
                String formatedCheckoutDate = dateFormate.format(randomCheckoutDate);
                return formatedCheckoutDate;
//                 return String.valueOf(faker.date().future(3, TimeUnit.of(ChronoUnit.DAYS)));
            case ADDITIONALNEEDS:
                return faker.name().name();
            default:
                return "data is not available";
        }

    }
    public static Boolean getRandomDataForDeposit(RandomDataTypeNames dataTypeNames){
        return faker.bool().bool();
    }

    public static Integer getRandomDataForTotalPrice(RandomDataTypeNames dataTypeNames){
       // return Integer.valueOf(faker.number().digits(4));
        return faker.number().numberBetween(1000,3000);
    }

    public static String getRandomDataForCheckinDate(RandomDataTypeNames dataTypeNames){
        Date randomCheckinDate = faker.date().future(1, TimeUnit.of(ChronoUnit.DAYS));
        String formatedCheckinDate = dateFormate.format(randomCheckinDate);
        return formatedCheckinDate;
    }

    public static String getRandomDataForCheckoutDate(RandomDataTypeNames dataTypeNames){
        Date randomCheckoutDate = faker.date().future(3, TimeUnit.of(ChronoUnit.DAYS));
//                return dateFormate.format(randomCheckoutDate);
        String formatedCheckoutDate = dateFormate.format(randomCheckoutDate);
        return formatedCheckoutDate;
    }

}
