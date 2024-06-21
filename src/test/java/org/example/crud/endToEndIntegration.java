package org.example.crud;

import org.example.base.baseTest;
import org.testng.annotations.Test;

import static org.apache.velocity.tools.struts.StrutsUtils.getToken;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class endToEndIntegration extends baseTest {

    String token;

    //Create a booking
    //update the booking with token and id
    //1 Auth --api key
    //
    @Test(groups = "p0")
    public void testCreateBooking(){
        token = getToken();
        System.out.println(token);

    }



    @Test(groups = "p0" ,dependsOnMethods = {"testCreateBooking"})
    public  void testCreateAndUpdateBooking() {
        assertThat("abhishek").isEqualTo("abhishek");

    }

    @Test(groups = "p0" ,dependsOnMethods = {"testCreateAndUpdateBooking"})
    public void testDeleteBooking(){
        assertThat("abhishek").isEqualTo("abhishek");
        assertThat("abhishek").isEqualTo("abhishek");

    }
}
