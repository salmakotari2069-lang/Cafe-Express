package com.example.cf

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class BoissonAdapter(
    private val context: Context,
    private val boissons: List<Boisson>
) : BaseAdapter() {

    override fun getCount(): Int = boissons.size

    override fun getItem(position: Int): Any = boissons[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        Log.d("ADAPTER", "getView position $position, convertView null ? ${convertView == null}")

        val vue = convertView
            ?: LayoutInflater.from(context).inflate(R.layout.item_boisson, parent, false)

        val boisson = boissons[position]

        vue.findViewById<TextView>(R.id.tvNom).text = boisson.nom
        vue.findViewById<TextView>(R.id.tvDescription).text = boisson.description
        vue.findViewById<TextView>(R.id.tvPrix).text = "${boisson.prix} DH"

        val imgBoisson: ImageView = vue.findViewById(R.id.imgBoisson)
        imgBoisson.setImageResource(boisson.image)

        return vue
    }
}