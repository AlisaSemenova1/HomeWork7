import org.junit.Test;
import java.util.logging.Logger;

public class RestBookingNegativeTest {
    Logger logger = Logger.getLogger(RestBookingTest.class.getName());

    @Test
    public void addNullToken() {
        RestToken.addNullToken("password : password123456");
        logger.info("Неверный пароль");
    }

    @Test
    public void addNullBookingId() {
        RestRequests.addNullBookingId("firstname : Василий");
        logger.info("Неверное имя");
    }

    @Test
    public void findByNullId() {
        RestRequests.findByNullId("bookingId:000000007");
        logger.info("Неверный id");
    }

    @Test
    public void deleteByNullId() {
        RestRequests.deleteNullBooking("20000000", "0");
        logger.info("Несуществующий id");
    }
}


