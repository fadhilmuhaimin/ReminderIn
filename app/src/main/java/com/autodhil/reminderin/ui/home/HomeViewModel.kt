package com.autodhil.reminderin.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.autodhil.reminderin.model.Pengawasan

class HomeViewModel(val rvProfile: RecyclerView) :ViewModel(){
    class Factory(val rvProfile: RecyclerView) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeViewModel(rvProfile) as T
        }
    }

    val listPengawasan = ArrayList<Pengawasan>()

    fun setData(){
        listPengawasan.add(Pengawasan("1","NRM : 8288-999-000","Carol Anderson"))
        listPengawasan.add(Pengawasan("2","NRM : 8288-999-000","Carol Maksa"))
        listPengawasan.add(Pengawasan("3","NRM : 8288-999-000","Anja Anderson"))
        listPengawasan.add(Pengawasan("4","NRM : 8288-999-000","Carol Anderson"))
        listPengawasan.add(Pengawasan("5","NRM : 8288-999-000","Carol Anderson"))
        setRecPengawasan()
    }

    private fun setRecPengawasan() {
        val adapterr = PengawasanAdapter(listPengawasan)
        rvProfile.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = adapterr
        }

    }


}