package com.example.trabajoandroid.Model

import java.io.Serializable

class Comida : Serializable {
    private var nombre: String
    private var tieneCarne: Boolean
    private var imagenComida: Int
    private var precio: Double
    private var descripcion: String
    private var isBebida: Boolean
    private var isPostre: Boolean
    private var videoPath: String
    private var valoracion: Float
    constructor(nombre: String,tieneCarne: Boolean,imagenComida: Int,precio: Double,descripcion: String,isBebida: Boolean,isPostre: Boolean,videoPath: String,valoracion: Float) {
        this.nombre = nombre
        this.tieneCarne=tieneCarne
        this.imagenComida=imagenComida
        this.precio=precio
        this.descripcion=descripcion
        this.isBebida=isBebida
        this.isPostre=isPostre
        this.videoPath=videoPath
        this.valoracion=valoracion
    }

    fun getNombre(): String {
        return nombre;
    }

    fun tieneCarne(): Boolean {
        return tieneCarne;
    }

    fun getImagenComida(): Int {
        return imagenComida;
    }

    fun getPrecio(): Double {
        return precio;
    }

    fun getDescripcion(): String {
        return descripcion;
    }

    fun isBebida(): Boolean {
        return isBebida;
    }

    fun isPostre(): Boolean {
        return isPostre;
    }
    fun getVideoPath(): String {
        return videoPath;
    }
    fun getValoracion(): Float {
        return valoracion;
    }
}