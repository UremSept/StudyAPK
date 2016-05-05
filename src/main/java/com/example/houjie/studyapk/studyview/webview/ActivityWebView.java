package com.example.houjie.studyapk.studyview.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.houjie.studyapk.R;
//需要网络权限
public class ActivityWebView extends AppCompatActivity {
    private WebView webView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_web_view);
        progressBar = (ProgressBar) findViewById(R.id.webviewprogressBarStyleHorizontal);
        webView = (WebView) findViewById(R.id.btnActivityWebView);
        webView.loadUrl("https://www.baidu.com");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }

        });
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress ==100){
                    progressBar.setVisibility(View.GONE);
                }else {
                    if(progressBar.getVisibility()==View.GONE){
                        progressBar.setVisibility(View.VISIBLE);
                        progressBar.setProgress(newProgress);
                    }
                }
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
