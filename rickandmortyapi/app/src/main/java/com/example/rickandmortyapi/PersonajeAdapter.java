package com.example.rickandmortyapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.rickandmortyapi.Models.Personaje;
import java.util.ArrayList;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.ViewHolder> {

    private ArrayList<Personaje> dataset;
    private Context contexto;

    public PersonajeAdapter(Context context) {
        this.contexto = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personaje, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Personaje p = dataset.get(position);
        holder.txtname.setText(p.getName());
        holder.txtstatus.setText(p.getStatus());
        holder.txtSpecies.setText(p.getSpecies());
        holder.txtType.setText(p.getType());
        holder.txturl.setText(p.getUrl());

        Glide.with(contexto)
                .load(p.getImage() )
                .centerCrop()
                .placeholder(R.drawable.fondo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ImagViewPersonaje);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaPersonaje(ArrayList<Personaje> listaPersonaje) {
        dataset.addAll(listaPersonaje);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ImagViewPersonaje;
        private TextView txtname;
        private TextView txtstatus;
        private TextView txtSpecies;
        private TextView txtType;
        private TextView txturl;

        public ViewHolder(View itemView) {
            super(itemView);

            ImagViewPersonaje = (ImageView) itemView.findViewById(R.id.imagViewPersonaje);
            txtname = (TextView) itemView.findViewById(R.id.txtname);
            txtstatus = (TextView) itemView.findViewById(R.id.txtpagina);
            txtSpecies = (TextView) itemView.findViewById(R.id.txturl);
            txtType = (TextView) itemView.findViewById(R.id.txtType);
            txturl = (TextView) itemView.findViewById(R.id.txtUrl);

       }
    }
}