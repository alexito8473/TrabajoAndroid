package com.example.trabajoandroid.View

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.trabajoandroid.R

class CartaActivity : AppCompatActivity() {
    // Variables que nos índica los botones de la pantalla
    private lateinit var botonFuncionLista1: CardView
    private lateinit var botonFuncionLista2: CardView
    private lateinit var botonFuncionLista3: CardView
    private lateinit var botonFuncionLista4: CardView
    private lateinit var botonFuncionLista5: CardView
    private lateinit var botonFuncionLista6: CardView
    private lateinit var botonFuncionVolverMenu: CardView
    private lateinit var imagenSuperior: ImageView
    private lateinit var textTitulo: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carta)
        establecerVariablesID()
        establecerEscucha()
        establecerAnimaciones()
    }

    private fun establecerVariablesID() {
        botonFuncionLista1 = findViewById(R.id.cardMenuFuncionLista)
        botonFuncionLista2 = findViewById(R.id.cardMenuFuncionLista2)
        botonFuncionLista3 = findViewById(R.id.cardMenuFuncionLista3)
        botonFuncionLista4 = findViewById(R.id.cardMenuFuncionLista4)
        botonFuncionLista5 = findViewById(R.id.cardMenuFuncionLista5)
        botonFuncionLista6 = findViewById(R.id.cardMenuFuncionLista6)
        botonFuncionVolverMenu= findViewById(R.id.cardMenuGoMenu)
        imagenSuperior = findViewById(R.id.imageCarta)
        textTitulo= findViewById(R.id.textCartaTitulo)
    }
    private fun establecerAnimaciones(){
        animarView(botonFuncionLista1, "translationX")
        animarView(botonFuncionLista2, "translationX")
        animarView(botonFuncionLista3, "translationX")
        animarView(botonFuncionLista4, "translationX")
        animarView(botonFuncionLista5, "translationX")
        animarView(botonFuncionLista6, "translationX")
        animarView(botonFuncionVolverMenu, "translationX")
        animarView(imagenSuperior, "translationY")
        animarView(textTitulo, "translationY")
    }
    private fun establecerEscucha() {
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
        botonFuncionLista5.setOnClickListener {
            startActivity(Intent(this, FuncionLIsta5Activity::class.java))
        }
        botonFuncionLista6.setOnClickListener {
            startActivity(Intent(this, FuncionLista6Activity::class.java))
        }
        botonFuncionVolverMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }
    private fun animarView(view: View, tipoTranslacion: String) {
        ObjectAnimator.ofFloat(view, tipoTranslacion, -1200f, view.getWidth().toFloat()).apply {
            duration = 1000
            start()
        }
    }
}