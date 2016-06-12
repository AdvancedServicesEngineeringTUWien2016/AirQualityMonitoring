
package at.ac.tuwien.ase2016.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "@GroupName",
    "@TimeToLive",
    "LocalAuthority"
})
public class HourlyAirQualityIndex {

    @JsonProperty("@GroupName")
    private String groupName;
    @JsonProperty("@TimeToLive")
    private String timeToLive;
    @JsonProperty("LocalAuthority")
    private List<LocalAuthority> localAuthority = new ArrayList<LocalAuthority>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HourlyAirQualityIndex() {
    }

    /**
     * 
     * @param groupName
     * @param localAuthority
     * @param timeToLive
     */
    public HourlyAirQualityIndex(String groupName, String timeToLive, List<LocalAuthority> localAuthority) {
        this.groupName = groupName;
        this.timeToLive = timeToLive;
        this.localAuthority = localAuthority;
    }

    /**
     * 
     * @return
     *     The groupName
     */
    @JsonProperty("@GroupName")
    public String getGroupName() {
        return groupName;
    }

    /**
     * 
     * @param groupName
     *     The @GroupName
     */
    @JsonProperty("@GroupName")
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 
     * @return
     *     The timeToLive
     */
    @JsonProperty("@TimeToLive")
    public String getTimeToLive() {
        return timeToLive;
    }

    /**
     * 
     * @param timeToLive
     *     The @TimeToLive
     */
    @JsonProperty("@TimeToLive")
    public void setTimeToLive(String timeToLive) {
        this.timeToLive = timeToLive;
    }

    /**
     * 
     * @return
     *     The localAuthority
     */
    @JsonProperty("LocalAuthority")
    public List<LocalAuthority> getLocalAuthority() {
        return localAuthority;
    }

    /**
     * 
     * @param localAuthority
     *     The LocalAuthority
     */
    @JsonProperty("LocalAuthority")
    public void setLocalAuthority(List<LocalAuthority> localAuthority) {
        this.localAuthority = localAuthority;
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
