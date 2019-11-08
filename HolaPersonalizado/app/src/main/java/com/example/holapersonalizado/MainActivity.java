package com.example.holapersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText eTNombre = findViewById(R.id.eTNombre);
        final TextView txtSaludo = findViewById(R.id.lblSaludo);
        Button btnAceptar = findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSaludo.setText("Hola "+eTNombre.getText());
                eTNombre.setText("");
            }
        });
    }
}
