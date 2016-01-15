package oscarxiii.xiii_game.json.SteamIDsAPI;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Response {

    @SerializedName("steamid")
    @Expose
    private String steamid;
    @SerializedName("success")
    @Expose
    private Integer success;

    /**
     *
     * @return
     *     The steamid
     */
    public String getSteamid() {
        return steamid;
    }

    /**
     *
     * @param steamid
     *     The steamid
     */
    public void setSteamid(String steamid) {
        this.steamid = steamid;
    }

    /**
     *
     * @return
     *     The success
     */
    public Integer getSuccess() {
        return success;
    }

    /**
     *
     * @param success
     *     The success
     */
    public void setSuccess(Integer success) {
        this.success = success;
    }

}

