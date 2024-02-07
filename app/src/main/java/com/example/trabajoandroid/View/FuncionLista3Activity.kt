package com.example.trabajoandroid.View

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.ToggleButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.trabajoandroid.Model.Comida
import com.example.trabajoandroid.R
import com.example.trabajoandroid.ViewModel.ComidaAdapterV2
import com.example.trabajoandroid.ViewModel.ListaComida
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FuncionLista3Activity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var adapter: ComidaAdapterV2
    private lateinit var textoTipo: TextView
    private lateinit var proContinuacion: ProgressBar
    private lateinit var butMenu: AppCompatButton
    private var listaTotalComida: MutableList<Comida> = mutableListOf()
    private var listaMostrar: MutableList<Comida> = mutableListOf()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funcion_lista3)
        establecerVariablesID()
        establecerVariables()
        estableverEscucha()
        GlobalScope.launch {
            proguess(proContinuacion)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun establecerVariablesID() {
        listView = findViewById(R.id.listFuncionLista3Mostrar);
        butMenu = findViewById(R.id.butFuncionLista3Volver)
        textoTipo = findViewById(R.id.textFuncionLista3Tipo)
        proContinuacion = findViewById(R.id.proFuncionLista3Barra)
        proContinuacion.progress = 0
        proContinuacion.max = 50
    }

    private fun proguess(pb: ProgressBar?) {
        if (pb != null) {
            while (pb.progress < pb.max) {
                pb.incrementProgressBy(1)
            }
        }
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
            startActivity(Intent(this, MenuActivity::class.java))
        }
        listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, DatoComidaV2Activity::class.java)
            intent.putExtra(getString(R.string.Intent_Comida), listaMostrar[position])
            startActivity(intent)
        }
    }

    fun prueba(view: View) {

        if (!(view as ToggleButton).isChecked) {
            listaMostrar.clear()
            listaMostrar.addAll(listaTotalComida.filter { t -> t.tieneCarne() })
            textoTipo.text = getString(R.string.TogleOn);
        } else {
            listaMostrar.clear()
            listaMostrar.addAll(listaTotalComida.filter { t -> !t.tieneCarne() && !t.isPostre() && !t.isBebida() })
            textoTipo.text = getString(R.string.TogleOf);
        }
        adapter.notifyDataSetChanged()
    }
}