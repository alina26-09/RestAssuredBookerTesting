package Initialization;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utils.RequestBase;
import utils.RestApiRequests;

import static io.restassured.RestAssured.given;

public class SignIn extends RequestBase {
    public String username = "admin";
    public String password = "password123";
    public String baseUrl = "https://restful-booker.herokuapp.com/";

    public String auth() {
        JSONObject signin = new JSONObject();
        signin.put("username", username);
        signin.put("password", password);

        Response token = given()
                .contentType(ContentType.JSON)
                .body(signin.toJSONString())
                .baseUri(baseUrl)
                .when()
                .post("auth")
                .then().extract().response();
        System.out.println(token.jsonPath().getString("token"));
        return token.jsonPath().getString("token");
    }
}
