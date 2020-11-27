package com.test.hospital_infantil_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSpanish(View view){
        Intent intent = new Intent(this, VersionEspanol.class);
        startActivity(intent);
    }

    public void onEnglish(View view){
        Intent intent = new Intent(this, VersionIngles.class);
        startActivity(intent);
    }

    public void onInfo(View view) {
        Intent intent = new Intent(this, Information.class);
        startActivity(intent);
    }

}