package com.example.libros;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Libro> libros;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        libros=new ArrayList<>();
        for(int i=0; i<90; i++){
            libros.add(new Libro("¿Sueñan?","Philip k dick",123,4.4f,R.drawable.escritor1));
            libros.add(new Libro("Mundo Anillo","Larry Niven",123,4.4f,R.drawable.escritor2));
            libros.add(new Libro("Pórtico","Frederik Pohl",123,4.4f,R.drawable.escritor3));
            libros.add(new Libro("Fundacion","Isaac Asimov",123,4.4f,R.drawable.escritor4));
            libros.add(new Libro("Fahrenheit 451","Ray Bradbury",123,4.4f,R.drawable.escritor5));
            libros.add(new Libro("Cita con rama","Arthur C. Clarke",123,4.4f,R.drawable.escritor6));
            libros.add(new Libro("20.000 Leguas de viaje submarino?","Julio Verne",123,4.4f,R.drawable.escritor7));

        }
        rv=findViewById(R.id.rv);
        MiAdaptador adaptador = new MiAdaptador(libros);
        GridLayoutManager gy = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(gy);
        rv.setAdapter(adaptador);
    }
}
