
package at.ac.tuwien.ase2016.domain;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "@SpeciesCode",
    "@SpeciesDescription",
    "@AirQualityIndex",
    "@AirQualityBand",
    "@IndexSource"
})
public class Species {

    @JsonProperty("@SpeciesCode")
    private String speciesCode;
    @JsonProperty("@SpeciesDescription")
    private String speciesDescription;
    @JsonProperty("@AirQualityIndex")
    private String airQualityIndex;
    @JsonProperty("@AirQualityBand")
    private String airQualityBand;
    @JsonProperty("@IndexSource")
    private String indexSource;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Species() {
    }

    /**
     * 
     * @param airQualityIndex
     * @param speciesCode
     * @param speciesDescription
     * @param indexSource
     * @param airQualityBand
     */
    public Species(String speciesCode, String speciesDescription, String airQualityIndex, String airQualityBand, String indexSource) {
        this.speciesCode = speciesCode;
        this.speciesDescription = speciesDescription;
        this.airQualityIndex = airQualityIndex;
        this.airQualityBand = airQualityBand;
        this.indexSource = indexSource;
    }

    /**
     * 
     * @return
     *     The speciesCode
     */
    @JsonProperty("@SpeciesCode")
    public String getSpeciesCode() {
        return speciesCode;
    }

    /**
     * 
     * @param speciesCode
     *     The @SpeciesCode
     */
    @JsonProperty("@SpeciesCode")
    public void setSpeciesCode(String speciesCode) {
        this.speciesCode = speciesCode;
    }

    /**
     * 
     * @return
     *     The speciesDescription
     */
    @JsonProperty("@SpeciesDescription")
    public String getSpeciesDescription() {
        return speciesDescription;
    }

    /**
     * 
     * @param speciesDescription
     *     The @SpeciesDescription
     */
    @JsonProperty("@SpeciesDescription")
    public void setSpeciesDescription(String speciesDescription) {
        this.speciesDescription = speciesDescription;
    }

    /**
     * 
     * @return
     *     The airQualityIndex
     */
    @JsonProperty("@AirQualityIndex")
    public String getAirQualityIndex() {
        return airQualityIndex;
    }

    /**
     * 
     * @param airQualityIndex
     *     The @AirQualityIndex
     */
    @JsonProperty("@AirQualityIndex")
    public void setAirQualityIndex(String airQualityIndex) {
        this.airQualityIndex = airQualityIndex;
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
     *     The indexSource
     */
    @JsonProperty("@IndexSource")
    public String getIndexSource() {
        return indexSource;
    }

    /**
     * 
     * @param indexSource
     *     The @IndexSource
     */
    @JsonProperty("@IndexSource")
    public void setIndexSource(String indexSource) {
        this.indexSource = indexSource;
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
