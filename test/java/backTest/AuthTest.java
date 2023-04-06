package backTest;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasKey;

public class AuthTest extends AbstractTest {

    @Test
    void positiveAuthTest() {
        Specifications.installSpecifications(Specifications.auth(), Specifications.responseUnique(200));
        Response response = given()
                .formParam("username", getValidUsername())
                .formParam("password", getValidPassword())
                .when()
                .post()
                .then()
                .body("username", equalTo(getValidUsername()))
                .body("$", hasKey("id"))
                .body("$", hasKey("token"))
                .extract().response();
    }

    @Test
    void negativeAuthTest() {
        Specifications.installSpecifications(Specifications.auth(), Specifications.responseUnique(401));
        Response response = given()
                .formParam("username", getInvalidUsername())
                .formParam("password", getInvalidPassword())
                .when()
                .post()
                .then()
                .body("$", not(hasKey("token")))
                .body("$", hasKey("error"))
                .extract().response();
    }

    @Test
    void authWithEmptyLoginTest() {
        Specifications.installSpecifications(Specifications.auth(), Specifications.responseUnique(401));
        Response response = given()
                .formParam("username", "")
                .formParam("password", getValidPassword())
                .when()
                .post()
                .then()
                .body("$", not(hasKey("token")))
                .body("$", hasKey("error"))
                .extract().response();
    }

}
