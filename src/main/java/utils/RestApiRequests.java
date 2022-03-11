package utils;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class RestApiRequests extends RequestBase{
    public RequestBase base = new RequestBase();
    public ResponseBase responseExpOk = new ResponseBase();
    public ResponseBase responseExpCreated = new ResponseBase();


    public RestApiRequests() {
        base.createRequest();
        responseExpOk.createResponse("OK");
        responseExpCreated.createResponse("created");
    }

    public Response getAllBooks() {
        Response response = given()
                .spec(specRequest)
                .get()
                .then()
                .spec(responseExpOk.responseSpec)
                .extract().response();
        return response;
    }

    public Response getBookingById(String id) {
        Response response = given()
                .spec(specRequest)
                .get(id)
                .then()
                .spec(responseExpOk.responseSpec)
                .extract().response();
        return response;
    }

    public Response postBooking(String body) {
        Response response = given()
                .spec(specRequest)
                .body(body)
                .post()
                .then()
                .spec(responseExpCreated.responseSpec)
                .extract().response();
        return response;
    }

    public Response updateBooking(String body, String id, String token) {
        Response updatedBooking = given()
                .spec(specRequest)
                .header("cookie", "token=" + token)
                .body(body)
                .put(id)
                .then()
                .spec(responseExpCreated.responseSpec)
                .extract().response();
        return updatedBooking;
    }

    public Response deleteBooking(String id, String token) {
        Response deletedBooking = given()
                .spec(specRequest)
                .header("cookie", "token=" + token)
                .delete(id)
                .then()
                .spec(responseExpCreated.responseSpec)
                .extract().response();
        return deletedBooking;
    }
}
