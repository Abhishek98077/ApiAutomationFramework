package org.example.modules;

import com.google.gson.Gson;
import org.example.payloads.pojos.Booking;
import org.example.payloads.pojos.Bookingdates;

public class PayloadManager {

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

        Gson gson = new Gson();
        String jsonStringOfBookind = gson.toJson(booking);

        System.out.println(jsonStringOfBookind);


        return jsonStringOfBookind;
    }
}
