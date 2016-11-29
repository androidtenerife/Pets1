package com.chaacho.pets1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Contacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.miApbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button bot = (Button) findViewById(R.id.buttEnvComentario);
        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Implemento El Codigo para enviar correo.
                //Getting content for email
                EditText nom        = (EditText) findViewById(R.id.editTextNom);
                String nombre       = nom.getText().toString().toUpperCase();
                EditText correo     = (EditText) findViewById(R.id.editTextEmail);
                String email        = correo.getText().toString();
                EditText mensaje    = (EditText) findViewById(R.id.editTextMensaje);
                String message      = mensaje.getText().toString();
                String subject      = nombre +" Te envía un mensaje desde la app";

                //Creating SendMail object
                //SendMail sm = new SendMail(this, email, subject, message);
                SendMail sm         = new SendMail(email, subject, message);

                //Executing sendmail to send email
                sm.execute();
                // Fin del Implemento  del correo
                Toast toast = Toast.makeText(getApplicationContext(), "Enviando Correo", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
