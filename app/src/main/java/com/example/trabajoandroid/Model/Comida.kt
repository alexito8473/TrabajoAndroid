package com.example.trabajoandroid.Model

import java.io.Serializable

/**
 * Clase que representa un objeto Comida.
 * @author Alejandro Aguilar Alba
 * @since 1.0
 * @constructor Crea un objeto Comida con los siguientes parámetros.
 * @param nombre El nombre de la comida.
 * @param tieneCarne Indica si la comida esta conformada solamente con carne.
 * @param imagenComida Donde se almacena la imagen de la cómida.
 * @param precio El precio de la comida.
 * @param descripcion La descripción que tiene la comida.
 * @param isBebida Indica si se trata de una bebida o no.
 * @param isPostre Indica si se trata de una postre o no.
 * @param videoPath La ruta del video relacionado con la comida.
 * @param valoracion La valoración obtenida de la comida.
 */
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

    constructor(
        nombre: String,
        tieneCarne: Boolean,
        imagenComida: Int,
        precio: Double,
        descripcion: String,
        isBebida: Boolean,
        isPostre: Boolean,
        videoPath: String,
        valoracion: Float
    ) {
        this.nombre = nombre
        this.tieneCarne = tieneCarne
        this.imagenComida = imagenComida
        this.precio = precio
        this.descripcion = descripcion
        this.isBebida = isBebida
        this.isPostre = isPostre
        this.videoPath = videoPath
        this.valoracion = valoracion
    }

    /**
     * Método que devuelve el nombre de la comida.
     * @return El nombre de la comida.
     */
    fun getNombre(): String {
        return nombre;
    }

    /**
     * Método que devuelve si la comida si es su totalidad es carne o no.
     * @return true Es solo carne, false No unicamente de carne
     */
    fun tieneCarne(): Boolean {
        return tieneCarne;
    }

    /**
     * Método que la imagen de la comida
     * @return Devuelve una url que es el repositorio de la comida
     */
    fun getImagenComida(): Int {
        return imagenComida;
    }

    /**
     * Método que devuelve el precio de la comida
     * @return Retorna el precio
     */
    fun getPrecio(): Double {
        return precio;
    }

    /**
     * Método que devuelve una descripción amplia de la comida
     * @return Retorna la descripción
     */
    fun getDescripcion(): String {
        return descripcion;
    }

    /**
     * Método que devuelve si es una bebida
     * @return  true Es una bebida, false No es una bebida.
     */
    fun isBebida(): Boolean {
        return isBebida;
    }

    /**
     * Método que devuelve si es un postre
     * @return  true Es una postre, false No es una postre.
     */
    fun isPostre(): Boolean {
        return isPostre;
    }

    /**
     * Método que devuelve la ruta del video relacionado con la comida.
     * @return La ruta del video relacionado con la comida.
     */
    fun getVideoPath(): String {
        return videoPath;
    }

    /**
     * Método que devuelve la valoración de la comida.
     * @return La valoración de la comida.
     */
    fun getValoracion(): Float {
        return valoracion;
    }
}