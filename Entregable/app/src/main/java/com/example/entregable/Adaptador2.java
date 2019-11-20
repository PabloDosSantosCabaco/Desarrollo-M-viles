package com.example.entregable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adaptador2 extends RecyclerView.Adapter<Adaptador2.MiHolder> implements View.OnClickListener {
    ArrayList<Pelicula> peliculas;
    private View.OnClickListener listener;
    RecyclerView rv;
    public Adaptador2(ArrayList<Pelicula> peliculas, RecyclerView rv) {
        this.peliculas = peliculas;
        this.rv = rv;
    }
    @Override
    public void onClick(View v) {
        if(listener!=null)listener.onClick(v);
    }

    public void setOnClickListener(View.OnClickListener v){
        this.listener = v;
    }
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elemento = LayoutInflater.from(parent.getContext()).inflate(R.layout.pelislista,
                parent,false);
        elemento.setOnClickListener(this);
        MiHolder mh = new MiHolder(elemento);
        return mh;

    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {
        Pelicula peli = this.peliculas.get(position);
        holder.imgCaratula.setImageResource(peli.getPortada());
        holder.txtDirector.setText(peli.getDirector());
        holder.txtDuracion.setText(peli.getDuracion()+" minutos");
        holder.txtFechaEstreno.setText(peli.getFecha2());
        holder.txtSala.setText(peli.getSala());
        holder.imgClasi.setImageResource(peli.getClasi());
        holder.imgFav.setImageResource(android.R.drawable.btn_star_big_on);
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
