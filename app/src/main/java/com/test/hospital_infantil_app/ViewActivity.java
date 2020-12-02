package com.test.hospital_v110;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class ViewActivity extends AppCompatActivity {

    PDFView pdfView1,pdfView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        pdfView1 = (PDFView) findViewById(R.id.pdf_viewer);
        pdfView2 = (PDFView) findViewById(R.id.pdf_viewer);

        if(getIntent() != null) {
            String viewType = getIntent().getStringExtra("ViewType");
            if (viewType.equals("book1")) {//!= null || !TextUtils.isEmpty(viewType)){
                pdfView1.fromAsset("hideandseek.pdf")
                        //.pages(0,1,2,3,4) // all pages are displayed by default
                        .enableSwipe(true) // allows to block changing pages using swipe
                        .swipeHorizontal(true)
                        .enableDoubletap(true)
                        .defaultPage(0)

/*              .onDraw(onDrawListener)// allows to draw something on the current page, usually visible in the middle of the screen
                .onDrawAll(onDrawListener)// allows to draw something on all pages, separately for every page. Called only for visible pages
                .onLoad(onLoadCompleteListener) // called after document is loaded and starts to be rendered
                .onPageChange(onPageChangeListener)
                .onPageScroll(onPageScrollListener)
                .onError(onErrorListener)
                .onPageError(onPageErrorListener)
                .onRender(onRenderListener) // called after document is rendered for the first time
                .onTap(onTapListener)// called on single tap, return true if handled, false to toggle scroll handle visibility
                .onLongPress(onLongPressListener)
*/
                        .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                        .password(null)
                        .scrollHandle(null)
                        .scrollHandle(new DefaultScrollHandle(this)) //button pages
                        .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                        .spacing(5)// spacing between pages in dp. To define spacing color, set view background
                        .autoSpacing(true) // add dynamic spacing to fit each page on its own on the screen
                        //.linkHandler(DefaultLinkHandler)
                        //.pageFitPolicy(FitPolicy.WIDTH) // mode to fit pages in the view
                        .fitEachPage(true) // fit each page to the view, else smaller pages are scaled relative to largest page.
                        .pageSnap(true) // snap pages to screen boundaries
                        .pageFling(true) // make a fling change only a single page like ViewPager
                        .nightMode(false) // toggle night mode
                        .load();
            } else {
                pdfView2.fromAsset("adogonalog.pdf")
                        //.pages(0,1,2,3,4) // all pages are displayed by default
                        .enableSwipe(true) // allows to block changing pages using swipe
                        .swipeHorizontal(false)
                        .enableDoubletap(true)
                        .defaultPage(0)
/*
                .onDraw(onDrawListener)// allows to draw something on the current page, usually visible in the middle of the screen
                .onDrawAll(onDrawListener)// allows to draw something on all pages, separately for every page. Called only for visible pages
                .onLoad(onLoadCompleteListener) // called after document is loaded and starts to be rendered
                .onPageChange(onPageChangeListener)
                .onPageScroll(onPageScrollListener)
                .onError(onErrorListener)
                .onPageError(onPageErrorListener)
                .onRender(onRenderListener) // called after document is rendered for the first time
                .onTap(onTapListener)// called on single tap, return true if handled, false to toggle scroll handle visibility
                .onLongPress(onLongPressListener)
*/
                        .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                        .password(null)
                        .scrollHandle(null)
                        .scrollHandle(new DefaultScrollHandle(this)) //button pages
                        .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                        .spacing(5)// spacing between pages in dp. To define spacing color, set view background
                        .autoSpacing(true) // add dynamic spacing to fit each page on its own on the screen
                        //.linkHandler(DefaultLinkHandler)
                        //.pageFitPolicy(FitPolicy.WIDTH) // mode to fit pages in the view
                        .fitEachPage(true) // fit each page to the view, else smaller pages are scaled relative to largest page.
                        .pageSnap(true) // snap pages to screen boundaries
                        .pageFling(true) // make a fling change only a single page like ViewPager
                        .nightMode(false) // toggle night mode
                        .load();

            }
        }
    }
}
