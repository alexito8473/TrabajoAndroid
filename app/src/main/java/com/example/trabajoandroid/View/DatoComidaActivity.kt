package com.example.trabajoandroid.View

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.trabajoandroid.Model.Comida
import com.example.trabajoandroid.R

class DatoComidaActivity : AppCompatActivity() {
    private lateinit var textTitulo: TextView
    private lateinit var textPrecio: TextView
    private lateinit var butVolver: Button
    private lateinit var textDescripcion: TextView
    private lateinit var imageComida: ImageButton
    private lateinit var comidaContent: Comida
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dato_comida)
        establecerVariablesID();
        establecerVariables()
        sobrecargarDatosLayout()
        establecerEscucha()
    }

    private fun establecerVariablesID() {
        textTitulo = findViewById(R.id.textDatoCoTitulo)
        imageComida = findViewById(R.id.imageButDatoCoPulsar)
        textPrecio = findViewById(R.id.textDatoCoPrecioDato)
        textDescripcion = findViewById(R.id.textDatoCoDescripción)
        butVolver = findViewById(R.id.butDatoCoVolver)
    }

    private fun establecerVariables() {
        comidaContent = intent.getSerializableExtra(getString(R.string.Intent_Comida)) as Comida;
    }

    private fun sobrecargarDatosLayout() {
        textTitulo.text = comidaContent.getNombre()
        imageComida.setImageResource(comidaContent.getImagenComida())
        textPrecio.text = String.format("%.2f€", comidaContent.getPrecio())
        textDescripcion.text = comidaContent.getDescripcion()
    }

    private fun establecerEscucha() {
        imageComida.setOnClickListener {
            textDescripcion.visibility = View.VISIBLE;
        }
        butVolver.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}