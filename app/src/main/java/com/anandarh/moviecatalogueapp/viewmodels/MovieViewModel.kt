package com.anandarh.moviecatalogueapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.anandarh.moviecatalogueapp.data.MovieRepository
import com.anandarh.moviecatalogueapp.models.MovieModel
import com.anandarh.moviecatalogueapp.models.TvModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    val getMovie: LiveData<List<MovieModel>> get() = repository.getMovie()

    val getTv: LiveData<List<TvModel>> get() = repository.getTv()
}