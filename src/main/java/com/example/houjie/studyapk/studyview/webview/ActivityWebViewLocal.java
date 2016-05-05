package com.example.houjie.studyapk.studyview.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.example.houjie.studyapk.R;

public class ActivityWebViewLocal extends AppCompatActivity {
    private Button btnwebviewLocalloading;
    private Button btnwebviewLocaltransferJS;
    private Button btnwebviewLocalwebpage;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_web_view_local);
        btnwebviewLocalloading = (Button) findViewById(R.id.btnwebviewLocalloading);
        btnwebviewLocalloading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("file:///android_asset/index.html");
            }
        });
        btnwebviewLocaltransferJS = (Button) findViewById(R.id.btnwebviewLocaltransferJS);
        btnwebviewLocaltransferJS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("javascript:myAlert()");
            }
        });
        btnwebviewLocalwebpage = (Button) findViewById(R.id.btnwebviewLocalwebpage);
        btnwebviewLocalwebpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        webView = (WebView) findViewById(R.id.webviewLocal);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new MyJS(),"my");
        webView.setWebChromeClient(new WebChromeClient());
    }

    class MyJS{
        @JavascriptInterface
        public void toast(String s){
            Toast.makeText(ActivityWebViewLocal.this, s, Toast.LENGTH_SHORT).show();
        }
    }
}
