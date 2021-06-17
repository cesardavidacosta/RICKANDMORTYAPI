package com.example.rickandmortyapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.rickandmortyapi.ApiManager.RickAndMortyService;
import com.example.rickandmortyapi.Models.EpisodiosRespuesta;
import com.example.rickandmortyapi.Models.LocationsRespuesta;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InterfazPrincipalLocations extends AppCompatActivity {
    private static final String TAG = "RICKANDMORTY";
    LocationsRespuesta listalocations;

    private Retrofit retrofit;
    private ListView listViewLocations;
    private int offset;
    private boolean listoparaCargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_principal_locations);
        listViewLocations = findViewById(R.id.listViewLocations);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        listoparaCargar = false;
        offset = 0;
        obtenerLocations(offset);

    }

    private void obtenerLocations(int offset) {
        RickAndMortyService service = retrofit.create((RickAndMortyService.class));
        Call<LocationsRespuesta> llamadoLocationsRespuesta = service.obtenerlistalocations(40, offset);

        llamadoLocationsRespuesta.enqueue(new Callback<LocationsRespuesta>() {
            @Override
            public void onResponse(Call<LocationsRespuesta> call, Response<LocationsRespuesta> response) {
                if (response.isSuccessful()) {
                    listalocations = response.body();
                    LocationsAdapter adapter = new LocationsAdapter(InterfazPrincipalLocations.this, listalocations.getResults());
                    listViewLocations.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<LocationsRespuesta> call, Throwable t) {

            }
        });
    }
}
