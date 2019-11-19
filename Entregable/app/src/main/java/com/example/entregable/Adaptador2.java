package com.example.entregable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adaptador2 extends RecyclerView.Adapter<Adaptador2.MiHolder> {
    ArrayList<Pelicula> peliculas;

    public Adaptador2(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elemento = LayoutInflater.from(parent.getContext()).inflate(R.layout.pelislista,
                parent,false);
        MiHolder mh = new MiHolder(elemento);
        return mh;

    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {
        Pelicula peli = this.peliculas.get(position);
        holder.imgClasi.setImageResource(peli.getClasi());
        holder.txtDirector.setText(peli.getDirector());
        holder.txtDuracion.setText(peli.getDuracion());
        holder.txtFechaEstreno.setText(peli.getFecha().toString());
        holder.txtSala.setText(peli.getSala());
        holder.imgClasi.setImageResource(peli.getClasi());
        //holder.imgFav.setImageResource();
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public class MiHolder extends RecyclerView.ViewHolder{
        private ImageView imgCaratula;
        private TextView txtDirector;
        private TextView txtFechaEstreno;
        private TextView txtDuracion;
        private TextView txtSala;
        private ImageView imgClasi;
        private ImageView imgFav;

        public MiHolder(View itemView) {
            super(itemView);
            this.imgCaratula = itemView.findViewById(R.id.imgCaratula);
            this.txtDirector = itemView.findViewById(R.id.txtDirector);
            this.txtFechaEstreno = itemView.findViewById(R.id.txtFechaEstreno);
            this.txtDuracion = itemView.findViewById(R.id.txtDuracion);
            this.txtSala = itemView.findViewById(R.id.txtSala);
            this.imgClasi = itemView.findViewById(R.id.imgClasi);
            this.imgFav = itemView.findViewById(R.id.imgFav);
        }
    }
}
