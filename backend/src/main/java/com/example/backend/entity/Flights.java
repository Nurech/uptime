package com.example.backend.entity;

import com.example.backend.model.ServerInfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flights")
public class Flights extends ServerInfo {

    @Id
    @Column(name = "row_id")
    private long rowId;

    @Column(name = "id")
    private String id;

    @Column(name = "valid_until")
    private String validUntil;

    @Column(name = "leg_id")
    private String legsId;

    @Column(name = "route_id")
    private String routeId;

    @Column(name = "route_from_id")
    private String routeFromId;

    @Column(name = "route_from_name")
    private String routeFromName;

    @Column(name = "route_to_id")
    private String routeToId;

    @Column(name = "route_to_name")
    private String routeToName;

    @Column(name = "route_distance")
    private long routeDistance;

    @Column(name = "provider_id")
    private String providerId;

    @Column(name = "provider_price")
    private double providerPrice;

    @Column(name = "provider_flight_start")
    private String providerFlightStart;

    @Column(name = "provider_flight_end")
    private String providerFlightEnd;

    @Column(name = "provider_company_id")
    private String provider_company_name;

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

    public String getProvider_company_name() {
        return provider_company_name;
    }

    public void setProvider_company_name(String provider_company_name) {
        this.provider_company_name = provider_company_name;
    }
}
