package com.example.trabajoandroid.View

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.trabajoandroid.Model.Usuario
import com.example.trabajoandroid.R
import com.example.trabajoandroid.ViewModel.ListaUsuarios
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class InicioSesionActivity : AppCompatActivity() {
    private lateinit var botonGoRegistro: TextView
    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText
    private lateinit var listaUsuarios: MutableList<Usuario>
    private lateinit var botonInicio: Button
    private  var ubicacionSesion:String=""
    private  var controlarSesion:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion)
        estableverVariablesID()
        estableverVariables()
        estableverEscucha()
        leerFichero()
        try {
            if (controlarSesion.toBoolean()) {
                startActivity(Intent(this, InicioActivity::class.java))
            }
        } catch (e: Exception) {
        }
    }

    private fun estableverVariablesID() {
        botonGoRegistro = findViewById(R.id.textInicioRegistrarse)
        botonInicio= findViewById(R.id.butInicioIniciarSesion)
        editEmail=findViewById(R.id.editTextInicioSesionemail)
        editPassword= findViewById(R.id.editTextInicioSesionContraseña)
    }
    private fun estableverVariables() {
        listaUsuarios=ListaUsuarios().listaTotalUsuarios
        ubicacionSesion=getString(R.string.sesion)
    }
    private fun leerFichero() {
        val filePath = File(filesDir, ubicacionSesion)
        try {
            val fileInputStream = FileInputStream(filePath)
            val inputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            controlarSesion = bufferedReader.readLine()
            bufferedReader.close()
            inputStreamReader.close()
            fileInputStream.close()
        } catch (e: Exception) {
        }
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
    private fun estableverEscucha() {
        botonGoRegistro.setOnClickListener {
            startActivity(Intent(this, RegistrarseActivity::class.java))
        }
        botonInicio.setOnClickListener{
            var error=false
            var cadena=""
            if(editEmail.text.isBlank()&&editPassword.text.isBlank()){
                ObjectAnimator.ofInt(botonInicio,"textColor", ContextCompat.getColor(this,R.color.pulsado)).apply {
                    duration=300
                    start()
                }
                if (editEmail.text.toString().isBlank()) {
                    error = true
                    cadena += " Nombre invalido"
                }
                if (editPassword.text.toString().isBlank()) {
                    error = true
                    cadena += " Email invalido"
                }
                if(error){
                    Toast.makeText(this, cadena, Toast.LENGTH_SHORT).show()
                }
            }else{
                escribirFichero()
                startActivity(Intent(this, InicioActivity::class.java))
            }
        }
    }

}