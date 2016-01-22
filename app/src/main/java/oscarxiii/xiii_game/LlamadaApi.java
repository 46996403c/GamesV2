package oscarxiii.xiii_game;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Arrays;

import oscarxiii.xiii_game.json.SteamAmigosAPI.SteamAmigos;
import oscarxiii.xiii_game.json.SteamAppListAPI.SteamAppList;
import oscarxiii.xiii_game.json.SteamIDsAPI.SteamIDs;
import oscarxiii.xiii_game.json.SteamJuegosCompradosAPI.SteamJuegosComprados;
import oscarxiii.xiii_game.json.SteamLogrosGeneralesAPI.SteamLogrosGenerales;
import oscarxiii.xiii_game.json.SteamPlayerAPI.SteamPlayer;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

public class LlamadaApi extends AppCompatActivity {
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
    LlamadaLogrosGeneralesInterface serviceLogrosGenerales = retrofit.create(LlamadaLogrosGeneralesInterface.class);
    LlamadaAppsCompradasInterface serviceAppsCompradas = retrofit.create(LlamadaAppsCompradasInterface.class);
    LlamadaAmigosInterface serviceAmigos = retrofit.create(LlamadaAmigosInterface.class);

    public LlamadaApi(){
        super();
    }
    //public void getsteamID(final ArrayAdapter adapter, String nombre_perfil){
    public void getsteamID(String nombrePerfil){
        System.out.println("\n\n=?????????=========????????========= " + nombrePerfil);
        //Hacemos una llamada
        Call<SteamIDs> IDCall = servicePerfil.steamIDs(nombrePerfil);
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

    public void getSteamLogrosGenerales(String appid){
        //Hacemos una llamada
        Call<SteamLogrosGenerales> LogrosGenCall = serviceLogrosGenerales.steamLogrosGeneral(appid);
        LogrosGenCall.enqueue(new Callback<SteamLogrosGenerales>() {
            @Override
            public void onResponse(Response<SteamLogrosGenerales> response, Retrofit retrofit) {
                if(response.isSuccess()) {
                    SteamLogrosGenerales appLogro = response.body();
                    System.out.println("Nombre Juego: "+appLogro.getGame().getGameName());
                    for (int i=0; i<appLogro.getGame().getAvailableGameStats().getAchievements().size(); i++){
                        System.out.println("Nombre: " + appLogro.getGame().getAvailableGameStats().getAchievements().get(i).getDisplayName());
                        System.out.println("Icono: " + appLogro.getGame().getAvailableGameStats().getAchievements().get(i).getIcon());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w(null, Arrays.toString(t.getStackTrace()));
            }
        });
    }

    public void getSteamAppsCompradas(String appid){
        //Hacemos una llamada
        Call<SteamJuegosComprados> LogrosGenCall = serviceAppsCompradas.steamAppsCompradas(appid);
        LogrosGenCall.enqueue(new Callback<SteamJuegosComprados>() {
            @Override
            public void onResponse(Response<SteamJuegosComprados> response, Retrofit retrofit) {
                if(response.isSuccess()) {
                    SteamJuegosComprados appsCompradas = response.body();
                    System.out.println("Numero de juegos comprados: " + appsCompradas.getResponse().getGameCount());
                    for (int i=0; i<appsCompradas.getResponse().getGames().size(); i++){
                        System.out.println("Nombre: " + appsCompradas.getResponse().getGames().get(i).getAppid());
                        System.out.println("Tiempo total: " + appsCompradas.getResponse().getGames().get(i).getPlaytimeForever());
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w(null, Arrays.toString(t.getStackTrace()));
            }
        });
    }

    public void getSteamAmigos(String steamid){
        //Hacemos una llamada
        Call<SteamAmigos> AmigosCall = serviceAmigos.steamAmigos(steamid);
        AmigosCall.enqueue(new Callback<SteamAmigos>() {
            @Override
            public void onResponse(Response<SteamAmigos> response, Retrofit retrofit) {
                if(response.isSuccess()) {
                    SteamAmigos listaAmigos = response.body();
                    System.out.println("Numero de Amigos: " + listaAmigos.getFriendslist().getFriends().size());
                    for (int i=0; i<listaAmigos.getFriendslist().getFriends().size(); i++){

                        Call<SteamPlayer> NombreCall = servicePerfil.steamPerfil(listaAmigos.getFriendslist().getFriends().get(i).getSteamid());

                        NombreCall.enqueue(new Callback<SteamPlayer>() {
                            @Override
                            public void onResponse(Response<SteamPlayer> response, Retrofit retrofit) {
                                if (response.isSuccess()) {
                                    SteamPlayer player = response.body();
                                    System.out.println("Nombre: " + player.getResponse().getPlayers().get(0).getPersonaname());
                                }
                            }

                            @Override
                            public void onFailure(Throwable t) {
                                Log.w(null, Arrays.toString(t.getStackTrace()));
                            }
                        });
                        System.out.println("Tiempo de amigos: " + listaAmigos.getFriendslist().getFriends().get(i).getFriendSince());
                        System.out.println("Relacion: " + listaAmigos.getFriendslist().getFriends().get(i).getRelationship());
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

interface LlamadaPerfilInterface {
    @GET("ISteamUser/ResolveVanityURL/v0001/?key=9DED78B02A80DE9A7062EB2822D42C11")
    Call<SteamIDs> steamIDs(
            @Query("vanityurl") String vanityurl
    );

    @GET("ISteamUser/GetPlayerSummaries/v0002/?key=9DED78B02A80DE9A7062EB2822D42C11")
    Call<SteamPlayer> steamPerfil(
            @Query("steamids") String steamids
    );
}
interface LlamadaAppsInterface{
    @GET("ISteamApps/GetAppList/v2")
    Call<SteamAppList> steamApps();
}
interface LlamadaLogrosGeneralesInterface{
    @GET("ISteamUserStats/GetSchemaForGame/v2/?key=9DED78B02A80DE9A7062EB2822D42C11")
    Call<SteamLogrosGenerales> steamLogrosGeneral(
            @Query("appid") String appid
    );
}
interface LlamadaAppsCompradasInterface{
    @GET("IPlayerService/GetOwnedGames/v0001/?key=9DED78B02A80DE9A7062EB2822D42C11")
    Call<SteamJuegosComprados> steamAppsCompradas(
            @Query("steamid") String steamid
    );
}
interface LlamadaAmigosInterface{
    @GET("ISteamUser/GetFriendList/v0001/?key=9DED78B02A80DE9A7062EB2822D42C11")
    Call<SteamAmigos> steamAmigos(
            @Query("steamid") String steamid
    );
}