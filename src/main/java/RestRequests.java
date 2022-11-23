import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestRequests {
    static String baseUri = "https://restful-booker.herokuapp.com/booking/";

    public static Response addBooking(String body, int status) {
        return RestAssured.given()
                .baseUri(baseUri)
                .log()
                .body(true)
                .body(body)
                .contentType(ContentType.JSON)
                .post(baseUri)
                .then()
                .statusCode(status)
                .extract()
                .response();
    }

    public static String addBookingAndGetId(String body, int status) {
        return RestRequests.addBooking(body, status)
                .path("bookingid")
                .toString();
    }

    public static String findById(String id, int status) {
        return RestAssured.given()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .get(id)
                .then()
                .statusCode(status)
                .extract()
                .response()
                .toString();
    }

    public static String findById(String id) {
        return findById(id, 200);
    }

    public static String updateBooking(String body) {
        return RestAssured.given()
                .baseUri(baseUri)
                .body(body)
                .log()
                .body(true)
                .contentType(ContentType.JSON)
                .post(baseUri)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .toString();
    }

    public static Response deleteBooking(String id, String token, int status) {
        return RestAssured.given()
                .baseUri(baseUri)
                .headers("Cookie", "token=" + token)
                .when()
                .delete(id)
                .then()
                .log()
                .body()
                .statusCode(status)
                .extract()
                .response();
    }
}
