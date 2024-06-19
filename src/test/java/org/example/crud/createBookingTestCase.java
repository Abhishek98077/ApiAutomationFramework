package org.example.crud;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.eclipse.sisu.Description;
import org.example.base.baseTest;
import org.example.endpoints.APIConstant;
import org.testng.annotations.Test;

public class createBookingTestCase extends baseTest {

    @Test
    public void testPositiveRequest(){
        requestSpecification.basePath(APIConstant.CREATE_UPDATE_BOOKING_URL);
        requestSpecification.baseUri(APIConstant.BASE_URL);
        requestSpecification.contentType(ContentType.JSON);
        response = RestAssured.given().spec(requestSpecification).when().body(payloadManager.createPayload()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }

}
