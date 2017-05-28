package com.eric.andrew.eric.a081widgets13webview01;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

/**
 * Created by eric on 29/05/2017.
 */

public class AndrewWebView03 extends Activity {
    Button btn1, btn2;
    WebView webView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview03_layout);
        webView = (WebView) findViewById(R.id.webview3);
        webView.getSettings().setJavaScriptEnabled(false);


        webView.setWebChromeClient(new aWebChromeClient());
        webView.setWebViewClient(aWebViewClient);  //网页由内部打开,否则系统自行设置
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.loadUrl("https://www.baidu.com");
        btn1 = (Button) findViewById(R.id.button301);
        btn2 = (Button) findViewById(R.id.button302);

        btn1.setText("刷新");
        btn2.setText(webView.getSettings().getJavaScriptEnabled() ? "JS目前使能" : "JS目前禁用");
        btn1.setOnClickListener(listener1);
        btn2.setOnClickListener(listener2);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    WebViewClient aWebViewClient = new WebViewClient(){
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Toast.makeText(AndrewWebView03.this, "onPageStarted: "+url, Toast.LENGTH_SHORT).show();
            super.onPageStarted(view, url, favicon);
//            System.exit(0);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Toast.makeText(AndrewWebView03.this, "onPageFinished: "+url, Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            Toast.makeText(AndrewWebView03.this,"onReceivedHttpError: " + error.getDescription().toString(),Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);
            Toast.makeText(AndrewWebView03.this,"onReceivedHttpError: " + errorResponse.getData().toString(),Toast.LENGTH_SHORT).show();
        }

    };

    private class aWebChromeClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            progressBar.setProgress(newProgress);

        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            Toast.makeText(AndrewWebView03.this, "onReceivedTitle: " + title, Toast.LENGTH_SHORT).show();

        }

    }





    View.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            webView.loadUrl("www.youku.com");
        }
    };


    View.OnClickListener listener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            boolean enabled = webView.getSettings().getJavaScriptEnabled();
            if (enabled) {
                webView.getSettings().setJavaScriptEnabled(false);
                button.setText("JS目前状态禁用");

            } else {
                webView.getSettings().setJavaScriptEnabled(true);
                button.setText("JS目前状态使能");
            }
        }
    };


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        return super.onKeyDown(keyCode, event);
        if((keyCode == KeyEvent.KEYCODE_BACK)){
            if(webView.canGoBack()){
                webView.goBack();
                return true;
            }else{
                System.exit(0);
            }

        }
        return  false;
    }
}
