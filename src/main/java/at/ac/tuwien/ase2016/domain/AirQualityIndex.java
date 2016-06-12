
package at.ac.tuwien.ase2016.domain;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "HourlyAirQualityIndex"
})
public class AirQualityIndex {

    @JsonProperty("HourlyAirQualityIndex")
    private HourlyAirQualityIndex hourlyAirQualityIndex;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AirQualityIndex() {
    }

    /**
     * 
     * @param hourlyAirQualityIndex
     */
    public AirQualityIndex(HourlyAirQualityIndex hourlyAirQualityIndex) {
        this.hourlyAirQualityIndex = hourlyAirQualityIndex;
    }

    /**
     * 
     * @return
     *     The hourlyAirQualityIndex
     */
    @JsonProperty("HourlyAirQualityIndex")
    public HourlyAirQualityIndex getHourlyAirQualityIndex() {
        return hourlyAirQualityIndex;
    }

    /**
     * 
     * @param hourlyAirQualityIndex
     *     The HourlyAirQualityIndex
     */
    @JsonProperty("HourlyAirQualityIndex")
    public void setHourlyAirQualityIndex(HourlyAirQualityIndex hourlyAirQualityIndex) {
        this.hourlyAirQualityIndex = hourlyAirQualityIndex;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
