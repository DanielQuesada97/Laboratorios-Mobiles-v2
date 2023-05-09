package com.quesada.laboratorio05_navigationcomponent

import android.app.Application
import com.quesada.laboratorio05_navigationcomponent.data.movies
import com.quesada.laboratorio05_navigationcomponent.repositories.MovieRepository

class MovieReviewerApplication : Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }

}