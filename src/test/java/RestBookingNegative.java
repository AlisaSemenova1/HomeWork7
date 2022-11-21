
import org.junit.Test;

import java.util.logging.Logger;

public class RestBookingNegative {

    @Test
    public void addNullToken() {
        RestToken.addToken("password : password123456");
    }

    @Test
    public void addNullBookingId() {
        RestRequests.addBookingId("firstname : Василий");
    }

    @Test
    public void findByNullId() {
        RestRequests.findById("bookingid:000000007");
    }

    @Test
    public void deleteByNullId() {
        RestRequests.deleteBooking("20000000", "0");
    }
}
