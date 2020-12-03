package com.test.hospital_infantil_app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Interfaz extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inter);

        Button b1= findViewById(R.id.cap1);
        Button b2= findViewById(R.id.cap2);
        Button b3= findViewById(R.id.cap3);
        Button b4= findViewById(R.id.cap4);
        Button b5= findViewById(R.id.cap5);
        Button b6= findViewById(R.id.cap6);
        Button b7= findViewById(R.id.cap7);
        Button b8= findViewById(R.id.cap);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor = VersionEspanol.settings.edit();
        Intent intent = new Intent(this , VersionEspanol.class);

        switch (v.getId()) { // Maneja botones de la interfaz

            case R.id.cap:              //Regresa
                startActivity(intent);
                finish();
                break;

            case R.id.cap1:             //Boton cap1 presionado
                editor.putInt("current1", 8 - 1);           //-1 se utiliza por control, las paginas se despliegan desde 0, no desde 1
                editor.apply();                            //Guarda la pagina en memoria
                startActivity(intent);                      //re-abre el lector PDF del libro en español
                finish();                                   //Cierra esta actividad
                break;

            case R.id.cap2:
                editor.putInt("current1", 13 - 1);
                editor.apply();                                    //Guarda la pagina en memoria
                startActivity(intent);
                finish();
                break;

            case R.id.cap3:
                editor.putInt("current1", 22 - 1);
                editor.apply();                                    //Guarda la pagina en memoria
                startActivity(intent);
                finish();
                break;

            case R.id.cap4:
                editor.putInt("current1", 27 - 1);
                editor.apply();                                    //Guarda la pagina en memoria
                startActivity(intent);
                finish();
                break;

            case R.id.cap5:
                editor.putInt("current1", 34 - 1);
                editor.apply();                                    //Guarda la pagina en memoria
                startActivity(intent);
                finish();
                break;

            case R.id.cap6:
                editor.putInt("current1", 52 - 1);
                editor.apply();                                    //Guarda la pagina en memoria
                startActivity(intent);
                finish();
                break;

            case R.id.cap7:
                editor.putInt("current1", 58 - 1);
                editor.apply();                                    //Guarda la pagina en memoria
                startActivity(intent);
                finish();
                break;

            default:
                throw new RuntimeException("Boton desconocido");
        }

    }

}
