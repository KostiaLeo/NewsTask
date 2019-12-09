package com.example.restkotlinized.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restkotlinized.databinding.TopNewBinding
import com.example.restkotlinized.model.Results

class TopNewsAdapter(val artists: ArrayList<Results>) :
    RecyclerView.Adapter<TopNewsAdapter.TopViewHolder>() {
    companion object {
        const val AMOUNT_OF_TOPNEWS = 5
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TopNewBinding.inflate(layoutInflater, parent, false)

        return TopViewHolder(binding)
    }

    override fun getItemCount(): Int = artists?.let { AMOUNT_OF_TOPNEWS }

    override fun onBindViewHolder(holder: TopViewHolder, position: Int)
            = holder.bind(artists[position])

    inner class TopViewHolder(private val binding: TopNewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(artist: Results){
            binding.artist = artist
        }
    }
}