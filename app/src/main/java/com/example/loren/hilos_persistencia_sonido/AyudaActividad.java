package com.example.loren.hilos_persistencia_sonido;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AyudaActividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda_actividad);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent volver=new Intent(this,MainActivity.class);
        startActivity(volver);
    }
}
