package com.example.tema3_ej3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class EscogerHora extends AppCompatActivity {
int hora, minuto;
    SimpleDateFormat timeFormat;
String formatoHora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escoger_hora);

        final TimePicker tpClock = findViewById(R.id.tpClock);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnCancel = findViewById(R.id.btnCancel);

        tpClock.setIs24HourView(true);
        hora = tpClock.getHour();
        minuto = tpClock.getMinute();
        timeFormat = new SimpleDateFormat("hh:mm");

        formatoHora = (hora<10?"0"+hora:hora)+":"+(minuto<10?"0"+minuto:minuto);

        tpClock.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                hora = tpClock.getHour();
                minuto = tpClock.getMinute();
                formatoHora = (hora<10?"0"+hora:hora)+":"+(minuto<10?"0"+minuto:minuto);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.putExtra("HORA",formatoHora);
                setResult(RESULT_OK,it);
                finish();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
