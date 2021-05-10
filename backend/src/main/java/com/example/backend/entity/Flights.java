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

    @Column(name = "validUntil")
    private String validUntil;

    @Column(name = "legs_id")
    private String legsId;

    @Column(name = "legs_routeInfo_id")
    private String legsRouteInfoId;

    @Column(name = "legs_routeInfo_from_id")
    private String legsRouteInfoFromId;

    @Column(name = "legs_routeInfo_from_name")
    private String legsRouteInfoFromName;

    @Column(name = "legs_routeInfo_to_id")
    private String legsRouteInfoToId;

    @Column(name = "legs_routeInfo_to_name")
    private String legsRouteInfoToName;

    @Column(name = "legs_routeInfo_distance")
    private Long legsRouteInfoDistance;

    @Column(name = "legs_providers_id")
    private String legsProvidersId;

    @Column(name = "legs_providers_company_id")
    private String legsProvidersCompanyId;

    @Column(name = "legs_providers_company_name")
    private String legsProvidersCompanyName;

    @Column(name = "legs_providers_price")
    private Double legsProvidersPrice;

    @Column(name = "legs_providers_flightStart")
    private String legsProvidersFlightStart;

    @Column(name = "legs_providers_flightEnd")
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

    public Long getLegsRouteInfoDistance() {
        return legsRouteInfoDistance;
    }

    public void setLegsRouteInfoDistance(Long legsRouteInfoDistance) {
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

    public Double getLegsProvidersPrice() {
        return legsProvidersPrice;
    }

    public void setLegsProvidersPrice(Double legsProvidersPrice) {
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
