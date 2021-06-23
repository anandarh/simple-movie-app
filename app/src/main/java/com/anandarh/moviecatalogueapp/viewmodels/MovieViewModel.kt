package com.anandarh.moviecatalogueapp.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.anandarh.moviecatalogueapp.models.MovieModel
import com.anandarh.moviecatalogueapp.models.ResourceMovieModel
import com.anandarh.moviecatalogueapp.models.TvModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val dummyData: ResourceMovieModel
) : ViewModel() {
    
    val movieDataState: List<MovieModel>
        get() = dummyData.movies

    val tvDataState: List<TvModel>
        get() = dummyData.tv

}