package com.example.trabajoandroid.Model

class Usuario {
    private var contraseña: String
    private var gmail: String
    constructor(gmail: String,contraseña: String){
        this.gmail=gmail
        this.contraseña=contraseña
    }

    fun getContraseña(): String {
        return contraseña;
    }

    fun getGmail(): String {
        return gmail;
    }
}