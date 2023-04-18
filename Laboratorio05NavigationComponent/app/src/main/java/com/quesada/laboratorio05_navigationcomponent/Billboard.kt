package com.quesada.laboratorio05_navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Billboard : Fragment() {

    private lateinit var buttonNewMovie: FloatingActionButton
    private lateinit var firstCardView: CardView
    private lateinit var secondCardView: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        listeners()

    }

    private fun listeners(){
        buttonNewMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboard_to_newMovie)
        }
        firstCardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboard_to_movie)
        }
        secondCardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboard_to_movie)
        }
    }

    private fun bind(){
        buttonNewMovie = view?.findViewById(R.id.floatBotton) as FloatingActionButton
        firstCardView = view?.findViewById(R.id.firstCardView) as CardView
        secondCardView = view?.findViewById(R.id.secondCardView) as CardView

    }

}