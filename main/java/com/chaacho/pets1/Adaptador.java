package com.chaacho.pets1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Daniel on 07/11/2016.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.AdaptadorViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;//Defino aqui el activity para capturar el accion view
    public Adaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.activity=activity;
        this.mascotas=mascotas;
    }


    @Override
    public AdaptadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//Inflador de la vista o darle vida al layout inerte.
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new AdaptadorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final AdaptadorViewHolder adaptadorViewHolder, int position) {
    final Mascota mascota=mascotas.get(position);
        adaptadorViewHolder.cvImgFoto.setImageResource(mascota.getFoto());
        adaptadorViewHolder.cvNombre.setText(mascota.getNombre());
        adaptadorViewHolder.cvRating.setText(mascota.getRating());

        // Aquí se coloca el listener de la accion al hacer clic sobre la foto del Listview.
        // para enviar al activity de los detalles
        adaptadorViewHolder.cvImgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(activity, mascota.getNombre(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity,Detalle.class);
                intent.putExtra("nombre",mascota.getNombre());
                intent.putExtra("foto",mascota.getFoto());
                intent.putExtra("rating",mascota.getRating());
                activity.startActivity(intent);



            }
        });

        adaptadorViewHolder.cvLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Has dado Like a "+ mascota.getNombre(), Toast.LENGTH_SHORT).show();
                // Incremento de los LIKES
                String rating = mascota.getRating();
                int ratingInt = Integer.parseInt(rating);
                ratingInt++;
                rating = String.valueOf(ratingInt);
                mascota.setRating(rating);
                adaptadorViewHolder.cvRating.setText(rating);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    //Crear la clase estatica
    public static class AdaptadorViewHolder extends RecyclerView.ViewHolder {
        //Declaro aquí todos los textviews y demas que definí en el cardview.
        //RECUERDA QUE EN EL CARDVIEW ESTAN INERTES Y ES AHORA DONDE LOS DEFINIMOS Y DONDE LE DAREMOS PARTICIPACION Y VIDA.
        private ImageView cvImgFoto;
        private TextView cvNombre;
        private TextView cvRating;
        private ImageButton cvLike;

        public AdaptadorViewHolder(View itemView) {
            super(itemView);
            cvImgFoto       = (ImageView) itemView.findViewById(R.id.cvImgFoto);
            cvNombre        = (TextView) itemView.findViewById(R.id.cvNombre);
            cvRating        = (TextView) itemView.findViewById(R.id.cvRating);
            cvLike          = (ImageButton) itemView.findViewById(R.id.imageButton4);
        }
    }

}
