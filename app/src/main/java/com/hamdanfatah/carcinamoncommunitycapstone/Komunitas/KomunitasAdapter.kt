package com.hamdanfatah.carcinamoncommunitycapstone.Komunitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hamdanfatah.carcinamoncommunitycapstone.R
import com.hamdanfatah.carcinamoncommunitycapstone.model.PertanyaanModel

class KomunitasAdapter(private val empList: List<PertanyaanModel>):RecyclerView.Adapter<KomunitasAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvJudul: TextView = itemView.findViewById(R.id.judul)
        val tvDeskripsi: TextView = itemView.findViewById(R.id.deskripsi)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.items_komunitas, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return empList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val curretEmp = empList[position]
        holder.tvJudul.text = curretEmp.header
        holder.tvDeskripsi.text = curretEmp.text
    }
}