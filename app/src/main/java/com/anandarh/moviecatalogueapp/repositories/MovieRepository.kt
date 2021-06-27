package com.anandarh.moviecatalogueapp.repositories

import android.content.Context
import com.anandarh.moviecatalogueapp.models.ResourceMovieModel
import com.anandarh.moviecatalogueapp.utilities.DataState
import com.anandarh.moviecatalogueapp.utilities.ReadFile
import com.google.gson.Gson
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepository(private val context: Context) {

    companion object {
        private const val DURATION: Long = 500
    }

    suspend fun getAll(): Flow<DataState<ResourceMovieModel>> = flow {
        emit(DataState.Loading)
        delay(DURATION)
        try {
            val jsonString =
                ReadFile().getJsonFromAsset(context, "resource.json")
            val data = Gson().fromJson(jsonString, ResourceMovieModel::class.java)
            emit(DataState.Success(data))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}