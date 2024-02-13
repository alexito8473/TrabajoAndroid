package com.example.trabajoandroid.View

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import com.example.trabajoandroid.Model.Comida
import com.example.trabajoandroid.R
import com.example.trabajoandroid.ViewModel.ComidaAdapterV3
import com.example.trabajoandroid.ViewModel.ListaComida
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FuncionLista4Activity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var adapter: ComidaAdapterV3
    private lateinit var butMenu: AppCompatButton
    private lateinit var seekControl: SeekBar
    private lateinit var searchControl: SearchView
    private lateinit var progescontrolador: ProgressBar
    private lateinit var textTodo: TextView
    private lateinit var textCarne: TextView
    private lateinit var textVerdura: TextView
    private lateinit var textPostre: TextView

    private var filtradoText: String = ""
    private var seekControlPosicion: Int = 0
    private var listaTotalComida: MutableList<Comida> = mutableListOf()
    private var listaReserva: MutableList<Comida> = mutableListOf()
    private var listaMostrar: MutableList<Comida> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funcion_lista4)
        establecerVariablesID()
        establecerVariables()
        estableverEscucha()
    }

    private fun establecerVariablesID() {
        listView = findViewById(R.id.listFuncionLista4Mostrar)
        butMenu = findViewById(R.id.butFuncionLista4Volver)
        seekControl = findViewById(R.id.seekBarFuncionLista4Control)
        searchControl = findViewById(R.id.searchFuncionLista4Controlar)
        progescontrolador = findViewById(R.id.proBarFuncionLista4)
        textTodo = findViewById(R.id.textFuncionLista4Todo)
        textCarne = findViewById(R.id.textFuncionLista4Carne)
        textVerdura = findViewById(R.id.textFuncionLista4Verdura)
        textPostre = findViewById(R.id.textFuncionLista4Postre)

        GlobalScope.launch {
            Thread.sleep(850)
            progescontrolador.visibility = View.INVISIBLE;
        }
    }

    private fun establecerVariables() {
        listaTotalComida = ListaComida().crearListaComida(this)
        listaReserva.addAll(listaTotalComida)
        listaMostrar.addAll(listaTotalComida)
        adapter = ComidaAdapterV3(this, listaMostrar)
        listView.adapter = adapter;
    }

    private fun estableverEscucha() {
        butMenu.setOnClickListener {
            startActivity(Intent(this, CartaActivity::class.java))
        }
        seekControl.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                controlarSeek(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        searchControl.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    listaMostrar.clear()
                    listaMostrar.addAll(listaReserva.filter { t ->
                        t.getNombre().lowercase().contains(newText.lowercase())
                    })
                    adapter.notifyDataSetChanged()
                    filtradoText = newText
                } else {
                    filtradoText = "newTex"
                }
                return false
            }
        })
    }

    private fun controlarSeek(posicion: Int) {
        listaMostrar.clear()
        listaReserva.clear()
        val duracion = 250L
        val propiedad = "textColor"
        when (posicion) {
            0 -> {
                resetTodosColoresTexto()
                ObjectAnimator.ofInt(
                    textTodo,
                    propiedad,
                    ContextCompat.getColor(this, R.color.fondo_oscuro)
                ).apply {
                    duration = duracion
                    start()
                }
                listaReserva.addAll(listaTotalComida)
                listaMostrar.addAll(listaReserva.filter { t ->
                    t.getNombre().lowercase().contains(filtradoText.lowercase())
                })
            }

            1 -> {
                resetTodosColoresTexto()
                ObjectAnimator.ofInt(
                    textCarne,
                    propiedad,
                    ContextCompat.getColor(this, R.color.fondo_oscuro)
                ).apply {
                    duration = duracion
                    start()
                }
                listaReserva.addAll(listaTotalComida.filter { t -> t.tieneCarne() })
                listaMostrar.addAll(listaReserva.filter { t ->
                    t.getNombre().lowercase().contains(filtradoText.lowercase())
                })
            }

            2 -> {
                resetTodosColoresTexto()
                ObjectAnimator.ofInt(
                    textVerdura,
                    propiedad,
                    ContextCompat.getColor(this, R.color.fondo_oscuro)
                ).apply {
                    duration = duracion
                    start()
                }
                listaReserva.addAll(listaTotalComida.filter { t -> !t.tieneCarne() && !t.isPostre() && !t.isBebida() })
                listaMostrar.addAll(listaReserva.filter { t ->
                    t.getNombre().lowercase().contains(filtradoText.lowercase())
                })
            }

            3 -> {
                resetTodosColoresTexto()
                ObjectAnimator.ofInt(
                    textPostre,
                    propiedad,
                    ContextCompat.getColor(this, R.color.fondo_oscuro)
                ).apply {
                    duration = duracion
                    start()
                }
                listaReserva.addAll(listaTotalComida.filter { t -> t.isPostre() })
                listaMostrar.addAll(listaReserva.filter { t ->
                    t.getNombre().lowercase().contains(filtradoText.lowercase())
                })
            }
        }
        seekControlPosicion = posicion
        adapter.notifyDataSetChanged()
    }

    private fun resetTodosColoresTexto() {
        textTodo.setTextColor(ContextCompat.getColor(this, R.color.black))
        textVerdura.setTextColor(ContextCompat.getColor(this, R.color.black))
        textCarne.setTextColor(ContextCompat.getColor(this, R.color.black))
        textPostre.setTextColor(ContextCompat.getColor(this, R.color.black))
    }
}