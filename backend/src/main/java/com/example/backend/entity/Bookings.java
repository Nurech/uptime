package com.example.backend.entity;

import com.example.backend.model.ServerInfo;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Bookings extends ServerInfo {

    @Id
    @Column(name = "user_id")
    private long rowId;

    @Column(name = "booking_id")
    private String id;

    @Column(name = "first_name")
    private String validUntil;

    @Column(name = "last_name")
    private String legsId;

    public long getRowId() {
        return rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getValidUntil() {
        return validUntil;
    }

    @Override
    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public String getLegsId() {
        return legsId;
    }

    public void setLegsId(String legsId) {
        this.legsId = legsId;
    }
}

