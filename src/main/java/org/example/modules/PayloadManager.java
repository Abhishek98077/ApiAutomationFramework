package org.example.modules;

import com.google.gson.Gson;
import org.example.payloads.pojos.Auth_payload;
import org.example.payloads.pojos.Booking;
import org.example.payloads.pojos.Bookingdates;
import org.example.payloads.pojos.TokenResponse;

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
        System.out.println(jsonStringBooking);
        return jsonStringBooking;
    }

//    public String getTokenFromJSON(String TokenResponse){
//        Gson gson = new Gson();
//       TokenResponse = gson.fromJson(TokenResponse, TokenResponse.getClass());
//       return TokenResponse.getToken();
//    }

    public String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse,TokenResponse.class);
        return  tokenResponse1.getToken();
    }

//    public String getTokenFromJson(String tokenResponse){
//        gson = new Gson();
//        TokenResponse tokenResponse1 =gson.fromJson(tokenResponse,TokenResponse.class);
//    return tokenResponse1,getToken();
//    }
}
