package com.example.trabajoandroid.View

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.GridView
import android.widget.NumberPicker
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.SearchView
import com.example.trabajoandroid.Model.Comida
import com.example.trabajoandroid.R
import com.example.trabajoandroid.ViewModel.ComidaAdapterV3
import com.example.trabajoandroid.ViewModel.ComidaAdapterV4
import com.example.trabajoandroid.ViewModel.ListaComida
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FuncionLIsta5Activity : AppCompatActivity() {
    private lateinit var gridLista: GridView
    private lateinit var adapter: ComidaAdapterV4
    private lateinit var butMenu: AppCompatButton
    private lateinit var picker: NumberPicker
    private var listaTotalComida: MutableList<Comida> = mutableListOf()
    private var listaMostrar: MutableList<Comida> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funcion_lista5)
        establecerVariablesID()
        establecerVariables()
        establecerAdapter()
        estableverEscucha()
    }
    private fun establecerVariablesID() {
        gridLista= findViewById(R.id.gridFuncionLista5Lista)
        picker= findViewById(R.id.numPickerFuncionLista5)
        butMenu= findViewById(R.id.butFuncionLista5Volver)
        picker.wrapSelectorWheel=true;
    }

    private fun establecerVariables() {
        listaTotalComida= ListaComida().crearListaComida(this);
        picker.maxValue=0
        picker.maxValue=listaTotalComida.size
        picker.value=0

    }

    private fun estableverEscucha() {
        picker.setOnValueChangedListener{picker,oldVal,newVal ->
            listaMostrar.clear()
            for(i in 0 until newVal){
                listaMostrar.add(listaTotalComida.get(i))
            }
            adapter.notifyDataSetChanged()
        }
        butMenu.setOnClickListener {  startActivity(Intent(this, MenuActivity::class.java)) }

    }
    private fun establecerAdapter(){
        adapter= ComidaAdapterV4(this,listaMostrar);
        gridLista.adapter=adapter
    }
}