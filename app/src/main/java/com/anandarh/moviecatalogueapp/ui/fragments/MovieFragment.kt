package com.anandarh.moviecatalogueapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.anandarh.moviecatalogueapp.R
import com.anandarh.moviecatalogueapp.databinding.FragmentMovieBinding
import com.anandarh.moviecatalogueapp.utilities.DataState
import com.anandarh.moviecatalogueapp.viewmodels.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie) {

    private lateinit var binding: FragmentMovieBinding

    private val viewModel: MovieViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

        viewModel.movieDataState.observe(viewLifecycleOwner, { dataState ->
            when (dataState) {
                is DataState.Success -> {

                }
                is DataState.Error -> {

                }
                DataState.Loading -> {

                }
            }
        })
    }
}