package com.example.trabajoandroid

import android.annotation.SuppressLint
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
        crearListaComida()
        listaMostrar.addAll(listaTotalComida)
        listaReserva.addAll(listaTotalComida)
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
            val intent = Intent(this,DatoComidaActivity::class.java)
            intent.putExtra(getString(R.string.Intent_Comida),listaMostrar[position])
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

    private fun crearListaComida() {
        listaTotalComida.add(Comida(getString(R.string.Scones), false, R.drawable.scones,12.2,getString(R.string.Descrip_scones),false,false))
        listaTotalComida.add(Comida(getString(R.string.SuperScones), false, R.drawable.superscones,4.5,getString(R.string.Descrip_superScones),false,false))
        listaTotalComida.add(Comida(getString(R.string.CarneCruda), true, R.drawable.carne,43.4,getString(R.string.Descrip_carneCruda),false,false))
        listaTotalComida.add(Comida(getString(R.string.Bistek), true, R.drawable.carne,12.2,getString(R.string.Descrip_Bistek),false,false))
        listaTotalComida.add(Comida(getString(R.string.CocaCola), false, R.drawable.cocacola,4.6,getString(R.string.Descrip_coccaCola),true,false))
        listaTotalComida.add(Comida(getString(R.string.SupDes), false, R.drawable.supdesa,12.4,getString(R.string.Descrip_supDesay),false,false))
        listaTotalComida.add(Comida(getString(R.string.DesaCom), false, R.drawable.desayuno,6.2,getString(R.string.Descrip_desaCompl),false,false))
        listaTotalComida.add(Comida(getString(R.string.OjoDedios), false, R.drawable.ojosdedios,20.2,getString(R.string.Descrip_ojoDeDios),false,false))
        listaTotalComida.add(Comida(getString(R.string.BolasCarne), true, R.drawable.bolabuenas,12.2,getString(R.string.Descrip_boCar),false,false))
        listaTotalComida.add(Comida(getString(R.string.AlgodonDeAzucar), false, R.drawable.algoazu,23.2,getString(R.string.Descrip_algoAzu),false,true))
        listaTotalComida.add(Comida(getString(R.string.BeiQue), true, R.drawable.beiconcrudo,9.5,getString(R.string.Descrip_beQue),false,false))
        listaTotalComida.add(Comida(getString(R.string.Buñuelos), false, R.drawable.bunuelos,23.2,getString(R.string.Descrip_buñuelos),false,false))
        listaTotalComida.add(Comida(getString(R.string.PolloPohe), true, R.drawable.pollohecho,15.2,getString(R.string.Descrip_polPoHec),false,false))
        listaTotalComida.add(Comida(getString(R.string.PolloFrito), true, R.drawable.pollofrito,7.6,getString(R.string.Descrip_polFri),false,false))
    }
}