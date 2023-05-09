package com.quesada.laboratorio05_navigationcomponent.ui.movie.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.quesada.laboratorio05_navigationcomponent.R
import com.quesada.laboratorio05_navigationcomponent.data.model.MovieModel
import com.quesada.laboratorio05_navigationcomponent.databinding.FragmentBillboardBinding
import com.quesada.laboratorio05_navigationcomponent.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.quesada.laboratorio05_navigationcomponent.ui.movie.viewmodel.MovieViewModel


class Billboard : Fragment() {

    private lateinit var adapter: MovieRecyclerViewAdapter

    private lateinit var binding: FragmentBillboardBinding

    private val movieViewModel : MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.floatBotton.setOnClickListener{
            movieViewModel.clearData()
            it.findNavController().navigate(R.id.action_billboard_to_newMovie)
        }

    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovieRecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }

        binding.recyclerView.adapter = adapter
        displayMovies()
    }

    private fun showSelectedItem(movie: MovieModel) {
        movieViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_billboard_to_movie)
    }

    private fun displayMovies() {
        adapter.setData(movieViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }


}