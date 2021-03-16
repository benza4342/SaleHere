package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.FragmentAchievementBinding
import com.example.myapplication.databinding.FragmentGoalBinding


class AchievementFragment : Fragment() {

    private lateinit var bindings: FragmentAchievementBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindings = FragmentAchievementBinding.inflate(inflater, container, false)
        setupView()
        return bindings.root
    }

    private fun setupView() {
        val recyclerView = bindings.rvMain
        recyclerView.layoutManager = GridLayoutManager(activity, 3)
        val adapter = GoalAdapter(8)
        recyclerView.adapter = adapter

    }
}