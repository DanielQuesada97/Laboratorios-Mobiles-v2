package com.quesada.laboratorio05_navigationcomponent.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.quesada.laboratorio05_navigationcomponent.data.model.MovieModel
import com.quesada.laboratorio05_navigationcomponent.databinding.MovieItemBinding

class MovieRecyclerViewHolder (private val binding: MovieItemBinding): RecyclerView.ViewHolder (binding.root) {
    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit) {
        binding.titleTextView.text = movie.name
        binding.scoreTextView.text = movie.qualification

        binding.firstCardView.setOnClickListener {
            clickListener(movie)
        }
    }
}