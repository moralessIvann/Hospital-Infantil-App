package com.test.hospital_infantil_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fitToWidth(0);
        pdfView.fromAsset("ESV.pdf")
                .pageFitPolicy(FitPolicy.BOTH)
                .enableSwipe(true)
                /*Set swipeH to false if vertical swipe is needed*/
                .swipeHorizontal(true)
                .enableDoubletap(true)
                .defaultPage(0)
                /*.onPageChange((OnPageChangeListener) this)*/
                .enableAnnotationRendering(true)
                /*.onLoad((OnLoadCompleteListener) this)*/
                /*Deja navegar por las paginas*/
                .scrollHandle(new DefaultScrollHandle(this))
                .enableAntialiasing(true)
                .spacing(5)
                .load();
    }
}