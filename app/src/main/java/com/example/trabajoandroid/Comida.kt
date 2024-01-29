package com.example.trabajoandroid

import java.io.Serializable

class Comida :Serializable{
    private var nombre: String
    private var tieneCarne: Boolean
    private var imagenComida: Int
    private var precio: Double
    private var descripcion: String
    private var isBebida: Boolean
    private var isPostre: Boolean
    constructor(nombre: String,tieneCarne: Boolean,imagenComida: Int,precio: Double,descripcion: String,isBebida: Boolean,isPostre: Boolean) {
        this.nombre = nombre
        this.tieneCarne=tieneCarne
        this.imagenComida=imagenComida
        this.precio=precio
        this.descripcion=descripcion
        this.isBebida=isBebida
        this.isPostre=isPostre
    }
    fun getNombre():String{
        return nombre;
    }
    fun tieneCarne():Boolean{
        return tieneCarne;
    }
    fun getImagenComida():Int{
        return imagenComida;
    }
    fun getPrecio():Double{
        return precio;
    }
    fun getDescripcion():String{
        return descripcion;
    }
    fun isBebida():Boolean {
        return isBebida;
    }
    fun isPostre():Boolean {
        return isPostre;
    }
}