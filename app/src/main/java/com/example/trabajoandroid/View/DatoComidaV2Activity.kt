package com.example.trabajoandroid.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.trabajoandroid.Model.Comida
import com.example.trabajoandroid.R
import com.google.android.material.imageview.ShapeableImageView

class DatoComidaV2Activity : AppCompatActivity() {
    private lateinit var videoInternet: VideoView
    private lateinit var controlerWeb: MediaController
    private lateinit var imagenComida: ShapeableImageView
    private lateinit var comidaContent: Comida
    private lateinit var butVolver: Button
    private lateinit var textTitulo: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dato_comida_v2)
        establecerVariablesID()
        establecerVariables()
        establecerVideo()
        establecerEscucha()
    }

    private fun establecerVariablesID() {
        videoInternet = findViewById(R.id.viDatoCoV2Internet)
        imagenComida = findViewById(R.id.imageButDatoV2CoPulsar)
        butVolver = findViewById(R.id.butDatoCoV2Volver)
        textTitulo = findViewById(R.id.textDatoCoV2Titulo)
    }

    private fun establecerVariables() {
        comidaContent = intent.getSerializableExtra(getString(R.string.Intent_Comida)) as Comida;
        controlerWeb = MediaController(this)
        textTitulo.text = comidaContent.getNombre()
        imagenComida.setImageResource(comidaContent.getImagenComida())
    }

    private fun establecerVideo() {
        controlerWeb.setAnchorView(videoInternet)
        videoInternet.setVideoPath(comidaContent.getVideoPath())
        videoInternet.setMediaController(controlerWeb)
        videoInternet.start()
    }

    private fun establecerEscucha() {
        butVolver.setOnClickListener {
            startActivity(Intent(this, FuncionLista3Activity::class.java))
        }
    }

}