package com.example.trabajoandroid.View

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.trabajoandroid.Model.Comida
import com.example.trabajoandroid.R
import com.example.trabajoandroid.ViewModel.ComidaAdapter
import com.example.trabajoandroid.ViewModel.ListaComida
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class FuncionLista2Activity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var adapter: ComidaAdapter
    private lateinit var chipCarne: Chip
    private lateinit var chipVerdura: Chip
    private lateinit var chipPostre: Chip
    private lateinit var chipBebida: Chip
    private lateinit var butMenu: AppCompatButton
    private lateinit var contenedorChipGroup: ChipGroup
    private lateinit var radioTotal: RadioButton
    private lateinit var radioMenos: RadioButton
    private lateinit var radioMas: RadioButton
    private lateinit var radioDesconocido: RadioButton
    private var listaTotalComida: MutableList<Comida> = mutableListOf()
    private var listaMostrar: MutableList<Comida> = mutableListOf()
    private var listaReserva: MutableList<Comida> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funcion_lista2)
        establecerVariablesID()
        establecerVariables()
        establecerEscucha()
    }

    private fun establecerVariablesID() {
        listView = findViewById(R.id.listFuncionLista2Mostrar);
        contenedorChipGroup = findViewById(R.id.cgFuncionLista2Controlador)
        chipCarne = findViewById(R.id.chipFuncionLista2Carne)
        chipVerdura = findViewById(R.id.chipFuncionLista2Verdura)
        chipPostre = findViewById(R.id.chipFuncionLista2Postre)
        chipBebida = findViewById(R.id.chipFuncionLista2Bebida)
        radioTotal = findViewById(R.id.radFuncionLista2Total)
        radioMenos = findViewById(R.id.radFuncionLista2Menos)
        radioMas = findViewById(R.id.radFuncionLista2Mas)
        butMenu = findViewById(R.id.butFuncionLista2Volver)
    }

    private fun establecerVariables() {
        radioDesconocido = radioTotal
        listaTotalComida = ListaComida().crearListaComida(this)
        adapter = ComidaAdapter(this, listaMostrar)
        listView.adapter = adapter;
    }

    fun onPrecio(view: View) {
        when (view.id) {
            R.id.radFuncionLista2Total -> {
                listaMostrar.clear()
                listaMostrar.addAll(listaReserva)
                adapter.notifyDataSetChanged()
                radioDesconocido = view as RadioButton
            }

            R.id.radFuncionLista2Menos -> {
                listaMostrar.clear()
                listaMostrar.addAll(listaReserva.filter { t -> t.getPrecio() < 20 })
                adapter.notifyDataSetChanged()
                radioDesconocido = view as RadioButton
            }

            R.id.radFuncionLista2Mas -> {
                listaMostrar.clear()
                listaMostrar.addAll(listaReserva.filter { t -> t.getPrecio() >= 20 })
                adapter.notifyDataSetChanged()
                radioDesconocido = view as RadioButton
            }
        }
    }

    private fun establecerEscucha() {
        chipCarne.setOnClickListener {
            if (chipCarne.isChecked) {
                listaMostrar.addAll(listaTotalComida.filter { t -> t.tieneCarne() })
                listaReserva.addAll(listaMostrar)
            } else {
                listaReserva.removeAll { t -> t.tieneCarne() }
                listaMostrar.removeAll { t -> t.tieneCarne() }
            }
            onPrecio(radioDesconocido)
            adapter.notifyDataSetChanged()
        }
        chipVerdura.setOnClickListener {
            if (chipVerdura.isChecked) {
                listaReserva.addAll(listaTotalComida.filter { t -> !t.tieneCarne() && !t.isPostre() && !t.isBebida() })
                listaMostrar.addAll(listaReserva)
            } else {
                listaMostrar.removeAll { t -> !t.tieneCarne() && !t.isPostre() && !t.isBebida() }
                listaReserva.removeAll { t -> !t.tieneCarne() && !t.isPostre() && !t.isBebida() }
            }
            onPrecio(radioDesconocido)
            adapter.notifyDataSetChanged()
        }
        chipPostre.setOnClickListener {
            if (chipPostre.isChecked) {
                listaReserva.addAll(listaTotalComida.filter { t -> t.isPostre() })
                listaMostrar.addAll(listaReserva)
            } else {
                listaMostrar.removeAll { t -> t.isPostre() }
                listaReserva.removeAll { t -> t.isPostre() }
            }
            onPrecio(radioDesconocido)
            adapter.notifyDataSetChanged()
        }
        chipBebida.setOnClickListener {
            if (chipBebida.isChecked) {
                listaReserva.addAll(listaTotalComida.filter { t -> t.isBebida() })
                listaMostrar.addAll(listaReserva)
            } else {
                listaMostrar.removeAll { t -> t.isBebida() }
                listaReserva.removeAll { t -> t.isBebida() }
            }
            onPrecio(radioDesconocido)
            adapter.notifyDataSetChanged()
        }
        butMenu.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
    }


}