package com.example.trabajoandroid.View

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.trabajoandroid.R

class InicioSesionActivity : AppCompatActivity() {
    private lateinit var botonConfiguracion: ImageButton
    private lateinit var botonGoRegistro: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion)
        estableverVariablesID()
        estableverEscucha()
    }

    private fun estableverVariablesID() {
        botonConfiguracion = findViewById(R.id.imageInicioControl)
        botonGoRegistro = findViewById(R.id.textInicioRegistrarse)
    }

    private fun estableverEscucha() {
        botonGoRegistro.setOnClickListener {
            startActivity(Intent(this, RegistrarseActivity::class.java))
        }
    }

}