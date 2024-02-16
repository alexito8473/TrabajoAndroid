package com.example.trabajoandroid.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trabajoandroid.R
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class RegistrarseActivity : AppCompatActivity() {
    private lateinit var calendar: CalendarView
    private lateinit var txFecha: TextView
    private lateinit var fechaUsuario: String
    private lateinit var botonVolver: ImageButton
    private lateinit var editNombre: EditText
    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText
    private lateinit var calendarFecha: CalendarView
    private lateinit var isMayor: CheckBox
    private lateinit var butRegistrarse: Button
    private var ubicacionSesion: String=""
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
        botonVolver = findViewById(R.id.imagenRegistraseVolver)
        editNombre = findViewById(R.id.edTextResgistroUsuario)
        editEmail = findViewById(R.id.edTextResgistroUsuario)
        editPassword = findViewById(R.id.edTextResgistroUsuario)
        calendarFecha = findViewById(R.id.caladarRegistro)
        isMayor = findViewById(R.id.chBxResgistroEsMayor)
        butRegistrarse = findViewById(R.id.buttonRegistro)
    }

    private fun iniciarVariables() {
        fechaUsuario=""
        ubicacionSesion=getString(R.string.sesion)
    }

    private fun escribirFichero() {
        try {
            val filePath = File(filesDir, ubicacionSesion);
            val fileOutputStream = FileOutputStream(filePath)
            val outputStreamWriter = OutputStreamWriter(fileOutputStream)
            outputStreamWriter.write("True")
            outputStreamWriter.close()
            fileOutputStream.close()
        } catch (e: Exception) {
        }
    }
    private fun establecerEscucha() {
        calendar.setOnDateChangeListener { cv, year, month, day ->
            txFecha.text = " Fecha seleccionada : $day/$month/$year "
            fechaUsuario = "$day/$month/$year"
        }
        botonVolver.setOnClickListener {
            startActivity(Intent(this, InicioSesionActivity::class.java))
        }
        butRegistrarse.setOnClickListener {
            var cadena = ""
            var error = false
            if (editNombre.text.toString().isBlank()) {
                error = true
                cadena += " Nombre invalido"
                editNombre.error

            }
            if (editEmail.text.toString().isBlank()) {
                error = true
                cadena += " Email invalido"
            }
            if (editPassword.text.toString().isBlank()) {
                error = true
                cadena += " Password invalido"
            }
            if (fechaUsuario.isBlank()) {
                error = true
                cadena += " Introduce una fecha"
            }
            if (!isMayor.isChecked) {
                error = true
                cadena += " Debe ser mayor de edad"
            }
            if (error) {
                Toast.makeText(this, cadena, Toast.LENGTH_SHORT).show()
            } else {
                escribirFichero()
                startActivity(Intent(this, InicioActivity::class.java))
            }
        }
    }
}