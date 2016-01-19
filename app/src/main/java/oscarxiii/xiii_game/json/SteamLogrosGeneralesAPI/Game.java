package oscarxiii.xiii_game.json.SteamLogrosGeneralesAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Game {

    @SerializedName("gameName")
    @Expose
    private String gameName;
    @SerializedName("gameVersion")
    @Expose
    private String gameVersion;
    @SerializedName("availableGameStats")
    @Expose
    private AvailableGameStats availableGameStats;

    /**
     *
     * @return
     * The gameName
     */
    public String getGameName() {
        return gameName;
    }

    /**
     *
     * @param gameName
     * The gameName
     */
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    /**
     *
     * @return
     * The gameVersion
     */
    public String getGameVersion() {
        return gameVersion;
    }

    /**
     *
     * @param gameVersion
     * The gameVersion
     */
    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }

    /**
     *
     * @return
     * The availableGameStats
     */
    public AvailableGameStats getAvailableGameStats() {
        return availableGameStats;
    }

    /**
     *
     * @param availableGameStats
     * The availableGameStats
     */
    public void setAvailableGameStats(AvailableGameStats availableGameStats) {
        this.availableGameStats = availableGameStats;
    }

}