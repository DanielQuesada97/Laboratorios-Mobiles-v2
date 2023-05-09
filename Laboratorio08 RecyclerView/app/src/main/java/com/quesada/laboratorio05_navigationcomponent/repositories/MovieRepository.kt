package com.quesada.laboratorio05_navigationcomponent.repositories

import com.quesada.laboratorio05_navigationcomponent.data.model.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {

    fun getMovies() = movies

    fun addMovies(movie: MovieModel) = movies.add(movie)
}