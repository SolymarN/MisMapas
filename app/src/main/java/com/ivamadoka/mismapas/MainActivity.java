package com.ivamadoka.mismapas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton ciclovia;
    private ImageButton canchadeportiva;
    private ImageButton deporteacuatico;
    private ImageButton parquesummit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ciclovia = findViewById(R.id.ibtnciclovia);
        canchadeportiva = findViewById(R.id.ibtncanchadeportiva);
        deporteacuatico = findViewById(R.id.ibtndeportesacuaticos);
        parquesummit = findViewById(R.id.ibtnparquesummit);

        ciclovia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mexico
                irMapa(view,19.392772523819044,-99.13804210676275);

            }
        });

        canchadeportiva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Panama
                irMapa(view,9.04435621154599,-79.45394882015486);
            }
        });

        deporteacuatico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Venezuela
                irMapa(view,7.958710639739595,-66.15132296927143);
            }
        });

        parquesummit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Argentina
                irMapa(view,-35.06971980099553,-65.29366927177388);
            }
        });
    }

    public void irMapa(View v, Double latitud, Double longitud){
        Intent intent = new Intent(this,MapsActivity.class);
        intent.putExtra(getResources().getString(R.string.latitud),latitud);
        intent.putExtra(getResources().getString(R.string.longitud),longitud);
        startActivity(intent);

    }
}