package com.example.entregable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {
    ArrayList<String> titulos = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView lv;
    Button btnAddFav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        btnAddFav = findViewById(R.id.btnAddFav);
        btnAddFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0; i<adapter.getCount(); i++){

                    MainActivity.pelis.get(i).setFavorita(lv.isItemChecked(i));
                }

                Intent it = new Intent();
                setResult(RESULT_OK, it);
                finish();
            }
        });
        lv = findViewById(R.id.lvPelis);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        Intent it = getIntent();
        for(int i=0; i<MainActivity.pelis.size(); i++){
            titulos.add(MainActivity.pelis.get(i).getTitulo());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, titulos);
        lv.setAdapter(adapter);
        for(int i=0; i<MainActivity.pelis.size(); i++){
            lv.setItemChecked(i,MainActivity.pelis.get(i).getFavorita());

        }
    }
}
