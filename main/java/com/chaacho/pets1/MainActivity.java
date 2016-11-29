package com.chaacho.pets1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Mascota mmascotas;
    ArrayList <Mascota>mascotas;
    Activity activity;
    private RecyclerView listamascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Defino la tolbar
        Toolbar miapbar = (Toolbar) findViewById(R.id.miApbar);
        setSupportActionBar(miapbar);
// Colocar el toolbar....
        listamascotas = (RecyclerView) findViewById(R.id.rvMascota);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listamascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

    }
// Activo el menu de opciones.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuoption, menu);
        return true;
    }
    // Activo las pulsaciones del menú.


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menuContacto:
                Intent intentContact = new Intent( this, Contacto.class);
                startActivity(intentContact);
                break;
            case R.id.menuAbout:
                Intent intentAb = new Intent( this, About.class );
                startActivity(intentAb);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void inicializarAdaptador(){
        Adaptador ad = new Adaptador(mascotas,this);
        listamascotas.setAdapter(ad);
    }
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.dog1, "Ja", "5"));
        mascotas.add(new Mascota(R.drawable.dog2, "Anil", "4"));
        mascotas.add(new Mascota(R.drawable.dog3, "Poto", "3"));
        mascotas.add(new Mascota(R.drawable.dog4, "Pupu", "2"));
        mascotas.add(new Mascota(R.drawable.dog5, "Pupa", "1"));

    }

    public void goDetalle(View view){
        ImageView iv = (ImageView) findViewById(R.id.cvImgFoto);
        int var = iv.getId();

        Intent intent=new Intent(this, About.class);
        intent.putExtra("Nombre", mmascotas.getNombre());
        intent.putExtra("Foto", mmascotas.getFoto());
        intent.putExtra("Rating", String.valueOf(mmascotas.getRating()));
        startActivity(intent);



    }



    public void iniciarLike(){
        Intent in = new Intent(this,Activity2.class);
        startActivity(in);
    }
}
