package com.example.trabajoandroid.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.trabajoandroid.R

class CartaActivity : AppCompatActivity() {
    private lateinit var botonFuncionLista1: CardView
    private lateinit var botonFuncionLista2: CardView
    private lateinit var botonFuncionLista3: CardView
    private lateinit var botonFuncionLista4: CardView
    private lateinit var botonFuncionLista5: CardView
    private lateinit var botonFuncionLista6: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carta)
        establecerVariablesID()
        establecerEscucha()
    }
    private fun establecerVariablesID() {
        botonFuncionLista1 = findViewById(R.id.cardMenuFuncionLista)
        botonFuncionLista2 = findViewById(R.id.cardMenuFuncionLista2)
        botonFuncionLista3 = findViewById(R.id.cardMenuFuncionLista3)
        botonFuncionLista4 = findViewById(R.id.cardMenuFuncionLista4)
        botonFuncionLista5 = findViewById(R.id.cardMenuFuncionLista5)
        botonFuncionLista6 = findViewById(R.id.cardMenuFuncionLista6)
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
    }
}