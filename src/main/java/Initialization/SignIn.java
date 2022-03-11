package Initialization;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utils.RequestBase;

import static io.restassured.RestAssured.given;

public class SignIn extends RequestBase {
    Data data = new Data();
    public String username = data.getUser();
    public String password = data.getPassword();
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
        return token.jsonPath().getString("token");
    }
}
