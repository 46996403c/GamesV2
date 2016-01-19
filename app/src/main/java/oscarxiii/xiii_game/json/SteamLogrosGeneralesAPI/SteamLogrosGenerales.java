package oscarxiii.xiii_game.json.SteamLogrosGeneralesAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SteamLogrosGenerales {

    @SerializedName("game")
    @Expose
    private Game game;

    /**
     *
     * @return
     * The game
     */
    public Game getGame() {
        return game;
    }

    /**
     *
     * @param game
     * The game
     */
    public void setGame(Game game) {
        this.game = game;
    }

}