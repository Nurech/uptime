
package com.example.backend.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "company",
    "price",
    "flightStart",
    "flightEnd"
})
@Generated("jsonschema2pojo")
public class Provider implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("company")
    private Company company;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("flightStart")
    private String flightStart;
    @JsonProperty("flightEnd")
    private String flightEnd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8690889876938625970L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Provider() {
    }

    /**
     * 
     * @param flightStart
     * @param price
     * @param flightEnd
     * @param company
     * @param id
     */
    public Provider(String id, Company company, Double price, String flightStart, String flightEnd) {
        super();
        this.id = id;
        this.company = company;
        this.price = price;
        this.flightStart = flightStart;
        this.flightEnd = flightEnd;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("company")
    public Company getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(Company company) {
        this.company = company;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("flightStart")
    public String getFlightStart() {
        return flightStart;
    }

    @JsonProperty("flightStart")
    public void setFlightStart(String flightStart) {
        this.flightStart = flightStart;
    }

    @JsonProperty("flightEnd")
    public String getFlightEnd() {
        return flightEnd;
    }

    @JsonProperty("flightEnd")
    public void setFlightEnd(String flightEnd) {
        this.flightEnd = flightEnd;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
