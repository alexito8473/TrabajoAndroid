package com.example.trabajoandroid.View

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.trabajoandroid.R

class WebActivity : AppCompatActivity() {
    private lateinit var webVisor: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        establecerVariablesID()
    }

    private fun establecerVariablesID() {
        webVisor = findViewById(R.id.webWebVisor)
        webVisor.loadUrl("www.google.es")
    }
}