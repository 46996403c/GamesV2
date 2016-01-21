package oscarxiii.xiii_game.json.SteamAmigosAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Friendslist {

    @SerializedName("friends")
    @Expose
    private List<Friend> friends = new ArrayList<Friend>();

    /**
     *
     * @return
     * The friends
     */
    public List<Friend> getFriends() {
        return friends;
    }

    /**
     *
     * @param friends
     * The friends
     */
    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

}