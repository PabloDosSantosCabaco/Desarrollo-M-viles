package com.example.entregable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoCompleto extends AppCompatActivity {
    ActionBar ab;
    RecyclerView rv;
    ArrayList<Pelicula> pelis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_completo);
        ab = getSupportActionBar();
        Intent it = getIntent();

        rv = findViewById(R.id.rvListado);
        pelis = (ArrayList<Pelicula>) it.getSerializableExtra("Peliculas");
        Adaptador2 adaptador2 = new Adaptador2(pelis,rv);
        GridLayoutManager gi = new GridLayoutManager(this,1,
            GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(gi);
        rv.setAdapter(adaptador2);

        View.OnClickListener eventoPulsacion2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ListadoCompleto.this, Cartel.class);
                int pos = rv.getChildAdapterPosition(v);
                it.putExtra("Cartel", pelis.get(pos).getPortada());
                it.putExtra("Sinopsis",pelis.get(pos).getSinopsis());
                it.putExtra("Link",pelis.get(pos).getIdYoutube());
                startActivity(it);
            }
        };
        adaptador2.setOnClickListener(eventoPulsacion2);

        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return false;
        }
    }
}
