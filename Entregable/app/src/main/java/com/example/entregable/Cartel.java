package com.example.entregable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Cartel extends AppCompatActivity {
    TextView txtSinopsis;
    ImageView imgCartel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartel);

        txtSinopsis = findViewById(R.id.txtSinopsis);
        imgCartel = findViewById(R.id.imgCartel);

        Intent it = getIntent();
        txtSinopsis.setText(it.getStringExtra("Sinopsis"));
        imgCartel.setImageResource(it.getIntExtra("Cartel",0));
    }
}
