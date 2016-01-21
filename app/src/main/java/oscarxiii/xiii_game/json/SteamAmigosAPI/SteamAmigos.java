package oscarxiii.xiii_game.json.SteamAmigosAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SteamAmigos {

    @SerializedName("friendslist")
    @Expose
    private Friendslist friendslist;

    /**
     *
     * @return
     * The friendslist
     */
    public Friendslist getFriendslist() {
        return friendslist;
    }

    /**
     *
     * @param friendslist
     * The friendslist
     */
    public void setFriendslist(Friendslist friendslist) {
        this.friendslist = friendslist;
    }

}