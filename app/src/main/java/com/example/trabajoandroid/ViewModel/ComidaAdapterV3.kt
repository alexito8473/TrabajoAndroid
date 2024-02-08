package com.example.trabajoandroid.ViewModel

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.example.trabajoandroid.Model.Comida
import com.example.trabajoandroid.R

class ComidaAdapterV3(private val mContext: Context, private val listaComida: MutableList<Comida>) :
    ArrayAdapter<Comida>(mContext, 0, listaComida) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout: View =
            LayoutInflater.from(mContext).inflate(R.layout.item_comidav3, parent, false)
        val producto = listaComida[position]
        val textView = layout.findViewById<TextView>(R.id.texICV3Nombre)
        textView.text = producto.getNombre()
        val imageComida = layout.findViewById<ImageView>(R.id.imagenICV3Comida)
        imageComida.setImageResource(producto.getImagenComida())
        val ratingComida = layout.findViewById<RatingBar>(R.id.ratingICV3Valoracion)
        ratingComida.rating=producto.getValoracion()
        return layout
    }
}