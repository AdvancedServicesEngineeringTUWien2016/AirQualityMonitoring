
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
    "@BulletinDate",
    "@SiteCode",
    "@SiteName",
    "@SiteType",
    "@Latitude",
    "@Longitude",
    "@LatitudeWGS84",
    "@LongitudeWGS84",
    "Species"
})
public class Site {

    @JsonProperty("@BulletinDate")
    private String bulletinDate;
    @JsonProperty("@SiteCode")
    private String siteCode;
    @JsonProperty("@SiteName")
    private String siteName;
    @JsonProperty("@SiteType")
    private String siteType;
    @JsonProperty("@Latitude")
    private String latitude;
    @JsonProperty("@Longitude")
    private String longitude;
    @JsonProperty("@LatitudeWGS84")
    private String latitudeWGS84;
    @JsonProperty("@LongitudeWGS84")
    private String longitudeWGS84;
    @JsonProperty("Species")
    private List<Species> species = new ArrayList<Species>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Site() {
    }

    /**
     * 
     * @param longitudeWGS84
     * @param species
     * @param siteType
     * @param bulletinDate
     * @param latitudeWGS84
     * @param longitude
     * @param latitude
     * @param siteCode
     * @param siteName
     */
    public Site(String bulletinDate, String siteCode, String siteName, String siteType, String latitude, String longitude, String latitudeWGS84, String longitudeWGS84, List<Species> species) {
        this.bulletinDate = bulletinDate;
        this.siteCode = siteCode;
        this.siteName = siteName;
        this.siteType = siteType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.latitudeWGS84 = latitudeWGS84;
        this.longitudeWGS84 = longitudeWGS84;
        this.species = species;
    }

    /**
     * 
     * @return
     *     The bulletinDate
     */
    @JsonProperty("@BulletinDate")
    public String getBulletinDate() {
        return bulletinDate;
    }

    /**
     * 
     * @param bulletinDate
     *     The @BulletinDate
     */
    @JsonProperty("@BulletinDate")
    public void setBulletinDate(String bulletinDate) {
        this.bulletinDate = bulletinDate;
    }

    /**
     * 
     * @return
     *     The siteCode
     */
    @JsonProperty("@SiteCode")
    public String getSiteCode() {
        return siteCode;
    }

    /**
     * 
     * @param siteCode
     *     The @SiteCode
     */
    @JsonProperty("@SiteCode")
    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    /**
     * 
     * @return
     *     The siteName
     */
    @JsonProperty("@SiteName")
    public String getSiteName() {
        return siteName;
    }

    /**
     * 
     * @param siteName
     *     The @SiteName
     */
    @JsonProperty("@SiteName")
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    /**
     * 
     * @return
     *     The siteType
     */
    @JsonProperty("@SiteType")
    public String getSiteType() {
        return siteType;
    }

    /**
     * 
     * @param siteType
     *     The @SiteType
     */
    @JsonProperty("@SiteType")
    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    /**
     * 
     * @return
     *     The latitude
     */
    @JsonProperty("@Latitude")
    public String getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude
     *     The @Latitude
     */
    @JsonProperty("@Latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * 
     * @return
     *     The longitude
     */
    @JsonProperty("@Longitude")
    public String getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude
     *     The @Longitude
     */
    @JsonProperty("@Longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * 
     * @return
     *     The latitudeWGS84
     */
    @JsonProperty("@LatitudeWGS84")
    public String getLatitudeWGS84() {
        return latitudeWGS84;
    }

    /**
     * 
     * @param latitudeWGS84
     *     The @LatitudeWGS84
     */
    @JsonProperty("@LatitudeWGS84")
    public void setLatitudeWGS84(String latitudeWGS84) {
        this.latitudeWGS84 = latitudeWGS84;
    }

    /**
     * 
     * @return
     *     The longitudeWGS84
     */
    @JsonProperty("@LongitudeWGS84")
    public String getLongitudeWGS84() {
        return longitudeWGS84;
    }

    /**
     * 
     * @param longitudeWGS84
     *     The @LongitudeWGS84
     */
    @JsonProperty("@LongitudeWGS84")
    public void setLongitudeWGS84(String longitudeWGS84) {
        this.longitudeWGS84 = longitudeWGS84;
    }

    /**
     * 
     * @return
     *     The species
     */
    @JsonProperty("Species")
    public List<Species> getSpecies() {
        return species;
    }

    /**
     * 
     * @param species
     *     The Species
     */
    @JsonProperty("Species")
    public void setSpecies(List<Species> species) {
        this.species = species;
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
