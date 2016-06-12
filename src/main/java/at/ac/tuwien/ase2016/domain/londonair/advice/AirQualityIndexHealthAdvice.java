
package at.ac.tuwien.ase2016.domain.londonair.advice;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "AirQualityIndexHealthAdvice"
})
public class AirQualityIndexHealthAdvice {

    @JsonProperty("AirQualityIndexHealthAdvice")
    private AirQualityIndexHealthAdvice_ airQualityIndexHealthAdvice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AirQualityIndexHealthAdvice() {
    }

    /**
     * 
     * @param airQualityIndexHealthAdvice
     */
    public AirQualityIndexHealthAdvice(AirQualityIndexHealthAdvice_ airQualityIndexHealthAdvice) {
        this.airQualityIndexHealthAdvice = airQualityIndexHealthAdvice;
    }

    /**
     * 
     * @return
     *     The airQualityIndexHealthAdvice
     */
    @JsonProperty("AirQualityIndexHealthAdvice")
    public AirQualityIndexHealthAdvice_ getAirQualityIndexHealthAdvice() {
        return airQualityIndexHealthAdvice;
    }

    /**
     * 
     * @param airQualityIndexHealthAdvice
     *     The AirQualityIndexHealthAdvice
     */
    @JsonProperty("AirQualityIndexHealthAdvice")
    public void setAirQualityIndexHealthAdvice(AirQualityIndexHealthAdvice_ airQualityIndexHealthAdvice) {
        this.airQualityIndexHealthAdvice = airQualityIndexHealthAdvice;
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
