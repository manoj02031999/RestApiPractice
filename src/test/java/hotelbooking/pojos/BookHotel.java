package hotelbooking.pojos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookHotel {
    private String firstname;
    private String lastname;
    private String totalprice;
    private Boolean depositpaid;
    private String checkin;
    private String checkout;
    private String additionalneeds;

}
