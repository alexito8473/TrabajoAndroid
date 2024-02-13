package com.example.trabajoandroid.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajoandroid.R
import com.example.trabajoandroid.ViewModel.ComidaAdapterV5
import com.example.trabajoandroid.ViewModel.ListaComida


class InicioActivity : AppCompatActivity() {
    private lateinit var recycler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        establecerVariablesID()
        establecerVariables()
        establecerAdaptador()
    }

    private fun establecerVariablesID() {
        recycler= findViewById(R.id.recyclerInicio)
        recycler.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false))
    }

    private fun establecerVariables() {

    }

    private fun establecerAdaptador() {
        recycler.adapter=ComidaAdapterV5(this,ListaComida().crearListaComida(this))
    }

}