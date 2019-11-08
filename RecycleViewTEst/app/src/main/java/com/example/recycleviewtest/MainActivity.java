package com.example.recycleviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<SistemaOperativo> sistemas;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sistemas= new ArrayList<SistemaOperativo>();
        for (int i=1;i<=9;i++) {
            sistemas.add(new SistemaOperativo(i+" Ubuntu 14.04", "2014", R.drawable.tux));
            sistemas.add(new SistemaOperativo(i+" MacOS X Tiger", "2004", R.drawable.apple));
            sistemas.add(new SistemaOperativo(i+" Windows 95", "1995", R.drawable.windows));
            sistemas.add(new SistemaOperativo(i+" Debian", "1993", R.drawable.tux));
            sistemas.add(new SistemaOperativo(i+" Linux Mint 15", "2013", R.drawable.tux));
            sistemas.add(new SistemaOperativo(i+" Windows 10", "2016", R.drawable.windows));
            sistemas.add(new SistemaOperativo(i+" Android", "2006", R.drawable.android));
            sistemas.add(new SistemaOperativo(i+" iOS 8", "2014", R.drawable.apple));
            sistemas.add(new SistemaOperativo(i+" Windows XP", "2001", R.drawable.windows));
            sistemas.add(new SistemaOperativo(i+" Elementary OS", "2014", R.drawable.tux));
            sistemas.add(new SistemaOperativo(i+" MacOS 9", "1999", R.drawable.apple));
            sistemas.add(new SistemaOperativo(i+" Ubuntu 14.04", "2014", R.drawable.tux));
        }
        rv=findViewById(R.id.mrvi);
        LinearLayoutManager ly = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rv.setLayoutManager(ly);
        Adaptador adaptador = new Adaptador(sistemas);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(rv);
        rv.setAdapter(adaptador);
    }
}
