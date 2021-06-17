package com.example.rickandmortyapi.Models;

import android.widget.ImageButton;
import android.widget.TextView;

public class Personaje {

    private int id;
    private String name;
    private String image;
    private String status;
    private String species;
    private String type;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        species = species;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//public int getNumber() {
        //String[] urlPartes = url.split("/");
        //return Integer.parseInt(urlPartes[urlPartes.length -1]);
    //}
    //public void setNumber(int number) {
     //   this.number = number;
    //}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
