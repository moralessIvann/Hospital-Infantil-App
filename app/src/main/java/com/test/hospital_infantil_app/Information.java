package com.test.hospital_infantil_app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Information extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacion);
    }

    public void onSendMessage(View view){
        //Filtro para abrir solo aplicaciones de correo \ El destinatario es el cliente
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "comunicacion@hospitalinfantil.org", null));
        String chooserTitle = getString(R.string.chooser);
        Intent choosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(choosenIntent);
    }

}
