package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemGoalBinding
import com.example.myapplication.databinding.ItemMainBinding
import com.example.myapplication.databinding.ItemProBinding
import timber.log.Timber


class MainAdapter() : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(position)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            ItemMainBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )
        )

    inner class DataViewHolder(binding: ItemMainBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: Int) {
            Timber.d(user.toString())
        }
    }
}

class ProAdapter() : RecyclerView.Adapter<ProAdapter.DataViewHolder>() {

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(position)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            ItemProBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )
        )

    inner class DataViewHolder(binding: ItemProBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: Int) {
        }
    }
}

class GoalAdapter(private val size: Int) : RecyclerView.Adapter<GoalAdapter.DataViewHolder>() {

    override fun getItemCount(): Int = size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(position)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            ItemGoalBinding.inflate(
                LayoutInflater.from(parent.context), parent,
                false
            )
        )

    inner class DataViewHolder(binding: ItemGoalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: Int) {
        }
    }
}


