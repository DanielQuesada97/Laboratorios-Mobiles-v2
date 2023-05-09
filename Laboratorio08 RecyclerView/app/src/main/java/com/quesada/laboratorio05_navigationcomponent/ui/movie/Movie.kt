package com.quesada.laboratorio05_navigationcomponent.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.quesada.laboratorio05_navigationcomponent.R
import com.quesada.laboratorio05_navigationcomponent.databinding.FragmentBillboardBinding
import com.quesada.laboratorio05_navigationcomponent.databinding.FragmentMovieBinding
import com.quesada.laboratorio05_navigationcomponent.databinding.FragmentNewMovieBinding
import com.quesada.laboratorio05_navigationcomponent.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.quesada.laboratorio05_navigationcomponent.ui.movie.viewmodel.MovieViewModel


class Movie : Fragment() {

    private lateinit var adapter: MovieRecyclerViewAdapter
    private val movieViewModel : MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }
    private lateinit var binding: FragmentMovieBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = movieViewModel
    }
}