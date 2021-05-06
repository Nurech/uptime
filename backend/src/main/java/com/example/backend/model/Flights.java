package com.example.backend.model;

import javax.persistence.*;


@Entity
@Table(name = "flights")
public class Flights {

    // PrimaryKey
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long rowId;
    private String id;
    private String validUntil;
    private String legsId;
    private String legsRouteInfoId;
    private String legsRouteInfoFromId;
    private String legsRouteInfoFromName;
    private String legsRouteInfoToId;
    private String legsRouteInfoToName;
    private String legsRouteInfoDistance;
    private String legsProvidersId;
    private String legsProvidersCompanyId;
    private String legsProvidersCompanyName;
    private String legsProvidersPrice;
    private String legsProvidersFlight_start;
    private String legsProvidersFlight_end;

    public Flights() {

    }

    public long getRowId() {
        return rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public String getLegsId() {
        return legsId;
    }

    public void setLegsId(String legsId) {
        this.legsId = legsId;
    }

    public String getLegsRouteInfoId() {
        return legsRouteInfoId;
    }

    public void setLegsRouteInfoId(String legsRouteInfoId) {
        this.legsRouteInfoId = legsRouteInfoId;
    }

    public String getLegsRouteInfoFromId() {
        return legsRouteInfoFromId;
    }

    public void setLegsRouteInfoFromId(String legsRouteInfoFromId) {
        this.legsRouteInfoFromId = legsRouteInfoFromId;
    }

    public String getLegsRouteInfoFromName() {
        return legsRouteInfoFromName;
    }

    public void setLegsRouteInfoFromName(String legsRouteInfoFromName) {
        this.legsRouteInfoFromName = legsRouteInfoFromName;
    }

    public String getLegsRouteInfoToId() {
        return legsRouteInfoToId;
    }

    public void setLegsRouteInfoToId(String legsRouteInfoToId) {
        this.legsRouteInfoToId = legsRouteInfoToId;
    }

    public String getLegsRouteInfoToName() {
        return legsRouteInfoToName;
    }

    public void setLegsRouteInfoToName(String legsRouteInfoToName) {
        this.legsRouteInfoToName = legsRouteInfoToName;
    }

    public String getLegsRouteInfoDistance() {
        return legsRouteInfoDistance;
    }

    public void setLegsRouteInfoDistance(String legsRouteInfoDistance) {
        this.legsRouteInfoDistance = legsRouteInfoDistance;
    }

    public String getLegsProvidersId() {
        return legsProvidersId;
    }

    public void setLegsProvidersId(String legsProvidersId) {
        this.legsProvidersId = legsProvidersId;
    }

    public String getLegsProvidersCompanyId() {
        return legsProvidersCompanyId;
    }

    public void setLegsProvidersCompanyId(String legsProvidersCompanyId) {
        this.legsProvidersCompanyId = legsProvidersCompanyId;
    }

    public String getLegsProvidersCompanyName() {
        return legsProvidersCompanyName;
    }

    public void setLegsProvidersCompanyName(String legsProvidersCompanyName) {
        this.legsProvidersCompanyName = legsProvidersCompanyName;
    }

    public String getLegsProvidersPrice() {
        return legsProvidersPrice;
    }

    public void setLegsProvidersPrice(String legsProvidersPrice) {
        this.legsProvidersPrice = legsProvidersPrice;
    }

    public String getLegsProvidersFlight_start() {
        return legsProvidersFlight_start;
    }

    public void setLegsProvidersFlight_start(String legsProvidersFlight_start) {
        this.legsProvidersFlight_start = legsProvidersFlight_start;
    }

    public String getLegsProvidersFlight_end() {
        return legsProvidersFlight_end;
    }

    public void setLegsProvidersFlight_end(String legsProvidersFlight_end) {
        this.legsProvidersFlight_end = legsProvidersFlight_end;
    }

    public Flights(long rowId, String id, String validUntil, String legsId, String legsRouteInfoId, String legsRouteInfoFromId, String legsRouteInfoFromName, String legsRouteInfoToId, String legsRouteInfoToName, String legsRouteInfoDistance, String legsProvidersId, String legsProvidersCompanyId, String legsProvidersCompanyName, String legsProvidersPrice, String legsProvidersFlight_start, String legsProvidersFlight_end) {
        this.rowId = rowId;
        this.id = id;
        this.validUntil = validUntil;
        this.legsId = legsId;
        this.legsRouteInfoId = legsRouteInfoId;
        this.legsRouteInfoFromId = legsRouteInfoFromId;
        this.legsRouteInfoFromName = legsRouteInfoFromName;
        this.legsRouteInfoToId = legsRouteInfoToId;
        this.legsRouteInfoToName = legsRouteInfoToName;
        this.legsRouteInfoDistance = legsRouteInfoDistance;
        this.legsProvidersId = legsProvidersId;
        this.legsProvidersCompanyId = legsProvidersCompanyId;
        this.legsProvidersCompanyName = legsProvidersCompanyName;
        this.legsProvidersPrice = legsProvidersPrice;
        this.legsProvidersFlight_start = legsProvidersFlight_start;
        this.legsProvidersFlight_end = legsProvidersFlight_end;
    }
}
