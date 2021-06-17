package com.example.rickandmortyapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class InterfazPrincipalBotones extends AppCompatActivity implements View.OnClickListener {


    private ImageButton imgPersonajes;
    private ImageButton imgEpisodios;
    private ImageButton imgUbicaciones;
    private TextView txtPer;
    private TextView txtEpi;
    private TextView txtLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz__botones);
        txtPer = findViewById(R.id.txtPer);
        txtLoc = findViewById(R.id.txtEpi);
        txtEpi = findViewById(R.id.txtLoc);
        imgEpisodios = findViewById(R.id.imgEpisodios);
        imgPersonajes = findViewById(R.id.imgPersonajes);
        imgUbicaciones = findViewById(R.id.imgUbicaciones);
        imgPersonajes.setOnClickListener(this);
        imgUbicaciones.setOnClickListener(this);
        imgEpisodios.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.imgPersonajes) {
            Intent myIntent = new Intent(this, InterfazPrincipalAPI.class);
            startActivity(myIntent);
       }else if(v.getId()==R.id.imgEpisodios) {
            Intent newIntent = new Intent(this, InterfazPrincipalEpisodios.class);
            startActivity(newIntent);
        }else if(v.getId()==R.id.imgUbicaciones){
            Intent newIntentdos = new Intent(this, InterfazPrincipalLocations.class);
            startActivity(newIntentdos);
        }
    }
}