package com.APIAutomationClass.modules;

import com.APIAutomationClass.pojos.*;
import com.google.gson.Gson;

public class PayloadManager {

    // Converting the Java object to String
    // GSON

    Gson gson;
    public String bookingPayloadFromPojoToString() {

        Booking booking = new Booking();
        booking.setFirstname("A.James1111");
        booking.setLastname("Brown1111");
        booking.setTotalprice(2220);
        booking.setDepositpaid(true);


        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2026-02-11");
        bookingDates.setCheckout("2026-02-17");
        booking.setBookingdates(bookingDates);

        booking.setAdditionalneeds("Diner 03");


        System.out.println(booking);

        gson = new Gson();
        String jsonStringPayload = gson.toJson(booking);
        System.out.println(jsonStringPayload);
        return jsonStringPayload;
    }
   // public String createPayloadBookingAsStringFromExcel () { return jsonStringPayload }
    public BookingResponse bookingResponseFromStringToObject(String  responseString ) {
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }

    public Booking  getResponseFromJSON(String getResponse) {
        Booking booking = gson.fromJson(getResponse, Booking.class);
        return booking;
    }

    public String setAuthPayload() {
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonStringAuthPayload = gson.toJson(auth);
        System.out.println(jsonStringAuthPayload);
        return jsonStringAuthPayload;

    }

    public String getTokenStringFromJSON(String tokenResponse) {
        gson = new Gson();
        TokenResponse tokenResponseTO = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponseTO.getToken();
    }
    public String updateBookingPayloadFromPojoToString() {
        Booking booking = new Booking();
        booking.setFirstname("A.James2222");
        booking.setLastname("Brown2222");
        booking.setTotalprice(3330);
        booking.setDepositpaid(true);


        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2026-02-13");
        bookingDates.setCheckout("2026-02-20");
        booking.setBookingdates(bookingDates);

        booking.setAdditionalneeds("Diner 04");


        System.out.println(booking);

        gson = new Gson();
        String jsonStringUpdatePayload = gson.toJson(booking);
        System.out.println(jsonStringUpdatePayload);
        return jsonStringUpdatePayload;
    }
}
