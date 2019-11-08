package com.example.tema3_ej3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    int MIREQUESTCODEF=1;
    int MIREQUESTCODEH=2;
    TextView txtDate;
    TextView txtHour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDate = findViewById(R.id.txtDate);
        txtHour = findViewById(R.id.txtHour);
        RadioGroup rGroup = findViewById(R.id.rdBtnGrp);
        Button btnCalendar = findViewById(R.id.btnDate);
        Button btnHour = findViewById(R.id.btnHour);

        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, EscogerFecha.class);
                startActivityForResult(it,MIREQUESTCODEF);
            }
        });
        btnHour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, EscogerHora.class);
                startActivityForResult(it,MIREQUESTCODEH);
            }
        });

        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                Toast.makeText(MainActivity.this, rb.getText()+" selected", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == MIREQUESTCODEF && resultCode == RESULT_OK){
            long fecha = data.getLongExtra("FECHA",0);
            SimpleDateFormat dateText = new SimpleDateFormat("dd/MM/yyyy");
            txtDate.setText(""+dateText.format(fecha));
        }
        if(requestCode == MIREQUESTCODEH && resultCode == RESULT_OK){
            String hora = data.getStringExtra("HORA");
            txtHour.setText(""+hora);
        }
    }
}
