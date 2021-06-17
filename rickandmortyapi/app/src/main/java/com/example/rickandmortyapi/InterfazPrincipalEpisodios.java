package com.example.rickandmortyapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.rickandmortyapi.ApiManager.RickAndMortyService;
import com.example.rickandmortyapi.Models.Episodios;
import com.example.rickandmortyapi.Models.EpisodiosRespuesta;
import com.example.rickandmortyapi.Models.PersonajesRespuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InterfazPrincipalEpisodios extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = "RICKANDMORTY";
    EpisodiosRespuesta listaepisodios;

    private Retrofit retrofit;
    private RecyclerView reciclerViewEpisodios;
    private EpisodioAdapter listaEpisodioAdapter;
    private ListView listViewEpisodios;


    private int offset;
    private boolean listoparaCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_principal_episodios);
        listViewEpisodios = findViewById(R.id.listViewEpisodios);
        listViewEpisodios.setOnItemClickListener(this);



        retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        listoparaCargar = false;
        offset = 0;
        obtenerEpisodios(offset);

    }
    private void obtenerEpisodios(int offset){
        RickAndMortyService service = retrofit.create((RickAndMortyService.class));
        Call<EpisodiosRespuesta> llamadoEpisodiosRespuesta = service.obtenerlistaEpisodios(40, offset);

        llamadoEpisodiosRespuesta.enqueue(new Callback<EpisodiosRespuesta>() {
            @Override
            public void onResponse(Call<EpisodiosRespuesta> call, Response<EpisodiosRespuesta> response) {
                if (response.isSuccessful()){
                    listaepisodios= response.body();
                            EpisodioAdapter adapter = new EpisodioAdapter(InterfazPrincipalEpisodios. this, listaepisodios.getResults());
                            listViewEpisodios.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<EpisodiosRespuesta> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intentdetalles = new Intent(this, Detalles_Episodios.class);
        intentdetalles.putExtra("id", listaepisodios.getResults().get(position).getId());
        startActivity(intentdetalles);
    }
}

