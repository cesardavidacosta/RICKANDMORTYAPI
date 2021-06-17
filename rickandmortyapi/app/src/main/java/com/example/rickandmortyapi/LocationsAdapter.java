package com.example.rickandmortyapi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rickandmortyapi.Models.Locations;

import java.util.ArrayList;

public class LocationsAdapter extends BaseAdapter {
    private Activity contexto;
    private ArrayList<Locations> dataset;

    public LocationsAdapter(Activity contexto, ArrayList<Locations> dataset) {
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
            v = inf.inflate(R.layout.item_locations, null);
        }
        Locations locationsObject = dataset.get(position);

        TextView txtidl = v.findViewById(R.id.txtidl);
        txtidl.setText(String.valueOf(locationsObject.getId()));

        TextView txtnamel= v.findViewById(R.id.txtnamel);
        txtnamel.setText(String.valueOf(locationsObject.getName()));

        TextView txttypel = v.findViewById(R.id.txttypel);
        txttypel.setText(String.valueOf(locationsObject.getType()));

        TextView txtdimension = v.findViewById(R.id.txtdimension);
        txtdimension.setText(String.valueOf(locationsObject.getDimension()));

        TextView txturll = v.findViewById(R.id.txturll);
        txturll.setText(String.valueOf(locationsObject.getUrl()));

        return v;
    }
}
