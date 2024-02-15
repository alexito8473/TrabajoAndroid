package com.example.trabajoandroid.ViewModel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trabajoandroid.Model.Comida
import com.example.trabajoandroid.R

class ComidaAdapterV5(private val context: Context, private val datos: MutableList<Comida>) :
    RecyclerView.Adapter<ComidaAdapterV5.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.item_comidav5, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dato = datos[position]
        holder.itemView.startAnimation( AnimationUtils.loadAnimation(context, com.android.car.ui.R.anim.abc_slide_in_bottom))
        holder.bind(dato)
    }

    override fun getItemCount(): Int {
        return datos.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView6)
        val imageComida = itemView.findViewById<ImageView>(R.id.imageView)
        fun bind(dato: Comida) {
            textView.text = dato.getNombre()
            textView.textSize= 25F
            imageComida.setImageResource(dato.getImagenComida())
            imageComida.scaleX= 1.3F
            imageComida.scaleY= 1.3F
        }
    }
}