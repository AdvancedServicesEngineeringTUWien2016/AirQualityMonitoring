
package at.ac.tuwien.ase2016.domain.londonair.advice;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "HealthAdvice"
})
public class AirQualityIndexHealthAdvice_ {

    @JsonProperty("HealthAdvice")
    private List<HealthAdvice> healthAdvice = new ArrayList<HealthAdvice>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AirQualityIndexHealthAdvice_() {
    }

    /**
     * 
     * @param healthAdvice
     */
    public AirQualityIndexHealthAdvice_(List<HealthAdvice> healthAdvice) {
        this.healthAdvice = healthAdvice;
    }

    /**
     * 
     * @return
     *     The healthAdvice
     */
    @JsonProperty("HealthAdvice")
    public List<HealthAdvice> getHealthAdvice() {
        return healthAdvice;
    }

    /**
     * 
     * @param healthAdvice
     *     The HealthAdvice
     */
    @JsonProperty("HealthAdvice")
    public void setHealthAdvice(List<HealthAdvice> healthAdvice) {
        this.healthAdvice = healthAdvice;
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
