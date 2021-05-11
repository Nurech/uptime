package com.example.backend.model;

public class AllData {

    private long rowId;
    private String id;
    private String validUntil;
    private String legsId;
    private String routeId;
    private String routeFromId;
    private String routeFromName;
    private String routeToId;
    private String routeToName;
    private long routeDistance;
    private String providerId;
    private double providerPrice;
    private String providerFlightStart;
    private String providerFlightEnd;

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

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getRouteFromId() {
        return routeFromId;
    }

    public void setRouteFromId(String routeFromId) {
        this.routeFromId = routeFromId;
    }

    public String getRouteFromName() {
        return routeFromName;
    }

    public void setRouteFromName(String routeFromName) {
        this.routeFromName = routeFromName;
    }

    public String getRouteToId() {
        return routeToId;
    }

    public void setRouteToId(String routeToId) {
        this.routeToId = routeToId;
    }

    public String getRouteToName() {
        return routeToName;
    }

    public void setRouteToName(String routeToName) {
        this.routeToName = routeToName;
    }

    public long getRouteDistance() {
        return routeDistance;
    }

    public void setRouteDistance(long routeDistance) {
        this.routeDistance = routeDistance;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public double getProviderPrice() {
        return providerPrice;
    }

    public void setProviderPrice(double providerPrice) {
        this.providerPrice = providerPrice;
    }

    public String getProviderFlightStart() {
        return providerFlightStart;
    }

    public void setProviderFlightStart(String providerFlightStart) {
        this.providerFlightStart = providerFlightStart;
    }

    public String getProviderFlightEnd() {
        return providerFlightEnd;
    }

    public void setProviderFlightEnd(String providerFlightEnd) {
        this.providerFlightEnd = providerFlightEnd;
    }
}
