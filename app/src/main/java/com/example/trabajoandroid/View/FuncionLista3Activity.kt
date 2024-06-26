package com.example.trabajoandroid.View

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.trabajoandroid.Model.Comida
import com.example.trabajoandroid.R
import com.example.trabajoandroid.ViewModel.ComidaAdapterV2
import com.example.trabajoandroid.ViewModel.ListaComida
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Thread.sleep

class FuncionLista3Activity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var adapter: ComidaAdapterV2
    private lateinit var textoTipo: TextView
    private lateinit var proContinuacion: ProgressBar
    private lateinit var butMenu: AppCompatButton
    private var listaTotalComida: MutableList<Comida> = mutableListOf()
    private var listaMostrar: MutableList<Comida> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funcion_lista3)
        establecerVariablesID()
        establecerVariables()
        estableverEscucha()

    }

    private fun establecerVariablesID() {
        listView = findViewById(R.id.listFuncionLista3Mostrar);
        butMenu = findViewById(R.id.butFuncionLista3Volver)
        textoTipo = findViewById(R.id.textFuncionLista3Tipo)
        proContinuacion = findViewById(R.id.proFuncionLista3Barra)
        proContinuacion.progress = 0
        proContinuacion.max = 100
    }

    private fun establecerVariables() {
        textoTipo.text = getString(R.string.TogleOn);
        listaTotalComida = ListaComida().crearListaComida(this)
        listaMostrar.addAll(listaTotalComida.filter { t -> t.tieneCarne() })
        adapter = ComidaAdapterV2(this, listaMostrar)
        listView.adapter = adapter;
    }

    private fun estableverEscucha() {
        butMenu.setOnClickListener {
            startActivity(Intent(this, CartaActivity::class.java))
        }
        listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, DatoComidaV2Activity::class.java)
            intent.putExtra(getString(R.string.Intent_Comida), listaMostrar[position])
            startActivity(intent)
        }
    }

    fun prueba(view: View) {
        proContinuacion.progress = 0
        GlobalScope.launch {
            proguess(proContinuacion)
        }
        if (!(view as ToggleButton).isChecked) {
            ObjectAnimator.ofInt(textoTipo,"textColor", ContextCompat.getColor(this,R.color.carne)).apply {
                duration=500
                start()
            }
            listaMostrar.clear()
            listaMostrar.addAll(listaTotalComida.filter { t -> t.tieneCarne() })
            textoTipo.text = getString(R.string.TogleOn);
        } else {
            ObjectAnimator.ofInt(textoTipo,"textColor", ContextCompat.getColor(this,R.color.verdura)).apply {
                duration=500
                start()
            }
            listaMostrar.clear()
            listaMostrar.addAll(listaTotalComida.filter { t -> !t.tieneCarne() && !t.isPostre() && !t.isBebida() })
            textoTipo.text = getString(R.string.TogleOf);
        }
        adapter.notifyDataSetChanged()
    }

    private fun proguess(pb: ProgressBar?) {
        if (pb != null) {
            while (pb.progress < pb.max) {
                pb.incrementProgressBy(5)
                sleep(7);
            }
        }
    }
}