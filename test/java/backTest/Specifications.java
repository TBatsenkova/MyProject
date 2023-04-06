package backTest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

import static backTest.AbstractTest.*;


public class Specifications {
    public static RequestSpecification auth() {
        return new RequestSpecBuilder()
                .setBaseUri(getAuthUrl())
                .setContentType("application/x-www-form-urlencoded; charset=UTF-8")
                .build();
    }

    public static RequestSpecification getMyPost() {
        return new RequestSpecBuilder()
                .addHeader("X-Auth-Token", getToken())
                .setContentType(ContentType.JSON)
                .setBaseUri(getPostUrl())
                .build();
    }

    public static RequestSpecification getNotMyPost() {
        return new RequestSpecBuilder()
                .addHeader("X-Auth-Token", getToken())
                .addQueryParam("owner", "notMe")
                .setContentType(ContentType.JSON)
                .setBaseUri(getPostUrl())
                .build();
    }

    public static ResponseSpecification responseUnique(int status) {
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .expectResponseTime(Matchers.lessThan(5000L))
                .build();
    }

    public static void installSpecifications(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
        RestAssured.registerParser("text/plain", Parser.JSON);
    }
}
