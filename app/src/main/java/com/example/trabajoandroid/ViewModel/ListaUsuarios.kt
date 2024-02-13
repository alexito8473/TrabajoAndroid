package com.example.trabajoandroid.ViewModel

import android.content.Context
import com.example.trabajoandroid.Model.Usuario

class ListaUsuarios {
    val listaTotalUsuarios: MutableList<Usuario> = mutableListOf()
    public fun crearListaUsuarios(context: Context): MutableList<Usuario> {
        listaTotalUsuarios.add(Usuario("admin@gmail.com", "admin"))
        listaTotalUsuarios.add(Usuario("alejandro@gmail.com", "123"))
        listaTotalUsuarios.add(Usuario("pedro@gmail.com", "1234"))
        listaTotalUsuarios.add(Usuario("juanPadre@gmail.com", "1234"))
        listaTotalUsuarios.add(Usuario("diosMio@gmail.com", "dios"))
        listaTotalUsuarios.add(Usuario("madreMia@gmail.com", "madre"))
        listaTotalUsuarios.add(Usuario("pepe@gmail.com", "pepe"))
        return listaTotalUsuarios
    }
}