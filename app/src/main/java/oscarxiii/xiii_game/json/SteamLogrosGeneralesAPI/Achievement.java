package oscarxiii.xiii_game.json.SteamLogrosGeneralesAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Achievement {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("defaultvalue")
    @Expose
    private Integer defaultvalue;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("hidden")
    @Expose
    private Integer hidden;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("icongray")
    @Expose
    private String icongray;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The defaultvalue
     */
    public Integer getDefaultvalue() {
        return defaultvalue;
    }

    /**
     *
     * @param defaultvalue
     * The defaultvalue
     */
    public void setDefaultvalue(Integer defaultvalue) {
        this.defaultvalue = defaultvalue;
    }

    /**
     *
     * @return
     * The displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     *
     * @param displayName
     * The displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     *
     * @return
     * The hidden
     */
    public Integer getHidden() {
        return hidden;
    }

    /**
     *
     * @param hidden
     * The hidden
     */
    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    /**
     *
     * @return
     * The icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     *
     * @param icon
     * The icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     *
     * @return
     * The icongray
     */
    public String getIcongray() {
        return icongray;
    }

    /**
     *
     * @param icongray
     * The icongray
     */
    public void setIcongray(String icongray) {
        this.icongray = icongray;
    }

}