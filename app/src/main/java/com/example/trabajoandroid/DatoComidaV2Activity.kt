package com.example.trabajoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView

class DatoComidaV2Activity : AppCompatActivity() {
    private lateinit var videoInternet: VideoView
    private lateinit var controlerWeb: MediaController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dato_comida_v2)
        establecerVariablesID()
        establecerVariables()
        establecerVideo()
    }
    private fun establecerVariablesID() {
        videoInternet = findViewById(R.id.viDatoCoV2Internet)
    }
    private fun establecerVariables(){
        controlerWeb= MediaController(this)
    }
    private fun establecerVideo(){

        controlerWeb.setAnchorView(videoInternet)
        videoInternet.setVideoPath("https://media.istockphoto.com/id/1371167585/es/v%C3%ADdeo/sabrosos-cortes-de-carne.mp4?s=mp4-640x640-is&k=20&c=w1yAXqFGfhw6EBtn4Zv1r2WsD5rAomZ5h5pOejjv2eo=")
        videoInternet.setMediaController(controlerWeb)
        videoInternet.start()

    }
}