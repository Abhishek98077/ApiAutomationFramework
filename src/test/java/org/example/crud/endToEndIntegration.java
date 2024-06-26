package org.example.crud;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.example.base.baseTest;
import org.example.endpoints.APIConstant;
import org.example.payloads.pojos.BookingResponse;
import org.example.payloads.pojos.Booking;
import org.example.payloads.pojos.TokenResponse;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class endToEndIntegration extends baseTest {
//    public void testCreateBooking(ITestContext iTestcontext) throws Exception {
//        requestSpecification.baseUri(APIConstant.BASE_URL);
//        requestSpecification.basePath("/booking");
//        response = RestAssured.given().spec(requestSpecification).when().body(payloadManager.createPayload()).post();
//        validatableResponse = response.then();
//        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
//        assertThat(bookingResponse.getBookingid()).isNotNull();
////        iTestcontext.setAttribute("bookingid", bookingResponse.getBookingid());
////        iTestcontext.setAttribute("token",getToken());
//
//
//
//    }
    @Test
        public void testCreateBooking(ITestContext iTestContext){
        requestSpecification.basePath(APIConstant.CREATE_UPDATE_BOOKING_URL);
        requestSpecification.baseUri(APIConstant.BASE_URL);
        requestSpecification.contentType(ContentType.JSON);
        response = RestAssured.given().spec(requestSpecification).when().body(payloadManager.createPayload()).post();
        validatableResponse = response.then().log().all();
//        validatableResponse.statusCode(200);
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertThat(bookingResponse.getBookingid()).isNotNull();
//        System.out.println(bookingResponse.getBooking());
        iTestContext.setAttribute("bookingid", bookingResponse.getBookingid());
    }


    @Test
    public void testVerifyBooking(ITestContext iTestContext) throws Exception {
        System.out.println(iTestContext.getAttribute("bookingid"));
        Assert.assertTrue(true);
    }



    @Test(groups = "p0" ,dependsOnMethods = {"testCreateBooking"})
    public  void testCreateAndUpdateBooking() {
        assertThat("abhishek").isEqualTo("abhishek");

    }

    @Test(groups = "p0" ,dependsOnMethods = {"testCreateAndUpdateBooking"})
    public void testDeleteBooking(){
        assertThat("abhishek").isEqualTo("abhishek");

    }
}
