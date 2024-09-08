package tests;

import api.Arguments;
import dev.failsafe.internal.util.Assert;
import io.restassured.http.ContentType;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class EchoApiTest {
    @Test
    public void testGet(){
        //Pojo class
        Arguments arguments = given()
                .baseUri("https://postman-echo.com")
                .param("names", "Dorothea", "Rose", "Blanche", "Sophia")
                .param("nums", 1, 3, 2, 4)
                .when()
                .contentType(ContentType.JSON)
                .get("/get")
                .then().assertThat().statusCode(200)
                .and().log().all()
                .extract().body().jsonPath().getObject("args",Arguments.class);

        Assertions.assertEquals(Arrays.asList("Dorothea", "Rose", "Blanche", "Sophia"),
                arguments.getNames());
        Assertions.assertEquals(Arrays.asList(1, 3, 2, 4), arguments.getNums());
    }

    @Test
    public void testPostAndPutAndDelete(){
        Map<String,String> person = new HashMap<>();
        person.put("name", "Mickle");
        given()
                .baseUri("https://postman-echo.com")
                .body(person)
                .contentType(ContentType.JSON)
                .when()
                .post("/post")
                .then().assertThat().statusCode(200)
                .and()
                .body("data.name", equalTo("Mickle"))
                .and().log().all();

        Map<String, String> updatedPerson = new HashMap<>();
        updatedPerson.put("name", "John");

        //With Response interface
        Response response = given()
                .baseUri("https://postman-echo.com")
                .body(updatedPerson)
                .contentType(ContentType.JSON)
                .when()
                .put("/put")
                .then()
                .assertThat().statusCode(200)
                .and().log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        String name = jsonPath.get("data.name");
        Assertions.assertEquals("John", name);

        //delete
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .delete("/delete")
                .then()
                .assertThat().statusCode(200)
                .and().body("json",nullValue());
    }
}
