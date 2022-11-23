import org.junit.Test;

import java.util.logging.Logger;

public class RestBookingNegativeTest {
    Logger logger = Logger.getLogger(RestBookingTest.class.getName());

    @Test
    public void addNullToken() {
        RestToken.addNullToken("password : password123456", 400);
        logger.info("Неверный пароль");
    }

    @Test
    public void addNullBooking() {
        RestRequests.addBooking("firstname : Василий", 400);
        logger.info("Неверное имя");
    }

    @Test
    public void findByNullId() {
        RestRequests.findById("bookingId:000000007", 404);
        logger.info("Неверный id");
    }

    @Test
    public void deleteByNullId() {
        RestRequests.deleteBooking("20000000", "0", 403);
        logger.info("Несуществующий id");
    }
}


