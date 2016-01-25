package oscarxiii.xiii_game;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ScrollingActivityProfile extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;
    Context context;
    private TextView steamid;
    private TextView communityvisibilitystate;
    private TextView profilestate;
    private TextView personaname;
    private TextView lastlogoff;
    private TextView profileurl;
    private TextView avatar;
    private TextView avatarmedium;
    private TextView avatarfull;
    private TextView personastate;
    private TextView realname;
    private TextView primaryclanid;
    private TextView timecreated;
    private TextView personastateflags;
    private TextView loccountrycode;
    private TextView locstatecode;
    private TextView loccityid;


    protected void onCreate(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(ScrollingActivityProfile.this, BuscarPerfil.class);
                //startActivity(i);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView perfilLV = (ListView) findViewById(R.id.LVperfirl);
        View view = inflater.inflate(R.layout.activity_scrolling_activity_profile, container, false);

        steamid = (TextView) view.findViewById(R.id.steamidTV);
        communityvisibilitystate = (TextView) view.findViewById(R.id.communityvisibilitystateTV);
        profilestate = (TextView) view.findViewById(R.id.profilestateTV);
        personaname = (TextView) view.findViewById(R.id.personanameTV);
        lastlogoff = (TextView) view.findViewById(R.id.lastlogoffTV);
        profileurl = (TextView) view.findViewById(R.id.profileurlTV);
        avatar = (TextView) view.findViewById(R.id.avatarTV);
        avatarmedium = (TextView) view.findViewById(R.id.avatarmediumTV);
        avatarfull = (TextView) view.findViewById(R.id.avatarfullTV);
        personastate = (TextView) view.findViewById(R.id.personastateTV);
        realname = (TextView) view.findViewById(R.id.realnameTV);
        primaryclanid = (TextView) view.findViewById(R.id.primaryclanidTV);
        timecreated = (TextView) view.findViewById(R.id.timecreatedTV);
        personastateflags = (TextView) view.findViewById(R.id.personastateflagsTV);
        loccountrycode = (TextView) view.findViewById(R.id.loccountrycodeTV);
        locstatecode = (TextView) view.findViewById(R.id.locstatecodeTV);
        loccityid = (TextView) view.findViewById(R.id.loccityidTV);








 /*       items = new ArrayList<>();
        adapter = new ArrayAdapter<String>(
                this,
                R.layout.lv_perfil,
                R.id.steamidTV,
                R.id.communityvisibilitystateTV,
                R.id.profilestateTV,
                R.id.personanameTV,
                R.id.lastlogoffTV,
                R.id.profileurlTV,
                R.id.avatarTV,
                R.id.avatarmediumTV,
                R.id.avatarfullTV,
                R.id.personastateTV,
                R.id.realnameTV,
                R.id.primaryclanidTV,
                R.id.timecreatedTV,
                R.id.personastateflagsTV,
                R.id.loccountrycodeTV,
                R.id.locstatecodeTV,
                R.id.loccityidTV,
                items
        );
        perfilLV.setAdapter(adapter);*/
    }

}
