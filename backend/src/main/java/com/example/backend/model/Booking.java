package com.example.backend.model;

public class Booking {

    private long userIdNr;
    private String bookingId;
    private String apiId;
    private String firstName;
    private String lastName;
    private String isValidPrice;

    public long getUserIdNr() {
        return userIdNr;
    }

    public void setUserIdNr(long userIdNr) {
        this.userIdNr = userIdNr;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIsValidPrice() {
        return isValidPrice;
    }

    public void setIsValidPrice(String isValidPrice) {
        this.isValidPrice = isValidPrice;
    }
}
