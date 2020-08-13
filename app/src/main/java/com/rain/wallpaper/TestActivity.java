package com.rain.wallpaper;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: TestActivity
 * @CreateDate: 2020/8/1 14:51
 * @Describe:
 */
public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_webview);
//
//        WebView webView = findViewById(R.id.webView);
//        webView.loadUrl("file:///assets/webview.html");
//        webView.getSettings().setJavaScriptEnabled(true);
    }
}
