package com.example.libros;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.Elemento> {
    ArrayList<Libro> libros;

    public MiAdaptador(ArrayList<Libro> libros) {
        this.libros = libros;
    }


    @NonNull
    @Override
    public Elemento onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View celda = LayoutInflater.from(parent.getContext()).inflate(R.layout.posicion,
                parent,false);
        Elemento ele = new Elemento(celda);
        return ele;
    }

    @Override
    public void onBindViewHolder(@NonNull Elemento holder, int position) {
        Libro l = libros.get(position);
        holder.titulo.setText(l.getNombre());
        holder.autor.setText(l.getAutor());
        holder.paginas.setText(l.getNumPaginas()+"");
        holder.valoracion.setRating(l.getValoracion());
        holder.portada.setImageResource(l.getPortada());
    }

    @Override
    public int getItemCount() {
        return libros.size();
    }

    public static class Elemento extends RecyclerView.ViewHolder {
        TextView titulo, autor, paginas;
        RatingBar valoracion;
        ImageView portada;

        public Elemento(@NonNull View itemView) {
            super(itemView);
            this.titulo = itemView.findViewById(R.id.txtvTitulo);
            this.autor = itemView.findViewById(R.id.txtvAutor);
            this.paginas = itemView.findViewById(R.id.txtvPaginas);
            this.valoracion = itemView.findViewById(R.id.rbStars);
            this.portada = itemView.findViewById(R.id.imgvLogo);

        }
    }
}
