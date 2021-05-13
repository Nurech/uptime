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

