package com.example.rickandmortyapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.rickandmortyapi.ApiManager.RickAndMortyService;
import com.example.rickandmortyapi.Models.Episodios;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Detalles_Episodios extends AppCompatActivity {
    Episodios episodiosabuscar;
    private TextView txtairdate;
    private TextView txtpilot;
    private TextView txturl;

    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_episodios);
        int id = getIntent().getExtras().getInt("id");
        txtairdate= findViewById(R.id.txtairdate);
        txtpilot=findViewById(R.id.txtnamel);
        txturl=findViewById(R.id.txturl);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        obtenerEpisodios(id);

    }

    private void obtenerEpisodios(int id){
        RickAndMortyService service = retrofit.create((RickAndMortyService.class));
        Call<Episodios> llamadoEpisodiosRespuesta = service.obtenerEpisodio(id);

        llamadoEpisodiosRespuesta.enqueue(new Callback<Episodios>() {
            @Override
            public void onResponse(Call<Episodios> call, Response<Episodios> response) {
                if (response.isSuccessful()) {
                    episodiosabuscar= response.body();
                    txtairdate.setText(episodiosabuscar.getAir_date());
                    txtpilot.setText(episodiosabuscar.getEpisode());
                    txturl.setText(episodiosabuscar.getUrl());


                }
            }

            @Override
            public void onFailure(Call<Episodios> call, Throwable t) {

            }
        });


    }
}