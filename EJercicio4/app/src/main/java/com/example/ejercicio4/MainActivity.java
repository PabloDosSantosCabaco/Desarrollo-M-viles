package com.example.ejercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    int contador = 0;
    EditText txtEdad;
    ImageButton btnNext;
    ToggleButton tgBtn;
    CheckBox chkBoxStar;
    SeekBar sbBarra;
    TextView sbCount;
    TextView txtSwitch;
    Switch switchComp;
    TextView txtCont;
    CheckBox chBox2;
    RadioButton rdBtn;
    RatingBar rtBar;
    TextInputEditText inputTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtEdad = findViewById(R.id.eTxtEdad);
        btnNext = findViewById(R.id.imgBtnNext);
        tgBtn = findViewById(R.id.toggleButton);
        chkBoxStar = findViewById(R.id.checkBoxStar);
        sbBarra = findViewById(R.id.seekBar);
        sbCount = findViewById(R.id.contadorSeekBar);
        sbCount.setText(""+sbBarra.getProgress());
        switchComp = findViewById(R.id.switch1);
        txtSwitch = findViewById(R.id.txtSWitch);
        txtSwitch.setText(""+(switchComp.isChecked()?switchComp.getTextOn():switchComp.getTextOff()));
        Button btnContador = findViewById(R.id.btnContador);
        txtCont = findViewById(R.id.txtCont);
        chBox2 = findViewById(R.id.checkBox2);
        rdBtn = findViewById(R.id.radioButton);
        rtBar = findViewById(R.id.ratingBar);
        Button btnReset = findViewById(R.id.button);
        inputTxt = findViewById(R.id.textInputEditText);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,Ejercicio4_2.class);
                in.putExtra("Edad",txtEdad.getText().toString());
                Toast.makeText(MainActivity.this, "Hey", Toast.LENGTH_SHORT).show();
                in.putExtra("Estrellas",rtBar.getRating());
                startActivity(in);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        btnContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chBox2.isChecked()) contador++;
                else contador--;
                txtCont.setText(""+contador);
            }
        });
        sbBarra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sbCount.setText(""+sbBarra.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        switchComp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchComp.isChecked()) txtSwitch.setText(""+switchComp.getTextOn());
                else txtSwitch.setText(""+switchComp.getTextOff());
            }
        });
        tgBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkBoxStar.setChecked(!tgBtn.isChecked());
            }
        });

    }

    public void reset(){
        tgBtn.setChecked(false);
        chkBoxStar.setChecked(false);
        sbBarra.setProgress(0);
        sbCount.setText(""+sbBarra.getProgress());
        switchComp.setChecked(false);
        txtSwitch.setText(""+switchComp.getTextOff());
        contador=0;
        txtCont.setText(""+contador);
        chBox2.setChecked(false);
        rdBtn.setChecked(false);
        rtBar.setRating(0);
        inputTxt.setText("");
    }
}
