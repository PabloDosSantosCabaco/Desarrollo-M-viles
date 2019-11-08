package com.example.prueba;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAGEX = "ejercicio";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAGEX,"este es el método onCreate");

        Button btnBoton = findViewById(R.id.btnBoton);

        btnBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAGEX,"este es el método onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAGEX,"este es el método onPause de tipo ERROR");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAGEX,"este es el método onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void cambiarTexto(){
        Log.i(TAGEX, "heyy");
    }
}
