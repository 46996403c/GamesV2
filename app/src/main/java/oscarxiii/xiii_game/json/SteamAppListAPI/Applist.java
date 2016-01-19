package oscarxiii.xiii_game.json.SteamAppListAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Applist {

    @SerializedName("apps")
    @Expose
    private List<App> apps = new ArrayList<App>();

    /**
     *
     * @return
     * The apps
     */
    public List<App> getApps() {
        return apps;
    }

    /**
     *
     * @param apps
     * The apps
     */
    public void setApps(List<App> apps) {
        this.apps = apps;
    }

}