package hotelbooking.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BookHotel {
    private String firstname = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME);
    private String lastname = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.LASTNAME);
    private String totalprice = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.TOTALPRICE);
    private Boolean depositpaid = RandomDataGenerator.getRandomDataForDeposit(RandomDataTypeNames.DEPOSITPAID);
    private String checkin = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECKIN);
    private String checkout = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECKOUT);
    private String additionalneeds = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.ADDITIONALNEEDS);

}
