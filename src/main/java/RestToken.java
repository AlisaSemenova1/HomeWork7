import io.restassured.http.ContentType;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestToken {
    static String baseUri = "https://restful-booker.herokuapp.com/auth";

    public static Response addNullToken(String body, int status) {
        return RestAssured.given()
                .baseUri(baseUri)
                .body(body)
                .contentType(ContentType.JSON)
                .post(baseUri)
                .then()
                .statusCode(status)
                .extract()
                .response();
    }

    public static String addToken(String body, int status) {
        return RestToken.addNullToken(body, status)
                .path("token")
                .toString();
    }
}



