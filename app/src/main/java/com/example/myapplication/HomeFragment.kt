package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var bindings: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindings = FragmentHomeBinding.inflate(inflater, container, false)
        setupView()
        return bindings.root
    }

    private fun setupView() {
        val recyclerView = bindings.rvMain
        val recyclerViewPro1 = bindings.rvPro1
        val recyclerViewPro = bindings.rvPro

        recyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val adapter = MainAdapter()
        recyclerView.adapter = adapter

        recyclerViewPro.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val adapterPro = ProAdapter()
        recyclerViewPro.adapter = adapterPro

        recyclerViewPro1.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val adapterPro1 = ProAdapter()
        recyclerViewPro1.adapter = adapterPro1


        bindings.btNew.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_goalFragment) }
    }
}