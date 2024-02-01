package com.example.trabajoandroid

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ComidaAdapterV2(private val mContext: Context, private val listaComida: MutableList<Comida>) :
    ArrayAdapter<Comida>(mContext, 0, listaComida) {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout: View =
            LayoutInflater.from(mContext).inflate(R.layout.item_comidav2, parent, false)
        val producto = listaComida[position]
        val textView = layout.findViewById<TextView>(R.id.nombreICV2_Comida)
        textView.text = producto.getNombre()
        val imageComida = layout.findViewById<ImageView>(R.id.imagenICV2_Comida)
        imageComida.setImageResource(producto.getImagenComida())
        return layout
    }
}