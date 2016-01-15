package oscarxiii.xiii_game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BuscarPerfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_perfil);
        EditText buscador = (EditText) findViewById(R.id.Buscador);
        buscador.setText("oscarXIII");
        Button bt = (Button) findViewById(R.id.BuscarBT);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText buscador = (EditText) findViewById(R.id.Buscador);
                TextView texto = (TextView) findViewById(R.id.textoAmostrar);

                //String mierda = String.valueOf(buscador.setText(texto.getText()));
                LlamadaApi llamada = new LlamadaApi();
                llamada.getsteamID(texto, String.valueOf(buscador.getText()));
                Intent intent = new Intent(BuscarPerfil.this, ScrollingActivityProfile.class);
                startActivity(intent);

            }
        });


    }
}
