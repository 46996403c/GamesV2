package oscarxiii.xiii_game.json.SteamIDsAPI;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class SteamIDs {

    @SerializedName("response")
    @Expose
    private Response response;

    /**
     *
     * @return
     *     The response
     */
    public Response getResponse() {
        return response;
    }

    /**
     *
     * @param response
     *     The response
     */
    public void setResponse(Response response) {
        this.response = response;
    }

}

