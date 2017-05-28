package com.eric.andrew.eric.a081widgets13webview01;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by eric on 29/05/2017.
 */

public class AndrewWebView02 extends Activity {
    Button btn1, btn2;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview02_layout);
        webView = (WebView) findViewById(R.id.webview2);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.baidu.com");
//        webView.setWebViewClient(new WebViewClient());
        webView.setWebViewClient(new AndrewWebViewClient());
    }

    private class AndrewWebViewClient extends WebViewClient{

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Toast.makeText(AndrewWebView02.this, "正在打开" + url, Toast.LENGTH_SHORT).show();
            super.onPageStarted(view, url, favicon);
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
                finish();
            }

        }
        return  false;
    }
}
