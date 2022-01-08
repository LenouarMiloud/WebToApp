package com.fsociety.webtoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val my_url ="https://www.freehali.com/"
        my_webView.loadUrl(my_url)

        val webViewSetting = my_webView.settings
        webViewSetting.javaScriptEnabled = true

        my_webView.webViewClient = WebViewClient()
        my_webView.canGoBack()

        my_webView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if(keyCode == KeyEvent.KEYCODE_BACK && event.action == MotionEvent.ACTION_UP && my_webView.canGoBack() ){
                my_webView.goBack()
                return@OnKeyListener true
            }
            false
        })

    }
}