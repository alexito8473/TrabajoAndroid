package com.example.trabajoandroid.View

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.trabajoandroid.R

class MenuActivity : AppCompatActivity() {
    private lateinit var botonInicioSesion: CardView
    private lateinit var botonFuncionLista1: CardView
    private lateinit var botonFuncionLista2: CardView
    private lateinit var botonFuncionLista3: CardView
    private lateinit var botonFuncionLista4: CardView
    private lateinit var botonFuncionWeb: CardView
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
        botonFuncionLista4 = findViewById(R.id.cardMenuFuncionLista4)
        botonFuncionWeb= findViewById(R.id.cardMenuWeb)
    }

    private fun establecerEscucha() {
        botonInicioSesion.setOnClickListener {
            startActivity(Intent(this, InicioSesionActivity::class.java))
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
        botonFuncionLista4.setOnClickListener {
            startActivity(Intent(this, FuncionLista4Activity::class.java))
        }
        botonFuncionWeb.setOnClickListener {
            startActivity(Intent(this, WebActivity::class.java))
        }
    }

}