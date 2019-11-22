package com.example.entregable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import java.util.Calendar;
import java.util.Date;

public class Calendario extends AppCompatActivity {
    Button btn;
    CalendarView cal;
    long fecha = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        cal = findViewById(R.id.cv);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Calendar c= Calendar.getInstance();
                c.set(year, month, dayOfMonth);
                fecha=c.getTimeInMillis();
            }
        });
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = getIntent();
                it.putExtra("FECHA",fecha);
                setResult(RESULT_OK,it);
                finish();
            }
        });
    }
}
