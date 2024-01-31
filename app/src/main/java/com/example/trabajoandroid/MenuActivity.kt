package com.example.trabajoandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MenuActivity : AppCompatActivity() {
    private lateinit var botonInicioSesion: CardView
    private lateinit var botonFuncionLista1: CardView
    private lateinit var botonFuncionLista2: CardView
    private lateinit var botonFuncionLista3: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        establecerVariablesID()
        establecerEscucha()
    }

    private fun establecerVariablesID() {
        botonInicioSesion = findViewById(R.id.cardMenuInicioSesion)
        botonFuncionLista1 = findViewById(R.id.cardMenuFuncionLista)
        botonFuncionLista2 = findViewById(R.id.cardMenuFuncionLista2)
        botonFuncionLista3 = findViewById(R.id.cardMenuFuncionLista3)
    }

    private fun establecerEscucha() {
        botonInicioSesion.setOnClickListener {
        }
        botonFuncionLista1.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        botonFuncionLista2.setOnClickListener {
            startActivity(Intent(this, FuncionLista2Activity::class.java))
        }
        botonFuncionLista3.setOnClickListener {
            startActivity(Intent(this, FuncionLista3Activity::class.java))
        }
    }

}