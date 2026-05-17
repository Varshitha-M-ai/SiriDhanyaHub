package com.example.siridhanyahub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MandiAdapter(private val mandiList: List<Mandi>) :
    RecyclerView.Adapter<MandiAdapter.MandiViewHolder>() {

    class MandiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val millet = itemView.findViewById<TextView>(R.id.txtMillet)
        val price = itemView.findViewById<TextView>(R.id.txtPrice)
        val trend = itemView.findViewById<TextView>(R.id.txtTrend)
        val highLow = itemView.findViewById<TextView>(R.id.txtHighLow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MandiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mandi, parent, false)

        return MandiViewHolder(view)
    }

    override fun onBindViewHolder(holder: MandiViewHolder, position: Int) {

        val mandi = mandiList[position]

        holder.millet.text = mandi.milletName
        holder.price.text = mandi.price
        holder.trend.text = mandi.trend
        holder.highLow.text = mandi.highLow
    }

    override fun getItemCount(): Int {
        return mandiList.size
    }
}