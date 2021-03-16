package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.FragmentGoalBinding


class GoalFragment : Fragment() {

    private lateinit var bindings: FragmentGoalBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindings = FragmentGoalBinding.inflate(inflater, container, false)
        setupView()
        return bindings.root
    }

    private fun setupView() {
        val recyclerView = bindings.rvMain
        recyclerView.layoutManager = GridLayoutManager(activity, 3)
        val adapter = GoalAdapter(5)
        recyclerView.adapter = adapter

    }
}