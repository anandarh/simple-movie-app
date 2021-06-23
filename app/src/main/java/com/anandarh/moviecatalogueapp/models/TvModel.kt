package com.anandarh.moviecatalogueapp.models


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class TvModel(
    val cast: List<CastModel>,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    val id: Int,
    val name: String,
    @SerializedName("origin_country")
    val originCountry: List<String>,
    @SerializedName("original_name")
    val originalName: String,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
) : Parcelable