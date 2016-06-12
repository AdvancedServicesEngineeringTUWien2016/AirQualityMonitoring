
package at.ac.tuwien.ase2016.domain.londonair.advice;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "@AirQualityBand",
    "@LowerAirQualityIndex",
    "@UpperAirQualityIndex",
    "@Group",
    "@Advice"
})
public class HealthAdvice {

    @JsonProperty("@AirQualityBand")
    private String airQualityBand;
    @JsonProperty("@LowerAirQualityIndex")
    private String lowerAirQualityIndex;
    @JsonProperty("@UpperAirQualityIndex")
    private String upperAirQualityIndex;
    @JsonProperty("@Group")
    private String group;
    @JsonProperty("@Advice")
    private String advice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HealthAdvice() {
    }

    /**
     * 
     * @param airQualityBand
     * @param lowerAirQualityIndex
     * @param group
     * @param advice
     * @param upperAirQualityIndex
     */
    public HealthAdvice(String airQualityBand, String lowerAirQualityIndex, String upperAirQualityIndex, String group, String advice) {
        this.airQualityBand = airQualityBand;
        this.lowerAirQualityIndex = lowerAirQualityIndex;
        this.upperAirQualityIndex = upperAirQualityIndex;
        this.group = group;
        this.advice = advice;
    }

    /**
     * 
     * @return
     *     The airQualityBand
     */
    @JsonProperty("@AirQualityBand")
    public String getAirQualityBand() {
        return airQualityBand;
    }

    /**
     * 
     * @param airQualityBand
     *     The @AirQualityBand
     */
    @JsonProperty("@AirQualityBand")
    public void setAirQualityBand(String airQualityBand) {
        this.airQualityBand = airQualityBand;
    }

    /**
     * 
     * @return
     *     The lowerAirQualityIndex
     */
    @JsonProperty("@LowerAirQualityIndex")
    public String getLowerAirQualityIndex() {
        return lowerAirQualityIndex;
    }

    /**
     * 
     * @param lowerAirQualityIndex
     *     The @LowerAirQualityIndex
     */
    @JsonProperty("@LowerAirQualityIndex")
    public void setLowerAirQualityIndex(String lowerAirQualityIndex) {
        this.lowerAirQualityIndex = lowerAirQualityIndex;
    }

    /**
     * 
     * @return
     *     The upperAirQualityIndex
     */
    @JsonProperty("@UpperAirQualityIndex")
    public String getUpperAirQualityIndex() {
        return upperAirQualityIndex;
    }

    /**
     * 
     * @param upperAirQualityIndex
     *     The @UpperAirQualityIndex
     */
    @JsonProperty("@UpperAirQualityIndex")
    public void setUpperAirQualityIndex(String upperAirQualityIndex) {
        this.upperAirQualityIndex = upperAirQualityIndex;
    }

    /**
     * 
     * @return
     *     The group
     */
    @JsonProperty("@Group")
    public String getGroup() {
        return group;
    }

    /**
     * 
     * @param group
     *     The @Group
     */
    @JsonProperty("@Group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * 
     * @return
     *     The advice
     */
    @JsonProperty("@Advice")
    public String getAdvice() {
        return advice;
    }

    /**
     * 
     * @param advice
     *     The @Advice
     */
    @JsonProperty("@Advice")
    public void setAdvice(String advice) {
        this.advice = advice;
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
