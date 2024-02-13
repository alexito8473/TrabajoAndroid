package com.example.trabajoandroid.Model

class Usuario {
    private var nombre: String
    private var gmail: String
    constructor(gmail: String,nombre: String){
        this.gmail=gmail
        this.nombre=nombre
    }

    fun getNombre(): String {
        return nombre;
    }

    fun getGmail(): String {
        return gmail;
    }
}