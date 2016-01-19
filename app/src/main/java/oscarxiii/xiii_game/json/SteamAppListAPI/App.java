package oscarxiii.xiii_game.json.SteamAppListAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class App {

    @SerializedName("appid")
    @Expose
    private Integer appid;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     *
     * @return
     * The appid
     */
    public Integer getAppid() {
        return appid;
    }

    /**
     *
     * @param appid
     * The appid
     */
    public void setAppid(Integer appid) {
        this.appid = appid;
    }

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

}