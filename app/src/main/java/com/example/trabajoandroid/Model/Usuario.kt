package com.example.trabajoandroid.Model
/**
 * Clase que representa un objeto Usuario.
 * @author Alejandro Aguilar Alba
 * @since 1.0
 * @constructor Crea un objeto Usuario con los siguientes parámetros.
 * @param contraseña La contraseña del usuario.
 * @param gmail Indica que gmail tiene almacenado el usuario
 */
class Usuario {
    private var contraseña: String
    private var gmail: String
    constructor(gmail: String,contraseña: String){
        this.gmail=gmail
        this.contraseña=contraseña
    }
    /**
     * Método que devuelve la contraseña del usuario.
     * @return La contraseña del usuario.
     */
    fun getContraseña(): String {
        return contraseña;
    }
    /**
     * Método que devuelve el gmail del usuario.
     * @return El gmail del usuario.
     */
    fun getGmail(): String {
        return gmail;
    }
}