package com.example.loren.hilos_persistencia_sonido;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;

import com.example.loren.hilos_persistencia_sonido.Partida;

/**
 * Created by loren on 13/01/2018.
 */

public class Gestion extends Activity {

    private Partida partida;
    private int dificultad;
    private int FPS=30;
    private Handler temporizador;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Bundle extras=getIntent().getExtras();

        dificultad=extras.getInt("DIFICULTAD");
        partida=new Partida(getApplicationContext(),dificultad);
        setContentView(partida);

        temporizador=new Handler();

        temporizador.postDelayed(elhilo,2000);


    }

    private Runnable elhilo=new Runnable() {
        @Override
        public void run() {
            if(partida.movimientoBola()) fin();

            else{
                partida.invalidate(); //elimina el contenido de ImageView y llama de nuevo a onDraw()

                temporizador.postDelayed(elhilo,1000/FPS);
            }
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x=(int)event.getX();
        int y=(int)event.getY();

        partida.toque(x,y);

        return false;
    }

    public void fin(){

        temporizador.removeCallbacks(elhilo);
        finish();   //Destruye la actividad actual
    }
}
