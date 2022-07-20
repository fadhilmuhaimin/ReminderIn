package com.autodhil.reminderin.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.autodhil.reminderin.databinding.ItemPengawasanBinding
import com.autodhil.reminderin.model.Pengawasan

class PengawasanAdapter(val list : ArrayList<Pengawasan>) : RecyclerView.Adapter<PengawasanAdapter.ViewHolder>(){
    inner class ViewHolder(private var binding : ItemPengawasanBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(pengawasan : Pengawasan){
            binding.itemPengawasan = pengawasan
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemPengawasanBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list.get(position)
        holder.bind(item)     }

    override fun getItemCount(): Int  = list.size

}