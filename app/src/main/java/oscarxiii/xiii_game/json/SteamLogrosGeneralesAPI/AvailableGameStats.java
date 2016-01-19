package oscarxiii.xiii_game.json.SteamLogrosGeneralesAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class AvailableGameStats {

    @SerializedName("achievements")
    @Expose
    private List<Achievement> achievements = new ArrayList<Achievement>();

    /**
     *
     * @return
     * The achievements
     */
    public List<Achievement> getAchievements() {
        return achievements;
    }

    /**
     *
     * @param achievements
     * The achievements
     */
    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }

}