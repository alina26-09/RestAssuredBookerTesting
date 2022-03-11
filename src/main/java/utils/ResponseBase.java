package utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

public class ResponseBase {
    public ResponseSpecification responseSpec;
    public ResponseSpecBuilder responseBuilder;

    public ResponseBase() {
       ResponseSpecBuilder response = new ResponseSpecBuilder();
        this.responseBuilder = response;
    }

    public void createResponse(String statusCode) {
        responseSpec = responseBuilder.build();
        switch(statusCode.toUpperCase()) {
            case "ok" : responseSpec = responseBuilder.expectStatusCode(HttpStatus.SC_OK).build();
            case "created" : responseSpec = responseBuilder.expectStatusCode(HttpStatus.SC_CREATED).build();
        }
    }



}
