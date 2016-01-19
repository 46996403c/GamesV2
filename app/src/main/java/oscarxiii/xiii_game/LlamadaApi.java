package oscarxiii.xiii_game;

import android.util.Log;
import android.widget.TextView;

import java.util.Arrays;

import oscarxiii.xiii_game.json.SteamAppListAPI.SteamAppList;
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
    String steamid = null;
    int communityvisibilitystate = 0;
    int profilestate = 0;
    String personaname = null;
    int lastlogoff = 0;
    String profileurl = null;
    String avatar = null;
    String avatarmedium = null;
    String avatarfull = null;
    int personastate = 0;
    String realname = null;
    String primaryclanid = null;
    int timecreated = 0;
    int personastateflags = 0;
    String loccountrycode = null;
    String locstatecode = null;
    int loccityid = 0;

    //http://api.steampowered.com/ISteamUser/ResolveVanityURL/v0001/?key=9DED78B02A80DE9A7062EB2822D42C11&vanityurl=oscarXIII
    //http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=9DED78B02A80DE9A7062EB2822D42C11&steamids=76561198011227808
    final String api_key ="9DED78B02A80DE9A7062EB2822D42C11";
    final String URL_base = "http://api.steampowered.com/";
    String id = "";

    //Conectamos con la api
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL_base)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //Creamos los servicios
    LlamadaPerfilInterface servicePerfil = retrofit.create(LlamadaPerfilInterface.class);
    LlamadaAppsInterface serviceApps = retrofit.create(LlamadaAppsInterface.class);

    public LlamadaApi(){
        super();
    }
    //public void getsteamID(final ArrayAdapter adapter, String nombre_perfil){
    public void getsteamID(final TextView adapter, String nombre_perfil){

        //Hacemos una llamada
        Call<SteamIDs> IDCall = servicePerfil.steamIDs(nombre_perfil);
        IDCall.enqueue(new Callback<SteamIDs>() {
            @Override
            public void onResponse(Response<SteamIDs> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    SteamIDs perfilID = response.body();
                    id = perfilID.getResponse().getSteamid();
                    System.out.println("--------------------" + id);

                    Call<SteamPlayer> PerfilCall = servicePerfil.steamPerfil(id);

                    PerfilCall.enqueue(new Callback<SteamPlayer>() {
                        @Override
                        public void onResponse(Response<SteamPlayer> response, Retrofit retrofit) {
                            if (response.isSuccess()) {
                                SteamPlayer player = response.body();
                                steamid = player.getResponse().getPlayers().get(0).getSteamid();
                                communityvisibilitystate = player.getResponse().getPlayers().get(0).getCommunityvisibilitystate();
                                profilestate = player.getResponse().getPlayers().get(0).getProfilestate();
                                personaname = player.getResponse().getPlayers().get(0).getPersonaname();
                                lastlogoff = player.getResponse().getPlayers().get(0).getLastlogoff();
                                profileurl = player.getResponse().getPlayers().get(0).getProfileurl();
                                avatar = player.getResponse().getPlayers().get(0).getAvatar();
                                avatarmedium = player.getResponse().getPlayers().get(0).getAvatarmedium();
                                avatarfull = player.getResponse().getPlayers().get(0).getAvatarfull();
                                personastate = player.getResponse().getPlayers().get(0).getPersonastate();
                                realname = player.getResponse().getPlayers().get(0).getRealname();
                                primaryclanid = player.getResponse().getPlayers().get(0).getPrimaryclanid();
                                timecreated = player.getResponse().getPlayers().get(0).getTimecreated();
                                personastateflags = player.getResponse().getPlayers().get(0).getPersonastateflags();
                                loccountrycode = player.getResponse().getPlayers().get(0).getLoccountrycode();
                                locstatecode = player.getResponse().getPlayers().get(0).getLocstatecode();
                                loccityid = player.getResponse().getPlayers().get(0).getLoccityid();
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


    public void getSteamApps(){

        //Hacemos una llamada
        Call<SteamAppList> AppsCall = serviceApps.steamApps();
        AppsCall.enqueue(new Callback<SteamAppList>() {
            @Override
            public void onResponse(Response<SteamAppList> response, Retrofit retrofit) {
                if(response.isSuccess()) {
                    SteamAppList appName = response.body();
                    for (int i=0; i<appName.getApplist().getApps().size(); i++){
                        System.out.println("Nombre: " + appName.getApplist().getApps().get(i).getName());
                        System.out.println("ID de la App: " + appName.getApplist().getApps().get(i).getAppid()+"\n");
                    }
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
    @GET("ISteamUser/ResolveVanityURL/v0001/?key=9DED78B02A80DE9A7062EB2822D42C11")
    Call<SteamIDs> steamIDs(

            @Query("vanityurl") String vanityurl
    );

    @GET("ISteamUser/GetPlayerSummaries/v0002/?key=9DED78B02A80DE9A7062EB2822D42C11")
    Call<SteamPlayer> steamPerfil(

            @Query("steamids") String steamids
    );
}
interface LlamadaAppsInterface
{
    @GET("ISteamApps/GetAppList/v2")
    Call<SteamAppList> steamApps();
}
