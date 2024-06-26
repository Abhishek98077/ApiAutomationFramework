package org.example.modules;

import com.google.gson.Gson;
import org.example.payloads.pojos.*;

public class PayloadManager {

    Gson gson;

    public String createPayload() {
        Booking booking = new Booking();
        booking.setFirstname("Shantaniu");
        booking.setLastname("Raju");
        booking.setTotalprice(5000);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-8-15");
        bookingdates.setCheckout("2024-8-19");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("lunch");

        gson = new Gson();
        String jsonStringOfBookind = gson.toJson(booking);
        System.out.println(jsonStringOfBookind);
        return jsonStringOfBookind;
    }

    public String setToken(){

        Auth_payload auth = new Auth_payload();
        auth.setUsername("admin");
        auth.setPassword("password123");
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(auth);
//        System.out.println("here is null" +jsonStringBooking);
        return jsonStringBooking;
    }


    public String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse,TokenResponse.class);
        return  tokenResponse1.getToken();
    }

    public BookingResponse bookingResponseJava(String responseString){
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString,BookingResponse.class);
        return bookingResponse;
    }

}
