package com.example.backend.model;

public class Booking {

    private long userIdNr;
    private String bookingId;
    private String apiId;
    private String firstName;
    private String lastName;
    private String isValidPrice;
    private String dateTime;
    private double providerPrice;
    private long travelTime;
    private String providerFlightEnd;
    private String providerFlightStart;
    private String providerCompanyName;

    public String getProviderCompanyName() {
        return providerCompanyName;
    }

    public void setProviderCompanyName(String providerCompanyName) {
        this.providerCompanyName = providerCompanyName;
    }

    public double getProviderPrice() {
        return providerPrice;
    }

    public void setProviderPrice(double providerPrice) {
        this.providerPrice = providerPrice;
    }

    public long getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(long travelTime) {
        this.travelTime = travelTime;
    }

    public String getProviderFlightEnd() {
        return providerFlightEnd;
    }

    public void setProviderFlightEnd(String providerFlightEnd) {
        this.providerFlightEnd = providerFlightEnd;
    }

    public String getProviderFlightStart() {
        return providerFlightStart;
    }

    public void setProviderFlightStart(String providerFlightStart) {
        this.providerFlightStart = providerFlightStart;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

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
