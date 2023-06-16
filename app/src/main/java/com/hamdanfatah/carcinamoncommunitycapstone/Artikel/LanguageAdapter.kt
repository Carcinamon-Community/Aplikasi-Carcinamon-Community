package com.hamdanfatah.carcinamoncommunitycapstone.Artikel


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hamdanfatah.carcinamoncommunitycapstone.R

class LanguageAdapter(var mList: List<LanguageData>): RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    var onItemClick: ((LanguageData)-> Unit)? = null
    class LanguageViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val ivLogo: ImageView = itemView.findViewById(R.id.iv_logo)
        val tvTittle: TextView = itemView.findViewById(R.id.tv_tittle)
        val tvDeskripsi: TextView = itemView.findViewById(R.id.tv_deskripsi)

    }

    fun setFilteredList(mList: List<LanguageData>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail_artikel, parent, false)
        return LanguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.ivLogo.setImageResource(mList[position].logo)
        holder.tvTittle.text = mList[position].tittle
        holder.tvDeskripsi.text = mList[position].deskripsi

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(mList[position])

        }
    }
}