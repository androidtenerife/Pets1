package com.chaacho.pets1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.miApbar);
        setSupportActionBar(toolbar);

        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }catch(NullPointerException e){

        }
        // Intento recoger los valores de la mascota.
        Bundle parametros       = getIntent().getExtras();
        int datofoto         = parametros.getInt("foto");


        String datonombre       = parametros.getString("nombre");
        String datorating       = parametros.getString("rating");
        TextView tvnombre       = (TextView) findViewById(R.id.textViewNombre);
        //Cargo nuevamente la foto de la mascota en la vista detalle.
        ImageView ivfoto        = (ImageView) findViewById(R.id.imageViewFoto);
        TextView tvrating= (TextView) findViewById(R.id.textViewRating);
        tvnombre.setText(datonombre);
        tvrating.setText(datorating);
       //Coloco la foto...
        ivfoto.setImageResource(datofoto);
    }
}
