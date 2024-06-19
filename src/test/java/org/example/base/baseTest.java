package org.example.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.modules.PayloadManager;
import org.testng.annotations.BeforeMethod;

public class baseTest {

    public RequestSpecification requestSpecification;
    public ValidatableResponse validatableResponse;
    public AssertionError assertionError;
    public PayloadManager payloadManager;
    public Response response;


    @BeforeMethod
    public void setUpConfig() {
        payloadManager = new PayloadManager();
        requestSpecification = RestAssured.given();




    }
}
