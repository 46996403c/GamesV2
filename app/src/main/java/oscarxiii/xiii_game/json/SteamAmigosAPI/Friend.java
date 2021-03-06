package oscarxiii.xiii_game.json.SteamAmigosAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Friend {

    @SerializedName("steamid")
    @Expose
    private String steamid;
    @SerializedName("relationship")
    @Expose
    private String relationship;
    @SerializedName("friend_since")
    @Expose
    private Integer friendSince;

    /**
     *
     * @return
     * The steamid
     */
    public String getSteamid() {
        return steamid;
    }

    /**
     *
     * @param steamid
     * The steamid
     */
    public void setSteamid(String steamid) {
        this.steamid = steamid;
    }

    /**
     *
     * @return
     * The relationship
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     *
     * @param relationship
     * The relationship
     */
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    /**
     *
     * @return
     * The friendSince
     */
    public Integer getFriendSince() {
        return friendSince;
    }

    /**
     *
     * @param friendSince
     * The friend_since
     */
    public void setFriendSince(Integer friendSince) {
        this.friendSince = friendSince;
    }

}