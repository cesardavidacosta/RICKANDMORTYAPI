package com.example.rickandmortyapi.Models;

import java.util.ArrayList;

public class LocationsRespuesta {
    private ArrayList<Locations> results;

    public ArrayList<Locations> getResults() {
        return results;
    }

    public void setResults(ArrayList<Locations> results) {
        this.results = results;
    }
}
