package com.anandarh.moviecatalogueapp.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.anandarh.moviecatalogueapp.models.MovieModel
import com.anandarh.moviecatalogueapp.models.ResourceMovieModel
import com.anandarh.moviecatalogueapp.models.TvModel
import com.anandarh.moviecatalogueapp.utilities.ReadFile
import com.google.gson.Gson

class MovieRepository(private val context: Context) {

    fun getMovie(): LiveData<List<MovieModel>> {
        val result = MutableLiveData<List<MovieModel>>()
        val jsonString =
            ReadFile().getJsonFromAsset(context, "resource.json")
        val data = Gson().fromJson(jsonString, ResourceMovieModel::class.java)
        result.postValue(data.movies)
        return result
    }

    fun getTv(): LiveData<List<TvModel>> {
        val result = MutableLiveData<List<TvModel>>()
        val jsonString =
            ReadFile().getJsonFromAsset(context, "resource.json")
        val data = Gson().fromJson(jsonString, ResourceMovieModel::class.java)
        result.postValue(data.tv)
        return result
    }
}