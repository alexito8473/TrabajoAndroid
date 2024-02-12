package com.example.trabajoandroid.ViewModel

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.os.persistableBundleOf
import com.example.trabajoandroid.Model.Comida
import com.example.trabajoandroid.R

class ComidaAdapterV4(private val mContext: Context, private val listaComida: MutableList<Comida>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return listaComida.size
    }

    override fun getItem(position: Int): Any {
        return listaComida.get(position)
    }

    override fun getItemId(position: Int): Long {
      return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View =View.inflate(mContext,R.layout.item_comidav4,null)
        val producto = listaComida[position]
        val textView = view.findViewById<TextView>(R.id.textView6)
        textView.text = producto.getNombre()
        val imageComida = view.findViewById<ImageView>(R.id.imageView)
        imageComida.setImageResource(producto.getImagenComida())
        return view
    }
}