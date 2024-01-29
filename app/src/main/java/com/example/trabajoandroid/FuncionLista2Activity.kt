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
        crearListaComida()
        listaReserva.addAll(listaTotalComida)
        adapter = ComidaAdapter(this, listaMostrar)
        listView.adapter = adapter;
    }

    private fun crearListaComida() {
        listaTotalComida.add(
            Comida(
                getString(R.string.Scones),
                false,
                R.drawable.scones,
                12.2,
                getString(R.string.Descrip_scones),
                false,
                false
            )
        )
        listaTotalComida.add(
            Comida(
                getString(R.string.SuperScones),
                false,
                R.drawable.superscones,
                4.5,
                getString(R.string.Descrip_superScones),
                false,
                false
            )
        )
        listaTotalComida.add(
            Comida(
                getString(R.string.CarneCruda),
                true,
                R.drawable.carne,
                43.4,
                getString(R.string.Descrip_carneCruda),
                false,
                false
            )
        )
        listaTotalComida.add(
            Comida(
                getString(R.string.Bistek),
                true,
                R.drawable.carne,
                12.2,
                getString(R.string.Descrip_Bistek),
                false,
                false
            )
        )
        listaTotalComida.add(
            Comida(
                getString(R.string.CocaCola),
                false,
                R.drawable.cocacola,
                4.6,
                getString(R.string.Descrip_coccaCola),
                true,
                false
            )
        )
        listaTotalComida.add(
            Comida(
                getString(R.string.SupDes),
                false,
                R.drawable.supdesa,
                12.4,
                getString(R.string.Descrip_supDesay),
                false,
                false
            )
        )
        listaTotalComida.add(
            Comida(
                getString(R.string.DesaCom),
                false,
                R.drawable.desayuno,
                6.2,
                getString(R.string.Descrip_desaCompl),
                false,
                false
            )
        )
        listaTotalComida.add(
            Comida(
                getString(R.string.OjoDedios),
                false,
                R.drawable.ojosdedios,
                20.2,
                getString(R.string.Descrip_ojoDeDios),
                false,
                false
            )
        )
        listaTotalComida.add(
            Comida(
                getString(R.string.BolasCarne),
                true,
                R.drawable.bolabuenas,
                12.2,
                getString(R.string.Descrip_boCar),
                false,
                false
            )
        )
        listaTotalComida.add(
            Comida(
                getString(R.string.AlgodonDeAzucar),
                false,
                R.drawable.algoazu,
                23.2,
                getString(R.string.Descrip_algoAzu),
                false,
                true
            )
        )
        listaTotalComida.add(
            Comida(
                getString(R.string.BeiQue),
                true,
                R.drawable.beiconcrudo,
                9.5,
                getString(R.string.Descrip_beQue),
                false,
                false
            )
        )
        listaTotalComida.add(
            Comida(
                getString(R.string.Buñuelos),
                false,
                R.drawable.bunuelos,
                23.2,
                getString(R.string.Descrip_buñuelos),
                false,
                false
            )
        )
        listaTotalComida.add(
            Comida(
                getString(R.string.PolloPohe),
                true,
                R.drawable.pollohecho,
                15.2,
                getString(R.string.Descrip_polPoHec),
                false,
                false
            )
        )
        listaTotalComida.add(
            Comida(
                getString(R.string.PolloFrito),
                true,
                R.drawable.pollofrito,
                7.6,
                getString(R.string.Descrip_polFri),
                false,
                false
            )
        )
        listaTotalComida.add(
            Comida(
                getString(R.string.TartaQueso),
                false,
                R.drawable.tartadequeso,
                12.6,
                "tarta de queso",
                false,
                true
            )
        )
    }
}