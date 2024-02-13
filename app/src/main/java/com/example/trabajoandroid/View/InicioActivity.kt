package com.example.trabajoandroid.View

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajoandroid.R
import com.example.trabajoandroid.ViewModel.ComidaAdapterV5
import com.example.trabajoandroid.ViewModel.ListaComida


class InicioActivity : AppCompatActivity() {
    private lateinit var recycler: RecyclerView
    private lateinit var butMenu: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        establecerVariablesID()
        establecerAdaptador()
        establecerEscucha()
    }

    private fun establecerVariablesID() {
        recycler= findViewById(R.id.recyclerInicio)
        butMenu = findViewById(R.id.butFuncionInicioVolver)
        recycler.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false))
    }

    private fun establecerEscucha() {
        butMenu.setOnClickListener{
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }

    private fun establecerAdaptador() {
        recycler.adapter=ComidaAdapterV5(this,ListaComida().crearListaComida(this))
    }

}