package com.example.entregable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Cartel extends AppCompatActivity {
    TextView txtSinopsis;
    ImageView imgCartel;
    ActionBar ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartel);

        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        txtSinopsis = findViewById(R.id.txtSinopsis);
        imgCartel = findViewById(R.id.imgCartel);

        Intent it = getIntent();
        txtSinopsis.setText("Sinopsis:\n"+it.getStringExtra("Sinopsis"));
        imgCartel.setImageResource(it.getIntExtra("Cartel",0));
        imgCartel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                watchYoutubeVideo(getIntent().getStringExtra("Link"));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return false;
        }
    }

    public  void watchYoutubeVideo(String id){
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }
}
