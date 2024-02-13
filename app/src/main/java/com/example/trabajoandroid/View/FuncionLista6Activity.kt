package com.example.trabajoandroid.View

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ListView
import android.widget.MultiAutoCompleteTextView
import android.widget.ProgressBar
import android.widget.SeekBar
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import com.example.trabajoandroid.Model.Comida
import com.example.trabajoandroid.R
import com.example.trabajoandroid.ViewModel.ComidaAdapterV3
import com.example.trabajoandroid.ViewModel.ListaComida
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class FuncionLista6Activity : AppCompatActivity() {
    private lateinit var buscadorAuto: MultiAutoCompleteTextView
    private lateinit var pulsadorFloat:FloatingActionButton
    private lateinit var adapter: ComidaAdapterV3
    private lateinit var butMenu: AppCompatButton
    private lateinit var listView: ListView
    private lateinit var comidas_array:Array<String>
    private lateinit var adpatorComidasSee:ArrayAdapter<String>
    private var listaTotalComida: MutableList<Comida> = mutableListOf()
    private var listaMostrar: MutableList<Comida> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funcion_lista6)
        establecerVariablesID()
        establecerVariables()
        estableverEscucha()
    }
    private fun establecerVariablesID() {
        listView = findViewById(R.id.listFuncionLista6Mostrar)
        butMenu = findViewById(R.id.butFuncionLista6Volver)
        pulsadorFloat= findViewById(R.id.floButFuncionLista6)
        buscadorAuto=findViewById(R.id.editTextFuncionLista6Buscador)
    }

    private fun establecerVariables() {
        listaTotalComida = ListaComida().crearListaComida(this)
        listaMostrar.addAll(listaTotalComida)
        adapter = ComidaAdapterV3(this, listaMostrar)
        listView.adapter = adapter;
        comidas_array=resources.getStringArray(R.array.valores_comida)
        adpatorComidasSee= ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,comidas_array)
        buscadorAuto.setAdapter(adpatorComidasSee)
        buscadorAuto.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
    }

    private fun estableverEscucha() {
        butMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
        pulsadorFloat.setOnClickListener{
            if(buscadorAuto.text.isNotEmpty()){
                var valores=buscadorAuto.text.split(",")
                if(valores.isEmpty()){
                    listaMostrar.clear()
                    listaMostrar.addAll(listaTotalComida.filter { t -> t.getNombre().equals(buscadorAuto.text)});
                }else{
                    listaMostrar.clear()
                    listaMostrar.addAll(listaTotalComida.filter { t -> valores.any { g -> t.getNombre().equals(g.trim()) }});
                }
            }else{
                listaMostrar.clear()
                listaMostrar.addAll(listaTotalComida)
            }
            adapter.notifyDataSetChanged()
        }
    }
}