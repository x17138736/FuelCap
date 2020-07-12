package com.example.fuelcap;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class EVChargePoints extends AppCompatActivity {
    private WebView webView;


    /*private static final String TAG "EVChargePoints";*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_v_charge_points);
        webView = findViewById(R.id.webViewEV);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        //webView.loadUrl("file:///android_asset/index.html");
        webView.loadUrl("https://www.google.ie/maps");

    }
 /*I used Ben O'Brien's video from YouTube to create some of the WebView. I created
 it from his video and added some more to it.*/
    public void onBackPressed() {
        super.onBackPressed();
    }

    /*public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(url.contains("https://www.google.com/maps/@53.3258465,-6.221708,14z")) {
            view.loadUrl(url);
        }
        return true;
    }*/

}
