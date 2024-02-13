package com.example.trabajoandroid.View

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.ListView
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.trabajoandroid.Model.Comida
import com.example.trabajoandroid.R
import com.example.trabajoandroid.ViewModel.ComidaAdapter
import com.example.trabajoandroid.ViewModel.ListaComida

class MainActivity : AppCompatActivity() {
    private lateinit var botBuscador: ImageView
    private lateinit var autoCompleteBuscador: AutoCompleteTextView
    private lateinit var switchCarne: Switch
    private lateinit var listView: ListView
    private lateinit var adapter: ComidaAdapter
    private lateinit var botonDesplazamiento: AppCompatButton
    private lateinit var comidas_array:Array<String>
    private lateinit var adpatorComidasSee:ArrayAdapter<String>
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
        autoCompleteBuscador = findViewById(R.id.editTextMainBuscador)
        botBuscador = findViewById(R.id.butMainBuscador)
        listView = findViewById(R.id.lista);
        switchCarne = findViewById(R.id.switchMainSoloCarne)
        botonDesplazamiento = findViewById(R.id.butMainGoMenu)

    }

    private fun establecerVariables() {
        listaTotalComida.addAll(ListaComida().crearListaComida(this))
        listaMostrar.addAll(listaTotalComida)
        listaReserva.addAll(listaTotalComida)
        adapter = ComidaAdapter(this, listaMostrar)
        listView.adapter = adapter
        comidas_array=resources.getStringArray(R.array.valores_comida)
        adpatorComidasSee= ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,comidas_array)
        autoCompleteBuscador.setAdapter(adpatorComidasSee)
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
            if (autoCompleteBuscador.text.toString().isBlank()) {
                listaMostrar.addAll(listaTotalComida.filter { t -> t.tieneCarne() }.toList())
            } else {
                listaMostrar.addAll(listaReserva.filter { t ->
                    t.getNombre().lowercase().contains(
                        autoCompleteBuscador.text.toString().lowercase()
                    )
                }.filter { t -> t.tieneCarne() })
            }
        } else {
            if (autoCompleteBuscador.text.toString().isBlank()) {
                listaMostrar.addAll(listaTotalComida)
            } else {
                listaMostrar.addAll(listaTotalComida.filter { t ->
                    t.getNombre().lowercase().contains(
                        autoCompleteBuscador.text.toString().lowercase()
                    )
                })
            }
        }
        adapter.notifyDataSetChanged();
    }

    private fun switchCarne() {
        if (switchCarne.isChecked) {
            ObjectAnimator.ofInt(switchCarne,"textColor",ContextCompat.getColor(this,R.color.carne)).apply {
                duration=1000
                start()
            }
            listaReserva.clear()
            listaReserva.addAll(listaMostrar)
            listaMostrar.clear()
            listaMostrar.addAll(listaReserva.filter { t -> t.tieneCarne() }.toList())
        } else {
            ObjectAnimator.ofInt(switchCarne,"textColor",ContextCompat.getColor(this,R.color.black)).apply {
                duration=1000
                start()
            }
            if (autoCompleteBuscador.text.toString().isBlank()) {
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