package com.test.hospital_infantil_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Information extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacion);
    }

    public void onEnviar(View view){
        Intent intent = new Intent(this, EnviarMensaje.class);
        startActivity(intent);
    }

}
