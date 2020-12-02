package com.test.hospital_infantil_app;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class VersionIngles extends Activity {

    static int currentPage = 0;     //Variable estatica necesaria para salvar/guardar paginas como estado
    //static float MinZoom = 0.02f;   //Zoom minimo
    private SharedPreferences settings;

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {      //Carga la ultima pagina vista
        super.onRestoreInstanceState(savedInstanceState);
        currentPage = savedInstanceState.getInt("current2");           //Carga el estado "current2" con la ultima pagina a currentPage
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.settings = getPreferences(MODE_PRIVATE);
        this.currentPage = settings.getInt("current2", currentPage);            //Recupera pagina si se sale
        if(savedInstanceState != null) currentPage = savedInstanceState.getInt("current2"); //recupera pagina si se cambia de orientacion

        setContentView(R.layout.pdf_reader);
        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("Good nutrition for your baby-English version.pdf")
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(true)
                .enableDoubletap(true)
                .defaultPage(currentPage)                       //La pagina inicial sera la ultima leida sin cerrar la aplicacion
                .enableAnnotationRendering(true) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(new DefaultScrollHandle(this, false))
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(10)
                .pageFitPolicy(FitPolicy.WIDTH)
                .load();

        //pdfView.setMinZoom(MinZoom);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {   //Salva la pagina actual
        PDFView pdfView = findViewById(R.id.pdfView);       //Se invocan los datos de pdfView dentro de onCreate()
        currentPage = pdfView.getCurrentPage();             //La variable estatica currentPage es cambiada al numero de pagina actual
        outState.putInt("current2", currentPage);           //Salva un estado para toda la aplicacion como "current2"
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {                                 //Salva la pagina actual si se sale de la lectura sin hacer nada
        super.onPause();
        SharedPreferences.Editor editor = this.settings.edit();
        PDFView pdfView = findViewById(R.id.pdfView);       //Se invocan los datos de pdfView dentro de onCreate()
        currentPage = pdfView.getCurrentPage();             //La variable estatica currentPage es cambiada al numero de pagina actual
        editor.putInt("current2", currentPage);
        editor.commit();                                    //Guarda la pagina en memoria
    }

}