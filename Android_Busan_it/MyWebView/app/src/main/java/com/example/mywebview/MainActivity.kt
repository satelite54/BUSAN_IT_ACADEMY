package com.example.mywebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var edtUrl : EditText
    lateinit var btnGo : Button
    lateinit var btnBack : Button
    lateinit var web : WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.setDisplayShowHomeEnabled(true);
        supportActionBar!!.setIcon(R.drawable.ic_launcher_foreground)

        edtUrl = findViewById<EditText>(R.id.edtUrl)
        btnGo = findViewById(R.id.btnGo)
        btnBack = findViewById(R.id.btnBack)
        web = findViewById(R.id.webView)

        web.webViewClient = CookWebViewClient()

        var webSet = web.settings
        webSet.builtInZoomControls = true

        btnGo.setOnClickListener {
            web.loadUrl(edtUrl.text.toString())
        }

        btnBack.setOnClickListener {
            web.goBack()
        }
    }
}