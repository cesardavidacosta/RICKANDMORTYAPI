package com.example.rickandmortyapi.ApiManager;

import com.example.rickandmortyapi.Models.Episodios;
import com.example.rickandmortyapi.Models.EpisodiosRespuesta;
import com.example.rickandmortyapi.Models.LocationsRespuesta;
import com.example.rickandmortyapi.Models.Personaje;
import com.example.rickandmortyapi.Models.PersonajesRespuesta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RickAndMortyService {

    @GET("character")
    Call<PersonajesRespuesta> obtenerlistaPersonaje(@Query("limit") int limit, @Query("offset") int offset);


    @GET("episode")
    Call<EpisodiosRespuesta> obtenerlistaEpisodios(@Query("limit") int limit, @Query("offset") int offset);


    @GET("episode/{int}")
    Call<Episodios> obtenerEpisodio(@Path("int") int id);

    @GET("location")
    Call<LocationsRespuesta> obtenerlistalocations(@Query("limit") int limit, @Query("offset") int offset);

}
