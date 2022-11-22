import io.restassured.http.ContentType;
import io.restassured.RestAssured;

public class RestToken {
    static String baseUri = "https://restful-booker.herokuapp.com/auth";

    public static String addToken(String body) {
        return RestAssured.given()
                .baseUri(baseUri)
                .body(body)
                .contentType(ContentType.JSON)
                .post(baseUri)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .path("token")
                .toString();
    }

    public static String addNullToken(String body) {
        return RestAssured.given()
                .baseUri(baseUri)
                .body(body)
                .contentType(ContentType.JSON)
                .post(baseUri)
                .then()
                .statusCode(400)
                .extract()
                .response()
                .toString();
    }
}



