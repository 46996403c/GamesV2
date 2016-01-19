package oscarxiii.xiii_game.json.SteamAppListAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SteamAppList {

    @SerializedName("applist")
    @Expose
    private Applist applist;

    /**
     *
     * @return
     * The applist
     */
    public Applist getApplist() {
        return applist;
    }

    /**
     *
     * @param applist
     * The applist
     */
    public void setApplist(Applist applist) {
        this.applist = applist;
    }

}