package org.example.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.action.assertAction;
import org.example.endpoints.APIConstant;
import org.example.modules.PayloadManager;
import org.testng.annotations.BeforeMethod;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class baseTest {

    public RequestSpecification requestSpecification;
    public ValidatableResponse validatableResponse;
    public PayloadManager payloadManager;
    public Response response;
    public assertAction assertAction;



    @BeforeMethod(alwaysRun = true)
    public void setUpConfig() {
        payloadManager = new PayloadManager();
        assertAction = new assertAction();
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstant.BASE_URL)
                .addHeader("ContentType","application/json")
                .build().log().all();

    }

    public String getToken(){
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification.baseUri(APIConstant.BASE_URL).basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        response = requestSpecification.when().post();
       String token = payloadManager.getTokenFromJSON(response.asString());
        System.out.println("Sir your token is :" +token);
       return token;
    }
}
