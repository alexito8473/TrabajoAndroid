package com.example.trabajoandroid.View

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.trabajoandroid.R

class MenuActivity : AppCompatActivity() {
    private lateinit var botonInicioSesion: CardView
    private lateinit var botonFuncionCarta: CardView
    private lateinit var botonFuncionWeb: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        establecerVariablesID()
        establecerEscucha()
    }

    private fun establecerVariablesID() {
        botonInicioSesion = findViewById(R.id.cardMenuInicioSesion)
        botonFuncionWeb = findViewById(R.id.cardMenuWeb)
        botonFuncionCarta = findViewById(R.id.cardMenuCarta)
    }

    private fun establecerEscucha() {
        botonInicioSesion.setOnClickListener {
            startActivity(Intent(this, InicioSesionActivity::class.java))
        }
        botonFuncionWeb.setOnClickListener {
            startActivity(Intent(this, WebActivity::class.java))
        }
        botonFuncionCarta.setOnClickListener {
            startActivity(Intent(this, CartaActivity::class.java))
        }
    }

}