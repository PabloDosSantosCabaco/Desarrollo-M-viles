package com.example.entregable;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MiHolder>{

    ArrayList<Pelicula> elementos;

    public Adaptador(ArrayList<Pelicula> elementos) {
        this.elementos = elementos;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elemento = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento,
                parent,false);
        MiHolder mh = new MiHolder(elemento);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {
        Pelicula so = this.elementos.get(position);
        holder.titulo.setText(so.getTitulo());
        holder.director.setText(so.getDirector());
        holder.portada.setImageResource(so.getPortada());
        holder.edades.setImageResource(so.getClasi());

    }

    @Override
    public int getItemCount() {
        return this.elementos.size();
    }


    public class MiHolder extends RecyclerView.ViewHolder {

        private TextView titulo;
        private TextView director;
        private ImageView portada;
        private ImageView edades;

        public MiHolder(View itemView) {
            super(itemView);
            this.titulo=itemView.findViewById(R.id.txtTitulo);
            this.director=itemView.findViewById(R.id.txtDirector);
            this.portada=itemView.findViewById(R.id.imgPortada);
            this.edades=itemView.findViewById(R.id.imgEdades);
        }
    }



}
