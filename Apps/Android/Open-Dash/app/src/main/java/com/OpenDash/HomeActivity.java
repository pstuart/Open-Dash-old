package com.OpenDash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        WebView DashWebView = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = DashWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        DashWebView.setWebViewClient(new WebViewClient());


        DashWebView.loadUrl("http://www.open-dash.com");
    }
}
