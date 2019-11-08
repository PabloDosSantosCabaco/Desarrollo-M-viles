package com.example.probandocosasnuevasuwu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnPosicion =(Button)findViewById(R.id.button);
        btnPosicion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Double lat = 42.237109; Double lon = -8.723474;
                int zoom = 22;
                String label = "MiPunto";
// try {label=URLEncoder.encode("label","UTF-8");} catch (UnsupportedEncodingException e){}
                String uri = String.format(Locale.US,"geo:%f,%f?z=%d&q=%f,%f(%s)", lat, lon, zoom, lat, lon, label);
                intent.setData(Uri.parse(uri));
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
            }
        });
    }
}
