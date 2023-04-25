package com.quesada.laboratorio05_navigationcomponent.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

import com.quesada.laboratorio05_navigationcomponent.R
import com.quesada.laboratorio05_navigationcomponent.data.model.MovieModel

class NewMovie : Fragment() {

    private val movieViewModel : MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var nameEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var qualificationEditText: EditText
    private lateinit var submitButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val category = categoryEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val qualification = qualificationEditText.text.toString()

            val newMovie = MovieModel(name, category, description,qualification)
            movieViewModel.addMovies(newMovie)
            Log.d("tag", movieViewModel.getMovies().toString())
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

    private fun bind(){
        nameEditText = view?.findViewById(R.id.nameTextField2) as EditText
        categoryEditText = view?.findViewById(R.id.categoryTextField2) as EditText
        descriptionEditText = view?.findViewById(R.id.descriptionTextField2) as EditText
        qualificationEditText = view?.findViewById(R.id.qualificationTextField2) as EditText
        submitButton = view?.findViewById(R.id.submitButton) as Button

    }

}