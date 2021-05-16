package com.example.backend.entity;

import com.example.backend.model.ServerInfo;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Bookings extends ServerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id_nr")
    private long userIdNr;

    @Column(name = "booking_id")
    private String bookingId;

    @Column(name = "api_id")
    private String apiId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_time")
    private String dateTime;

    //TODO remove data duplication, tie to flights table instead with ID's
    @Column(name = "provider_price")
    private double providerPrice;

    @Column(name = "travel_time")
    private long travelTime;

    @Column(name = "provider_flight_end")
    private String providerFlightEnd;

    @Column(name = "provider_flight_start")
    private String providerFlightStart;

    @Column(name = "provider_company_name")
    private String providerCompanyName;

    public String getProviderFlightEnd() {
        return providerFlightEnd;
    }

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

    public double getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(long travelTime) {
        this.travelTime = travelTime;
    }

    public String getProviderFlightEnd(String providerFlightEnd) {
        return this.providerFlightEnd;
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
}

