package com.quesada.laboratorio05_navigationcomponent.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.quesada.laboratorio05_navigationcomponent.MovieReviewerApplication
import com.quesada.laboratorio05_navigationcomponent.data.model.MovieModel
import com.quesada.laboratorio05_navigationcomponent.repositories.MovieRepository

class MovieViewModel (private val repository: MovieRepository) : ViewModel(){

    fun getMovies() = repository.getMovies()

    fun addMovies(movie: MovieModel) = repository.addMovies(movie)

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
    }
}