
package at.ac.tuwien.ase2016.domain;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "@LocalAuthorityCode",
    "@LocalAuthorityName",
    "@LaCentreLatitude",
    "@LaCentreLongitude",
    "@LaCentreLatitudeWGS84",
    "@LaCentreLongitudeWGS84",
    "Site"
})
public class LocalAuthority {

    @JsonProperty("@LocalAuthorityCode")
    private String localAuthorityCode;
    @JsonProperty("@LocalAuthorityName")
    private String localAuthorityName;
    @JsonProperty("@LaCentreLatitude")
    private String laCentreLatitude;
    @JsonProperty("@LaCentreLongitude")
    private String laCentreLongitude;
    @JsonProperty("@LaCentreLatitudeWGS84")
    private String laCentreLatitudeWGS84;
    @JsonProperty("@LaCentreLongitudeWGS84")
    private String laCentreLongitudeWGS84;
    @JsonProperty("Site")
    private List<Site> site = new ArrayList<Site>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public LocalAuthority() {
    }

    /**
     * 
     * @param site
     * @param localAuthorityName
     * @param laCentreLatitude
     * @param laCentreLongitudeWGS84
     * @param localAuthorityCode
     * @param laCentreLatitudeWGS84
     * @param laCentreLongitude
     */
    public LocalAuthority(String localAuthorityCode, String localAuthorityName, String laCentreLatitude, String laCentreLongitude, String laCentreLatitudeWGS84, String laCentreLongitudeWGS84, List<Site> site) {
        this.localAuthorityCode = localAuthorityCode;
        this.localAuthorityName = localAuthorityName;
        this.laCentreLatitude = laCentreLatitude;
        this.laCentreLongitude = laCentreLongitude;
        this.laCentreLatitudeWGS84 = laCentreLatitudeWGS84;
        this.laCentreLongitudeWGS84 = laCentreLongitudeWGS84;
        this.site = site;
    }

    /**
     * 
     * @return
     *     The localAuthorityCode
     */
    @JsonProperty("@LocalAuthorityCode")
    public String getLocalAuthorityCode() {
        return localAuthorityCode;
    }

    /**
     * 
     * @param localAuthorityCode
     *     The @LocalAuthorityCode
     */
    @JsonProperty("@LocalAuthorityCode")
    public void setLocalAuthorityCode(String localAuthorityCode) {
        this.localAuthorityCode = localAuthorityCode;
    }

    /**
     * 
     * @return
     *     The localAuthorityName
     */
    @JsonProperty("@LocalAuthorityName")
    public String getLocalAuthorityName() {
        return localAuthorityName;
    }

    /**
     * 
     * @param localAuthorityName
     *     The @LocalAuthorityName
     */
    @JsonProperty("@LocalAuthorityName")
    public void setLocalAuthorityName(String localAuthorityName) {
        this.localAuthorityName = localAuthorityName;
    }

    /**
     * 
     * @return
     *     The laCentreLatitude
     */
    @JsonProperty("@LaCentreLatitude")
    public String getLaCentreLatitude() {
        return laCentreLatitude;
    }

    /**
     * 
     * @param laCentreLatitude
     *     The @LaCentreLatitude
     */
    @JsonProperty("@LaCentreLatitude")
    public void setLaCentreLatitude(String laCentreLatitude) {
        this.laCentreLatitude = laCentreLatitude;
    }

    /**
     * 
     * @return
     *     The laCentreLongitude
     */
    @JsonProperty("@LaCentreLongitude")
    public String getLaCentreLongitude() {
        return laCentreLongitude;
    }

    /**
     * 
     * @param laCentreLongitude
     *     The @LaCentreLongitude
     */
    @JsonProperty("@LaCentreLongitude")
    public void setLaCentreLongitude(String laCentreLongitude) {
        this.laCentreLongitude = laCentreLongitude;
    }

    /**
     * 
     * @return
     *     The laCentreLatitudeWGS84
     */
    @JsonProperty("@LaCentreLatitudeWGS84")
    public String getLaCentreLatitudeWGS84() {
        return laCentreLatitudeWGS84;
    }

    /**
     * 
     * @param laCentreLatitudeWGS84
     *     The @LaCentreLatitudeWGS84
     */
    @JsonProperty("@LaCentreLatitudeWGS84")
    public void setLaCentreLatitudeWGS84(String laCentreLatitudeWGS84) {
        this.laCentreLatitudeWGS84 = laCentreLatitudeWGS84;
    }

    /**
     * 
     * @return
     *     The laCentreLongitudeWGS84
     */
    @JsonProperty("@LaCentreLongitudeWGS84")
    public String getLaCentreLongitudeWGS84() {
        return laCentreLongitudeWGS84;
    }

    /**
     * 
     * @param laCentreLongitudeWGS84
     *     The @LaCentreLongitudeWGS84
     */
    @JsonProperty("@LaCentreLongitudeWGS84")
    public void setLaCentreLongitudeWGS84(String laCentreLongitudeWGS84) {
        this.laCentreLongitudeWGS84 = laCentreLongitudeWGS84;
    }

    /**
     * 
     * @return
     *     The site
     */
    @JsonProperty("Site")
    public List<Site> getSite() {
        return site;
    }

    /**
     * 
     * @param site
     *     The Site
     */
    @JsonProperty("Site")
    public void setSite(List<Site> site) {
        this.site = site;
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
