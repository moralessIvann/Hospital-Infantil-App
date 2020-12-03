package com.test.hospital_infantil_app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class VersionIngles extends Activity {

    public static int currentPage = 0;     //Variable estatica necesaria para salvar/guardar paginas como estado
    public static SharedPreferences settings;
    //static float MinZoom = 0.02f;   //Zoom minimo


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {      //Carga la ultima pagina vista
        super.onRestoreInstanceState(savedInstanceState);
        currentPage = savedInstanceState.getInt("current2");           //Carga el estado "current1" con la ultima pagina a currentPage
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.settings = getPreferences(MODE_PRIVATE);
        this.currentPage = settings.getInt("current2", currentPage);            //Recupera pagina si se sale

        setContentView(R.layout.pdf_reader_e);
        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("Good nutrition for your baby-English version.pdf")
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(true)
                .enableDoubletap(true)
                .defaultPage(currentPage)                       //La pagina inicial sera la ultima leida sin cerrar la aplicacion
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(new DefaultScrollHandle(this, false))
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(10)
                .fitEachPage(true)
                .pageSnap(true)
                .pageFling(true)
                .nightMode(false)
                //.pageFitPolicy(FitPolicy.WIDTH)
                .load();

        //pdfView.setMinZoom(MinZoom);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {   //Salva la pagina actual en caso de cambiar de orientacion
        super.onSaveInstanceState(outState);
        PDFView pdfView = findViewById(R.id.pdfView);       //Se invocan los datos de pdfView dentro de onCreate()
        currentPage = pdfView.getCurrentPage();             //La variable estatica currentPage es cambiada al numero de pagina actual
        outState.putInt("current2", currentPage);           //Salva un estado para toda la aplicacion como "current1"
    }

    @Override
    public void onPause() {                                 //Salva la pagina actual si se sale de la lectura sin hacer nada
        super.onPause();
        SharedPreferences.Editor editor = this.settings.edit();
        PDFView pdfView = findViewById(R.id.pdfView);       //Se invocan los datos de pdfView dentro de onCreate()
        currentPage = pdfView.getCurrentPage();             //La variable estatica currentPage es cambiada al numero de pagina actual
        editor.putInt("current2", currentPage);
        editor.apply();                                    //Guarda la pagina en memoria
    }

    public void onInter(View view) {
        Intent intent = new Intent(this , Dashboard.class);
        startActivity(intent);
        finish();
    }

}