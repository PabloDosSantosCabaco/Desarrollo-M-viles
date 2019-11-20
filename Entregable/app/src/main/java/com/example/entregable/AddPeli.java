package com.example.entregable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class AddPeli extends AppCompatActivity {
    ActionBar ab;
    Button btnFecha;
    TextView txtFecha;
    TextView txtDirector, txtTitulo, txtDuracion;
    EditText etxtTitulo, etxtDirector, etxtDuracion;
    Spinner spinner;
    RadioGroup rg;

    int MYREQUESTCODEDATE = 0;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.addmovie,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_peli);

        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        btnFecha = findViewById(R.id.btnChosseFecha);
        txtFecha = findViewById(R.id.txtFecha);
        etxtDirector = findViewById(R.id.etxtDirector);
        etxtTitulo = findViewById(R.id.etxtTitulo);
        etxtDuracion = findViewById(R.id.etxtDuracion);
        txtTitulo = findViewById(R.id.txtTitulo);
        txtDirector = findViewById(R.id.txtDirector);
        txtDuracion = findViewById(R.id.txtDuracion);
        spinner = findViewById(R.id.spinner);
        rg = findViewById(R.id.rg);
        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(AddPeli.this, Calendario.class);
                startActivityForResult(it,MYREQUESTCODEDATE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == MYREQUESTCODEDATE && resultCode == RESULT_OK){
            txtFecha.setText(data.getStringExtra("Fecha"));
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.itemAceptar:
                return true;
            case R.id.itemCancelar:
                return true;
            default:
                return false;
        }
    }
}
