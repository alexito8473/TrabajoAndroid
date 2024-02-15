package com.example.trabajoandroid.View

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.trabajoandroid.R
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class MenuActivity : AppCompatActivity() {
    private lateinit var botonInicioSesion: CardView
    private lateinit var botonFuncionCarta: CardView
    private lateinit var botonFuncionWeb: CardView
    private lateinit var botonFuncionInicio: CardView
    private lateinit var imagenSuperior: ImageView
    private lateinit var textTitulo: TextView
    private var ubicacionSesion: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        establecerVariablesID()
        establecerVariables()
        establecerEscucha()
        establecerAnimaciones()
    }

    private fun establecerVariablesID() {
        botonInicioSesion = findViewById(R.id.cardMenuInicioSesion)
        botonFuncionWeb = findViewById(R.id.cardMenuWeb)
        botonFuncionCarta = findViewById(R.id.cardMenuCarta)
        botonFuncionInicio = findViewById(R.id.cardMenuInicio)
        imagenSuperior = findViewById(R.id.imageMenuImage)
        textTitulo=findViewById(R.id.textMenuTitulo)
    }

    private fun establecerAnimaciones() {
        animarCardView(botonInicioSesion, "translationX")
        animarCardView(botonFuncionWeb, "translationX")
        animarCardView(botonFuncionCarta, "translationX")
        animarCardView(botonFuncionInicio, "translationX")
        animarCardView(imagenSuperior, "translationY")
        animarCardView(textTitulo, "translationY")
    }

    private fun establecerVariables() {
        ubicacionSesion = getString(R.string.sesion)
    }

    private fun escribirFichero() {
        try {
            val fileOutputStream = FileOutputStream(File(filesDir, ubicacionSesion))
            val outputStreamWriter = OutputStreamWriter(fileOutputStream)
            outputStreamWriter.write("False")
            outputStreamWriter.close()
            fileOutputStream.close()
        } catch (e: Exception) {
        }
    }

    private fun establecerEscucha() {
        botonInicioSesion.setOnClickListener {
            escribirFichero()
            startActivity(Intent(this, InicioSesionActivity::class.java))
        }
        botonFuncionWeb.setOnClickListener {
            startActivity(Intent(this, WebActivity::class.java))
        }
        botonFuncionCarta.setOnClickListener {
            startActivity(Intent(this, CartaActivity::class.java))
        }
        botonFuncionInicio.setOnClickListener {
            startActivity(Intent(this, InicioActivity::class.java))
        }
    }

    private fun animarCardView(view: View, tipoTranslacion: String) {
        ObjectAnimator.ofFloat(view, tipoTranslacion, -1200f, view.getWidth().toFloat()).apply {
            duration = 1000
            start()
        }
    }

}