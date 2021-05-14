
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
        "routeInfo",
        "providers"
})
@Generated("jsonschema2pojo")
public class Leg implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("routeInfo")
    private RouteInfo routeInfo;
    @JsonProperty("providers")
    private List<Provider> providers = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6076866355169725055L;

    /**
     * No args constructor for use in serialization
     */
    public Leg() {
    }

    /**
     * @param id
     * @param routeInfo
     * @param providers
     */
    public Leg(String id, RouteInfo routeInfo, List<Provider> providers) {
        super();
        this.id = id;
        this.routeInfo = routeInfo;
        this.providers = providers;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("routeInfo")
    public RouteInfo getRouteInfo() {
        return routeInfo;
    }

    @JsonProperty("routeInfo")
    public void setRouteInfo(RouteInfo routeInfo) {
        this.routeInfo = routeInfo;
    }

    @JsonProperty("providers")
    public List<Provider> getProviders() {
        return providers;
    }

    @JsonProperty("providers")
    public void setProviders(List<Provider> providers) {
        this.providers = providers;
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
