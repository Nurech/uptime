package com.example.backend.model;

public class FlightsObject {

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
    private String legsProvidersFlightStart;
    private String legsProvidersFlightEnd;

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

    public String getLegsProvidersFlightStart() {
        return legsProvidersFlightStart;
    }

    public void setLegsProvidersFlightStart(String legsProvidersFlightStart) {
        this.legsProvidersFlightStart = legsProvidersFlightStart;
    }

    public String getLegsProvidersFlightEnd() {
        return legsProvidersFlightEnd;
    }

    public void setLegsProvidersFlightEnd(String legsProvidersFlightEnd) {
        this.legsProvidersFlightEnd = legsProvidersFlightEnd;
    }
}
