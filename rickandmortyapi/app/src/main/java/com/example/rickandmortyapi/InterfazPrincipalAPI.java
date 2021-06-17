package com.example.rickandmortyapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.rickandmortyapi.ApiManager.RickAndMortyService;
import com.example.rickandmortyapi.Models.Personaje;
import com.example.rickandmortyapi.Models.PersonajesRespuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InterfazPrincipalAPI extends AppCompatActivity {

    private static final String TAG = "RICKANDMORTY";

    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private PersonajeAdapter listaPersonajeAdapter;

    private int offset;

    private boolean aptoParaCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_principal_a_p_i);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewPersonajes);
        listaPersonajeAdapter = new PersonajeAdapter(this);
        recyclerView.setAdapter(listaPersonajeAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.se
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final.");

                            aptoParaCargar = false;
                            offset += 40;
                            obtenerDatos(offset);
                        }
                    }
                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        aptoParaCargar = true;
        offset = 0;
        obtenerDatos(offset);
    }
    private void obtenerDatos(int offset){
        RickAndMortyService service = retrofit.create(RickAndMortyService.class);
        Call<PersonajesRespuesta> PersonajesRespuestaCall = service.obtenerlistaPersonaje(40, offset);

        PersonajesRespuestaCall.enqueue(new Callback<PersonajesRespuesta>() {
            @Override
            public void onResponse(Call<PersonajesRespuesta> call, Response<PersonajesRespuesta> response) {
                aptoParaCargar= true;
                if (response.isSuccessful()) {

                    PersonajesRespuesta personajesRespuesta = response.body();
                    ArrayList<Personaje> listaPersonaje= personajesRespuesta.getResults();

                    listaPersonajeAdapter.adicionarListaPersonaje(listaPersonaje);

                }else {
                    Log.e(TAG,"onResponse: " + response.errorBody());
                }

            }
            @Override
            public void onFailure(Call<PersonajesRespuesta> call, Throwable t) {
               aptoParaCargar = true;
                Log.e(TAG,"onFailure: " + t.getMessage());

            }
        });
    }
}