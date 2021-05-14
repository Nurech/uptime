
package com.example.backend.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "validUntil",
        "legs"
})
@Generated("jsonschema2pojo")
public class Flight implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("validUntil")
    private String validUntil;
    @JsonProperty("legs")
    private List<Leg> legs = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8969977133998946091L;

    /**
     * No args constructor for use in serialization
     */
    public Flight() {
    }

    /**
     * @param legs
     * @param validUntil
     * @param id
     */
    public Flight(String id, String validUntil, List<Leg> legs) {
        super();
        this.id = id;
        this.validUntil = validUntil;
        this.legs = legs;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("validUntil")
    public String getValidUntil() {
        return validUntil;
    }

    @JsonProperty("validUntil")
    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    @JsonProperty("legs")
    public List<Leg> getLegs() {
        return legs;
    }

    @JsonProperty("legs")
    public void setLegs(List<Leg> legs) {
        this.legs = legs;
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
