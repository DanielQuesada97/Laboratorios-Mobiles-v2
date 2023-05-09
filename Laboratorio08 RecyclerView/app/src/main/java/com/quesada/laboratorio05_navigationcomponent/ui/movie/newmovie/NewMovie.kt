package com.quesada.laboratorio05_navigationcomponent.ui.movie.newmovie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

import com.quesada.laboratorio05_navigationcomponent.R
import com.quesada.laboratorio05_navigationcomponent.databinding.FragmentNewMovieBinding
import com.quesada.laboratorio05_navigationcomponent.ui.movie.viewmodel.MovieViewModel

class NewMovie : Fragment() {

    private val movieViewModel : MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var nameEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var qualificationEditText: EditText
    private lateinit var submitButton: Button

    private lateinit var binding: FragmentNewMovieBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        setViewModel()
        observeStatus()
        //Boton
//        submitButton.setOnClickListener {
//            val name = nameEditText.text.toString()
//            val category = categoryEditText.text.toString()
//            val description = descriptionEditText.text.toString()
//            val qualification = qualificationEditText.text.toString()
//
//            val newMovie = MovieModel(name, category, description,qualification)
//            movieViewModel.addMovies(newMovie)
//            Log.d("tag", movieViewModel.getMovies().toString())
//        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setViewModel() {
        binding.viewmodel = movieViewModel
    }

    private fun observeStatus() {
        movieViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Log.d("tag", status)
                    movieViewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d("tag", status)
                    Log.d("tag", movieViewModel.getMovies().toString())

                    movieViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    private fun bind(){
        nameEditText = view?.findViewById(R.id.nameTextField2) as EditText
        categoryEditText = view?.findViewById(R.id.categoryTextField2) as EditText
        descriptionEditText = view?.findViewById(R.id.descriptionTextField2) as EditText
        qualificationEditText = view?.findViewById(R.id.qualificationTextField2) as EditText
        submitButton = view?.findViewById(R.id.submitButton) as Button

    }

}