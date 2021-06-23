package com.anandarh.moviecatalogueapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anandarh.moviecatalogueapp.models.MovieModel
import com.anandarh.moviecatalogueapp.models.ResourceMovieModel
import com.anandarh.moviecatalogueapp.models.TvModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val dummyData: ResourceMovieModel
) : ViewModel() {

    private val _movieDataState = MutableLiveData<List<MovieModel>>()
    private val _tvDataState = MutableLiveData<List<TvModel>>()


    val movieDataState: LiveData<List<MovieModel>>
        get() {
            _movieDataState.value = dummyData.movies
            return _movieDataState
        }

    val tvDataState: LiveData<List<TvModel>>
        get() {
            _tvDataState.value = dummyData.tv
            return _tvDataState
        }


}