package com.example.trabajoandroid

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class FuncionLista2Activity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var adapter: ComidaAdapter
    private lateinit var chipCarne: Chip
    private lateinit var chipVerdura: Chip
    private lateinit var chipPostre: Chip
    private lateinit var chipBebida: Chip
    private lateinit var contenedorChipGroup: ChipGroup
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
    }

    private fun establecerEscucha() {
        chipCarne.setOnClickListener {
            if (chipCarne.isChecked) {
                listaMostrar.addAll(listaReserva.filter { t -> t.tieneCarne() })
            } else {
                listaMostrar.removeAll { t -> t.tieneCarne() }
            }
            adapter.notifyDataSetChanged()
        }
        chipVerdura.setOnClickListener {
            if (chipVerdura.isChecked) {
                listaMostrar.addAll(listaReserva.filter { t -> !t.tieneCarne() && !t.isPostre() && !t.isBebida() })
            } else {
                listaMostrar.removeAll { t -> !t.tieneCarne() && !t.isPostre() && !t.isBebida() }
            }
            adapter.notifyDataSetChanged()
        }
        chipPostre.setOnClickListener {
            if (chipPostre.isChecked) {
                listaMostrar.addAll(listaReserva.filter { t -> t.isPostre() })
            } else {
                listaMostrar.removeAll { t -> t.isPostre() }
            }
            adapter.notifyDataSetChanged()
        }
        chipBebida.setOnClickListener {
            if (chipBebida.isChecked) {
                listaMostrar.addAll(listaReserva.filter { t -> t.isBebida() })
            } else {
                listaMostrar.removeAll { t -> t.isBebida() }
            }
            adapter.notifyDataSetChanged()
        }
    }

    private fun establecerVariables() {
        listaTotalComida= ListaComida().crearListaComida(this)
        listaReserva.addAll(listaTotalComida)
        adapter = ComidaAdapter(this, listaMostrar)
        listView.adapter = adapter;
    }

}