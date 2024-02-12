package com.example.trabajoandroid.View

import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.trabajoandroid.R

class RegistrarseActivity : AppCompatActivity() {
    private lateinit var calendar: CalendarView
    private lateinit var txFecha: TextView
    private lateinit var fechaUsuario: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)
        iniciarVariablesID()
        iniciarVariables()
        establecerEscucha()
    }

    private fun iniciarVariablesID() {
        calendar = findViewById(R.id.caladarRegistro)
        txFecha = findViewById(R.id.textResgistroFecha)
    }

    private fun iniciarVariables() {

    }

    private fun establecerEscucha() {
        calendar.setOnDateChangeListener { cv, year, month, day ->
            txFecha.text = " Fecha seleccionada : $day/$month/$year "
            fechaUsuario = "$day/$month/$year"
        }
    }
}