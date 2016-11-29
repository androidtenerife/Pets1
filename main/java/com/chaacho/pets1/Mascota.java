package com.chaacho.pets1;

/**
 * Created by Daniel on 08/11/2016.
 */

public class Mascota {
    private String Nombre;
    private String Rating;
    private int Foto;


    public Mascota (int Foto, String Nombre, String Rating){
        this.Foto=Foto;
        this.Nombre=Nombre;
        this.Rating=Rating;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }
}
