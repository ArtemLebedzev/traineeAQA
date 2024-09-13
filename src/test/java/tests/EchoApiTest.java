package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class EchoApiTest {
    private static final String baseUri = "https://postman-echo.com";

    @Test
    public void testGet(){
        Response response = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2","bar2")
                .when()
                .get(baseUri + "/get")
                .then()
                .assertThat().statusCode(200)
                .log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        Assertions.assertAll(
                //args
                () -> Assertions.assertEquals("bar1", jsonPath.getString("args.foo1")),
                () -> Assertions.assertEquals("bar2", jsonPath.getString("args.foo2")),
                // headers
                () -> Assertions.assertEquals("postman-echo.com", jsonPath.getString("headers.host")),
                () -> Assertions.assertEquals("https", jsonPath.getString("headers.x-forwarded-proto")),
                () -> Assertions.assertEquals("close", jsonPath.getString("headers.connection")),
                () -> Assertions.assertNotNull(jsonPath.getString("headers.x-forwarded-port")),
                () -> Assertions.assertNotNull(jsonPath.getString("headers.accept-encoding")),
                () -> Assertions.assertNotNull(jsonPath.getString("headers.accept")),
                () -> Assertions.assertNotNull(jsonPath.getString("headers.user-agent")),
                () -> Assertions.assertNotNull(jsonPath.getString("headers.x-amzn-trace-id")),
                () -> Assertions.assertNotNull(jsonPath.getString("headers.x-request-start")),
                //url
                () -> Assertions.assertEquals("https://postman-echo.com/get?foo1=bar1&foo2=bar2", jsonPath.getString("url"))
        );
    }

    @Test
    public void testPostRawText (){
        Response response = given()
                .contentType("text/plain")
                .body("{\n    \"foo\": \"bar\"\n}")
                .when()
                .post(baseUri + "/post")
                .then()
                .assertThat().statusCode(200)
                .log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assertions.assertAll(
                () -> Assertions.assertTrue(jsonPath.getMap("args").isEmpty()),
                () -> Assertions.assertEquals("{\n    \"foo\": \"bar\"\n}", jsonPath.getString("data")),
                () -> Assertions.assertTrue(jsonPath.getMap("files").isEmpty()),
                () -> Assertions.assertTrue(jsonPath.getMap("form").isEmpty()),

                () -> Assertions.assertEquals("text/plain; charset=ISO-8859-1", jsonPath.get("headers.content-type")),
                () -> Assertions.assertNotNull(jsonPath.getString("headers.content-length")),

                () -> Assertions.assertNull(jsonPath.getString("json")),

                () -> Assertions.assertEquals("https://postman-echo.com/post", jsonPath.getString("url"))
        );
    }

    @Test
    public void testPostFormData (){
        Map<String, String> formParams = new HashMap<>();
        formParams.put("foo1", "bar1");
        formParams.put("foo2", "bar2");

        Response response = given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParams(formParams)
                .when()
                .post(baseUri + "/post")
                .then()
                .assertThat().statusCode(200)
                .log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assertions.assertAll(
                () -> Assertions.assertTrue(jsonPath.getMap("args").isEmpty()),
                () -> Assertions.assertEquals("", jsonPath.getString("data")),
                () -> Assertions.assertTrue(jsonPath.getMap("files").isEmpty()),
                () -> Assertions.assertEquals("bar1", jsonPath.getString("form.foo1")),
                () -> Assertions.assertEquals("bar2", jsonPath.getString("form.foo2")),

                () -> Assertions.assertEquals("application/x-www-form-urlencoded; charset=utf-8", jsonPath.get("headers.content-type")),
                () -> Assertions.assertNotNull(jsonPath.getString("headers.content-length")),

                () -> Assertions.assertEquals("bar1", jsonPath.getString("json.foo1")),
                () -> Assertions.assertEquals("bar2", jsonPath.getString("json.foo2")),

                () -> Assertions.assertEquals("https://postman-echo.com/post", jsonPath.getString("url"))
        );
    }

    @Test
    public void testPut (){
        Response response = given()
                .contentType("text/plain; charset=ISO-8859-1")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put(baseUri + "/put")
                .then()
                .assertThat().statusCode(200)
                .log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assertions.assertAll(
                () -> Assertions.assertTrue(jsonPath.getMap("args").isEmpty()),
                () -> Assertions.assertEquals("This is expected to be sent back as part of response body.", jsonPath.getString("data")),
                () -> Assertions.assertTrue(jsonPath.getMap("files").isEmpty()),
                () -> Assertions.assertTrue(jsonPath.getMap("form").isEmpty()),

                () -> Assertions.assertEquals("text/plain; charset=ISO-8859-1", jsonPath.get("headers.content-type")),
                () -> Assertions.assertNotNull(jsonPath.getString("headers.content-length")),

                () -> Assertions.assertNull(jsonPath.getString("json")),

                () -> Assertions.assertEquals("https://postman-echo.com/put", jsonPath.getString("url"))
        );
    }

    @Test
    public void testPatch (){
        Response response = given()
                .contentType("text/plain; charset=ISO-8859-1")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch(baseUri + "/patch")
                .then()
                .assertThat().statusCode(200)
                .log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assertions.assertAll(
                () -> Assertions.assertTrue(jsonPath.getMap("args").isEmpty()),
                () -> Assertions.assertEquals("This is expected to be sent back as part of response body.", jsonPath.getString("data")),
                () -> Assertions.assertTrue(jsonPath.getMap("files").isEmpty()),
                () -> Assertions.assertTrue(jsonPath.getMap("form").isEmpty()),

                () -> Assertions.assertEquals("text/plain; charset=ISO-8859-1", jsonPath.get("headers.content-type")),
                () -> Assertions.assertNotNull(jsonPath.getString("headers.content-length")),

                () -> Assertions.assertNull(jsonPath.getString("json")),

                () -> Assertions.assertEquals("https://postman-echo.com/patch", jsonPath.getString("url"))
        );
    }

    @Test
    public void testDelete (){
        Response response = given()
                .contentType("text/plain; charset=ISO-8859-1")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete(baseUri + "/delete")
                .then()
                .assertThat().statusCode(200)
                .log().all()
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assertions.assertAll(
                () -> Assertions.assertTrue(jsonPath.getMap("args").isEmpty()),
                () -> Assertions.assertEquals("This is expected to be sent back as part of response body.", jsonPath.getString("data")),
                () -> Assertions.assertTrue(jsonPath.getMap("files").isEmpty()),
                () -> Assertions.assertTrue(jsonPath.getMap("form").isEmpty()),

                () -> Assertions.assertEquals("text/plain; charset=ISO-8859-1", jsonPath.get("headers.content-type")),
                () -> Assertions.assertNotNull(jsonPath.getString("headers.content-length")),

                () -> Assertions.assertNull(jsonPath.getString("json")),

                () -> Assertions.assertEquals("https://postman-echo.com/delete", jsonPath.getString("url"))
        );
    }
}
