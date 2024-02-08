package com.example.trabajoandroid.View

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatButton
import com.example.trabajoandroid.Model.Comida
import com.example.trabajoandroid.R
import com.example.trabajoandroid.ViewModel.ComidaAdapterV2
import com.example.trabajoandroid.ViewModel.ComidaAdapterV3
import com.example.trabajoandroid.ViewModel.ListaComida

class FuncionLista4Activity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var adapter: ComidaAdapterV3
    private lateinit var butMenu: AppCompatButton
    private var listaTotalComida: MutableList<Comida> = mutableListOf()
    private var listaMostrar: MutableList<Comida> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funcion_lista4)
        establecerVariablesID()
        establecerVariables()
        estableverEscucha()
    }
    private fun establecerVariablesID() {
        listView = findViewById(R.id.listFuncionLista4Mostrar);
        butMenu = findViewById(R.id.butFuncionLista4Volver)
    }

    private fun establecerVariables() {
        listaTotalComida = ListaComida().crearListaComida(this)
        listaMostrar.addAll(listaTotalComida)
        adapter = ComidaAdapterV3(this, listaMostrar)
        listView.adapter = adapter;
    }
    private fun estableverEscucha() {
        butMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }
}