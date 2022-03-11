package utils;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBase {

    public static RequestSpecification specRequest;
    public static RequestSpecBuilder reqBuilder;

    public static String path;

    String baseUrl = "https://restful-booker.herokuapp.com/";

    public RequestBase() {
        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        this.reqBuilder = reqBuilder;
        this.path = "booking/";
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void createRequest(){
        reqBuilder.setBaseUri(baseUrl);
        reqBuilder.setBasePath(path);
        reqBuilder.setContentType(ContentType.JSON);
        specRequest = reqBuilder.build();
    }
}
