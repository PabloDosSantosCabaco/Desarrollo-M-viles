package com.example.ejercicio4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio4_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4_2);

        TextView txtEdadNumber = findViewById(R.id.txtEdadNumero);
        TextView txtScoreNumber = findViewById(R.id.txtScoreNumero);
        Button btnCall = findViewById(R.id.btnCall);

        Intent it = getIntent();
        txtEdadNumber.setText(it.getStringExtra("Edad"));
        txtScoreNumber.setText(it.getFloatExtra("Estrellas", 0) + "");

        btnCall.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}
