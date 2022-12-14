import java.util.logging.Logger;
import org.junit.Test;

    public class RestBooking {

        Logger logger
                = Logger.getLogger(
               RestBooking.class.getName());

        @Test
        public void addToken() {
            String bodyAdd = "{\n" +
                    "    \"username\" : \"admin\",\n" +
                    "    \"password\" : \"password123\"\n" +
                    "}";

            String token = RestToken.addToken(bodyAdd);
            logger.info("token " + token);
        }

        String bodyAddBooking = "{\n" +
                "    \"firstname\" : \"Иван\",\n" +
                "    \"lastname\" : \"Иванов\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2022-11-20\",\n" +
                "        \"checkout\" : \"2022-11-21\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        @Test
        public void addBookingId() {
            String id = RestRequests.addBookingId(bodyAddBooking);
            logger.info("Создано бронирование с id " + id);

            RestRequests.findById(id);
            logger.info("Проверка бронирования с id " + id);
        }

        @Test
        public void updateBooking() {
            String bodyUpdateBooking = " {\n" +
                    "            \"firstname\": \"Иван\",\n" +
                    "                \"lastname\": \"Иванов\",\n" +
                    "                \"totalprice\": 333,\n" +
                    "                \"depositpaid\": true,\n" +
                    "                \"bookingdates\": {\n" +
                    "            \"checkin\": \"2022-11-20\",\n" +
                    "                    \"checkout\": \"2022-11-23\"\n" +
                    "        },\n" +
                    "            \"additionalneeds\": \"Breakfast\"\n" +
                    "        }";

            String id = RestRequests.addBookingId(bodyAddBooking);
            logger.info("Создано бронирование с id " + id);

            RestRequests.updateBooking(bodyUpdateBooking);
            logger.info("Обновленное бронирование c id " + id);

            RestRequests.findById(id);
            logger.info("Проверка бронирования с id " + id);
        }

        @Test
        public void deleteBooking() {
            String bodyAdd = "{\n" +
                    "    \"username\" : \"admin\",\n" +
                    "    \"password\" : \"password123\"\n" +
                    "}";

            String token = RestToken.addToken(bodyAdd);

            String id = RestRequests.addBookingId(bodyAddBooking);
            logger.info("Создано бронирование с id " + id);

            RestRequests.findById(id);

            RestRequests.deleteBooking(id, token);
            logger.info("Удалили бронирование с id " + id);

            RestRequests.findById(id, 404);
            logger.info("Бронирование с id " + id + " удалено.");
        }
    }
