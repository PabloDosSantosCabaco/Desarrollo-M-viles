package com.example.entregable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AddPeli extends AppCompatActivity {
    ActionBar ab;
    Button btnFecha;
    TextView txtFecha, txtError;
    TextView txtDirector, txtTitulo, txtDuracion;
//    NumberFormat etxtDuracion;
    EditText etxtTitulo, etxtDirector, etxtDuracion;
    Spinner spinner;
    RadioGroup rg;
    int MYREQUESTCODEDATE = 0;
    Pelicula newPeli;

    String titulo, director, sala;
    int duracion, clasi, portada;
    Date fecha;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.addmovie,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_peli);

        txtError = findViewById(R.id.txtError);
        txtError.setAlpha(0);
        Intent it = getIntent();

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

        //Construyo el apartado salas e inicializo su valor
        spinner = findViewById(R.id.spinner);
        final String[] salas = getResources().getStringArray(R.array.salas);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,salas);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                    sala = parent.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //Inicializo el valor de clasificacion
        rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.r:
                        clasi = R.drawable.r;
                        break;
                    case R.id.nc17:
                        clasi = R.drawable.nc17;
                        break;
                    case R.id.pg:
                        clasi = R.drawable.pg;
                        break;
                    case R.id.pg13:
                        clasi = R.drawable.pg13;
                        break;
                    case R.id.g:
                        clasi = R.drawable.g;
                        break;

                }
            }
        });
        clasi = R.drawable.g;
        //Construyo el apartado fecha
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
            long fechaAux = data.getLongExtra("FECHA",0);
            SimpleDateFormat dateText = new SimpleDateFormat("dd/MM/yyyy");
            txtFecha.setText(""+dateText.format(fechaAux));
            fecha = new Date(fechaAux);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.itemAceptar:
                if(!etxtTitulo.getText().equals("") &&
                    !etxtDirector.getText().equals("") &&
                    !etxtDuracion.getText().equals("") &&
                    !txtFecha.getText().equals(getString(R.string.fechaNull))) {


                    director = etxtDirector.getText().toString();
                    duracion = Integer.parseInt(etxtDuracion.getText().toString());
                    titulo = etxtTitulo.getText().toString();
                    portada = R.drawable.newcover;
                    newPeli = new Pelicula(titulo, director, duracion, fecha, sala, clasi, portada);
                    MainActivity.pelis.add(newPeli);
                    Intent it = new Intent();
                    setResult(RESULT_OK, it);
                    finish();
                    return true;
                }else{
                    txtError.setAlpha(1);
                    return false;
                }
            case R.id.itemCancelar:
                onBackPressed();
                return true;
            default:
                return false;
        }
    }
}
