package com.example.mywebview

import android.webkit.WebView
import android.webkit.WebViewClient

class CookWebViewClient : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        return super.shouldOverrideUrlLoading(view, url)
    }
}