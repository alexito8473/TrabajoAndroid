package com.example.trabajoandroid.View

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.trabajoandroid.ViewModel.ComidaAdapterV2
import com.example.trabajoandroid.ViewModel.ListaComida
import com.example.trabajoandroid.Model.Comida
import com.example.trabajoandroid.R

class FuncionLista3Activity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var adapter: ComidaAdapterV2
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
    }

    private fun establecerVariables() {
        listaTotalComida = ListaComida().crearListaComida(this)
        listaMostrar.addAll(listaTotalComida.filter { t -> t.tieneCarne() })
        adapter = ComidaAdapterV2(this, listaMostrar)
        listView.adapter = adapter;
    }

    private fun estableverEscucha(){
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
        } else {
            listaMostrar.clear()
            listaMostrar.addAll(listaTotalComida.filter { t -> !t.tieneCarne() && !t.isPostre() && !t.isBebida() })
        }
        adapter.notifyDataSetChanged()
    }
}