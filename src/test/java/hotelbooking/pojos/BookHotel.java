package hotelbooking.pojos;

import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

public class BookHotel {
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public BookHotel() {
        this.firstname = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME);
        this.lastname = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.LASTNAME);
        this.totalprice = RandomDataGenerator.getRandomDataForTotalPrice(RandomDataTypeNames.TOTALPRICE);
        this.depositpaid = RandomDataGenerator.getRandomDataForDeposit(RandomDataTypeNames.DEPOSITPAID);
        this.bookingdates = new BookingDates(
                RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECKIN),
                RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECKOUT)
        );
        this.additionalneeds = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.ADDITIONALNEEDS);
    }

    public BookHotel(String firstname, String lastname, Integer totalprice, Boolean depositpaid, BookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public static class BookingDates {
        private String checkin;
        private String checkout;

        public BookingDates() {
            this.checkin = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECKIN);
            this.checkout = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECKOUT);
        }

        public BookingDates(String checkin, String checkout) {
            this.checkin = checkin;
            this.checkout = checkout;
        }

        public String getCheckin() {
            return checkin;
        }

        public void setCheckin(String checkin) {
            this.checkin = checkin;
        }

        public String getCheckout() {
            return checkout;
        }

        public void setCheckout(String checkout) {
            this.checkout = checkout;
        }

    }
}
/*
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
    // private String gender = Stream.of("male","female","others").findAny().get(); // to get a gender
    private String firstname = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME);
    private String lastname = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.LASTNAME);
    private Integer totalprice = RandomDataGenerator.getRandomDataForTotalPrice(RandomDataTypeNames.TOTALPRICE);
    private Boolean depositpaid = RandomDataGenerator.getRandomDataForDeposit(RandomDataTypeNames.DEPOSITPAID);
    private BookingDates bookingdates;
    // private String checkin = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECKIN);
    // private String checkout = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECKOUT);
    private String additionalneeds = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.ADDITIONALNEEDS);

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class BookingDates {
        private String checkin = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECKIN);
        private String checkout = RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CHECKOUT);
    }

}
*/

