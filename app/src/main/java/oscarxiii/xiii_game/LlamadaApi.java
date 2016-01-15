package oscarxiii.xiii_game;

import android.util.Log;
import android.widget.TextView;

import java.util.Arrays;

import oscarxiii.xiii_game.json.SteamIDsAPI.SteamIDs;
import oscarxiii.xiii_game.json.SteamPlayerAPI.SteamPlayer;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Usuario on 11/01/2016.
 */
public class LlamadaApi {
    //http://api.steampowered.com/ISteamUser/ResolveVanityURL/v0001/?key=9DED78B02A80DE9A7062EB2822D42C11&vanityurl=oscarXIII
    //http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=9DED78B02A80DE9A7062EB2822D42C11&steamids=76561198011227808
    final String api_key ="9DED78B02A80DE9A7062EB2822D42C11";
    final String URL_base = "http://api.steampowered.com/ISteamUser/";
    String id = "";

    //Conectamos con la api
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL_base)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //Creamos el servicio
    LlamadaPerfilInterface service = retrofit.create(LlamadaPerfilInterface.class);

    public LlamadaApi(){
        super();
    }
    //public void getsteamID(final ArrayAdapter adapter, String nombre_perfil){
    public void getsteamID(final TextView adapter, String nombre_perfil){

        //Hacemos una llamada
        Call<SteamIDs> IDCall = service.steamIDs(nombre_perfil);
        IDCall.enqueue(new Callback<SteamIDs>() {
            @Override
            public void onResponse(Response<SteamIDs> response, Retrofit retrofit) {
                if(response.isSuccess()) {
                    SteamIDs perfilID = response.body();
                    id = perfilID.getResponse().getSteamid();
                    System.out.println("--------------------" + id);

                    Call<SteamPlayer> PerfilCall=service.steamPerfil(id);

                    PerfilCall.enqueue(new Callback<SteamPlayer>() {
                        @Override
                        public void onResponse(Response<SteamPlayer> response, Retrofit retrofit) {
                            if(response.isSuccess()) {
                                SteamPlayer player = response.body();
                                String steamid = player.getResponse().getPlayers().get(0).getSteamid();
                                int communityvisibilitystate = player.getResponse().getPlayers().get(0).getCommunityvisibilitystate();
                                int profilestate = player.getResponse().getPlayers().get(0).getProfilestate();
                                String personaname = player.getResponse().getPlayers().get(0).getPersonaname();
                                int lastlogoff = player.getResponse().getPlayers().get(0).getLastlogoff();
                                String profileurl = player.getResponse().getPlayers().get(0).getProfileurl();
                                String avatar = player.getResponse().getPlayers().get(0).getAvatar();
                                String avatarmedium = player.getResponse().getPlayers().get(0).getAvatarmedium();
                                String avatarfull = player.getResponse().getPlayers().get(0).getAvatarfull();
                                int personastate = player.getResponse().getPlayers().get(0).getPersonastate();
                                String realname = player.getResponse().getPlayers().get(0).getRealname();
                                String primaryclanid = player.getResponse().getPlayers().get(0).getPrimaryclanid();
                                int timecreated = player.getResponse().getPlayers().get(0).getTimecreated();
                                int personastateflags = player.getResponse().getPlayers().get(0).getPersonastateflags();
                                String loccountrycode = player.getResponse().getPlayers().get(0).getLoccountrycode();
                                String locstatecode = player.getResponse().getPlayers().get(0).getLocstatecode();
                                int loccityid = player.getResponse().getPlayers().get(0).getLoccityid();
                                System.out.println(steamid);
                                System.out.println(communityvisibilitystate);
                                System.out.println(profilestate);
                                System.out.println(personaname);
                                System.out.println(lastlogoff);
                                System.out.println(profileurl);
                                System.out.println(avatar);
                                System.out.println(avatarmedium);
                                System.out.println(avatarfull);
                                System.out.println(personastate);
                                System.out.println(realname);
                                System.out.println(primaryclanid);
                                System.out.println(timecreated);
                                System.out.println(personastateflags);
                                System.out.println(loccountrycode);
                                System.out.println(locstatecode);
                                System.out.println(loccityid);
                            }
                        }
                        @Override
                        public void onFailure(Throwable t) {
                            Log.w(null, Arrays.toString(t.getStackTrace()));
                        }
                    });
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w(null, Arrays.toString(t.getStackTrace()));
            }
        });
    }
}

interface LlamadaPerfilInterface
{
    @GET("ResolveVanityURL/v0001/?key=9DED78B02A80DE9A7062EB2822D42C11")
    Call<SteamIDs> steamIDs(

            @Query("vanityurl") String vanityurl
    );

    @GET("GetPlayerSummaries/v0002/?key=9DED78B02A80DE9A7062EB2822D42C11")
    Call<SteamPlayer> steamPerfil(

            @Query("steamids") String steamids
    );
}
