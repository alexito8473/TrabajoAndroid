package com.example.trabajoandroid

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    private lateinit var botBuscador: ImageView
    private lateinit var editBuscador: EditText
    private lateinit var switchCarne: Switch
    private lateinit var listView: ListView
    private lateinit var adapter: ComidaAdapter
    private lateinit var botonDesplazamiento: AppCompatButton
    private var listaTotalComida: MutableList<Comida> = mutableListOf()
    private var listaMostrar: MutableList<Comida> = mutableListOf()
    private var listaReserva: MutableList<Comida> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        establecerVariablesID()
        establecerVariables()
        establecerEscucha();
    }

    private fun establecerVariablesID() {
        editBuscador = findViewById(R.id.editTextMainBuscador)
        botBuscador = findViewById(R.id.butMainBuscador)
        listView = findViewById(R.id.lista);
        switchCarne = findViewById(R.id.switchMainSoloCarne)
        botonDesplazamiento = findViewById(R.id.butMainGoMenu)
    }

    private fun establecerVariables() {
        listaMostrar.addAll(ListaComida().crearListaComida(this))
        listaReserva.addAll(listaMostrar)
        adapter = ComidaAdapter(this, listaMostrar)
        listView.adapter = adapter;
    }

    private fun establecerEscucha() {
        botBuscador.setOnClickListener {
            botonBuscador()
        }
        switchCarne.setOnClickListener {
            switchCarne()
        }
        botonDesplazamiento.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
        }
        listView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, DatoComidaActivity::class.java)
            intent.putExtra(getString(R.string.Intent_Comida), listaMostrar[position])
            startActivity(intent)
        }
    }

    private fun botonBuscador() {
        listaMostrar.clear()
        if (switchCarne.isChecked) {
            if (editBuscador.text.toString().isBlank()) {
                listaMostrar.addAll(listaTotalComida.filter { t -> t.tieneCarne() }.toList())
            } else {
                listaMostrar.addAll(listaReserva.filter { t ->
                    t.getNombre().lowercase().contains(
                        editBuscador.text.toString().lowercase()
                    )
                }.filter { t -> t.tieneCarne() })
            }
        } else {
            if (editBuscador.text.toString().isBlank()) {
                listaMostrar.addAll(listaTotalComida)
            } else {
                listaMostrar.addAll(listaTotalComida.filter { t ->
                    t.getNombre().lowercase().contains(
                        editBuscador.text.toString().lowercase()
                    )
                })
            }
        }
        adapter.notifyDataSetChanged();
    }

    private fun switchCarne() {
        if (switchCarne.isChecked) {
            listaReserva.clear()
            listaReserva.addAll(listaMostrar)
            listaMostrar.clear()
            listaMostrar.addAll(listaReserva.filter { t -> t.tieneCarne() }.toList())
        } else {
            if (editBuscador.text.toString().isBlank()) {
                listaMostrar.clear()
                listaMostrar.addAll(listaTotalComida)
            } else {
                listaMostrar.clear()
                listaMostrar.addAll(listaReserva)
            }
        }
        adapter.notifyDataSetChanged()
    }
}