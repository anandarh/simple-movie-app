package com.anandarh.moviecatalogueapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anandarh.moviecatalogueapp.models.MovieModel
import com.anandarh.moviecatalogueapp.models.ResourceMovieModel
import com.anandarh.moviecatalogueapp.models.TvModel
import com.anandarh.moviecatalogueapp.repositories.MovieRepository
import com.anandarh.moviecatalogueapp.utilities.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _movieDataState = MutableLiveData<DataState<ResourceMovieModel>>()

    init {
        getMovie()
    }

    val movieDataState: LiveData<DataState<ResourceMovieModel>>
        get() = _movieDataState

    private fun getMovie() {
        viewModelScope.launch {
            repository.getAll().collect { dataState ->
                _movieDataState.postValue(dataState)
            }
        }
    }
}