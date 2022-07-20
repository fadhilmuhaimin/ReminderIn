package com.autodhil.reminderin.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.autodhil.reminderin.R
import com.autodhil.reminderin.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {


    private val viewModel: HomeViewModel by viewModels {
        HomeViewModel.Factory(binding.rvPengawasan)
    }
    private lateinit var binding : FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        viewModel.setData()
    }
}