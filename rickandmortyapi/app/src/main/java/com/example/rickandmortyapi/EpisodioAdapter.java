package com.example.rickandmortyapi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rickandmortyapi.Models.Episodios;

import java.util.ArrayList;

public class EpisodioAdapter extends BaseAdapter {
    private Activity contexto;
    private ArrayList<Episodios> dataset;

    public EpisodioAdapter(Activity contexto, ArrayList<Episodios> dataset) {
        this.contexto = contexto;
        this.dataset = dataset;
    }

    @Override
    public int getCount() {
        return dataset.size();
    }

    @Override
    public Object getItem(int position) {
        return dataset.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_episodio, null);
        }
        Episodios episodiosObject = dataset.get(position);

        TextView txtId = v.findViewById(R.id.txttypel);
        txtId.setText(String.valueOf(episodiosObject.getId()));

        TextView txtpilot = v.findViewById(R.id.txtnamel);
        txtpilot.setText(episodiosObject.getName());

       // TextView txtfecha = v.findViewById(R.id.txturl);
       // txtfecha.setText(episodiosObject.getAir_date());

        return v;
    }
}


