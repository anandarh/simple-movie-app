package com.anandarh.moviecatalogueapp.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResourceMovieModel(
    @SerializedName("movies")
    val movies: List<MovieModel>,

    @SerializedName("tv")
    val tv: List<TvModel>
) : Parcelable