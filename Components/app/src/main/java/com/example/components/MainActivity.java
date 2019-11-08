package com.example.components;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int contador = 0, valor = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnReset = (Button) findViewById(R.id.btnReset);
        Button btnImg = (Button) findViewById(R.id.btnImage);
        final TextView btnTxt = (TextView) findViewById(R.id.btnTxt);
        final ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        final CheckBox chckBox1 = (CheckBox) findViewById(R.id.checkBox4);
        final CheckBox chckBox2 = (CheckBox) findViewById(R.id.checkBox5);
        final RadioButton rdBtn = (RadioButton) findViewById(R.id.radioButton);
        final Switch interruptor = (Switch) findViewById(R.id.switch2);
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        final TextView seekBarText = (TextView) findViewById(R.id.seekBarText);
        final RatingBar estrellas = (RatingBar) findViewById(R.id.ratingBar);
        final TextInputEditText inputText = (TextInputEditText) findViewById(R.id.inputText);

        if (interruptor.isChecked())    interruptor.setText(interruptor.getTextOn());
        else interruptor.setText(interruptor.getTextOff());

        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chckBox2.isChecked())    valor = -1;
                else    valor = 1;
                contador+=valor;
                btnTxt.setText(String.valueOf(contador));
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleButton.setChecked(false);
                contador = 0;
                btnTxt.setText(String.valueOf(contador));
                chckBox1.setChecked(false);
                chckBox2.setChecked(false);
                rdBtn.setChecked(false);
                interruptor.setChecked(false);
                interruptor.setText(interruptor.getTextOff());
                seekBar.setProgress(0);
                estrellas.setRating(0);
                inputText.setText("");
            }
        });
        interruptor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interruptor.isChecked())    interruptor.setText(interruptor.getTextOn());
                else interruptor.setText(interruptor.getTextOff());
            }
        });
        seekBarText.setText(String.valueOf(seekBar.getProgress()));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarText.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chckBox1.setChecked(!isChecked);
            }
        });
    }
}
