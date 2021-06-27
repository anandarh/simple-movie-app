package com.anandarh.moviecatalogueapp.data

import com.anandarh.moviecatalogueapp.models.CastModel
import com.anandarh.moviecatalogueapp.models.MovieModel
import com.anandarh.moviecatalogueapp.models.TvModel

object DummyData {

    fun generateDummyMovies(): ArrayList<MovieModel> {
        val movies = ArrayList<MovieModel>()
        val cast = ArrayList<CastModel>()

        cast.add(
            CastModel(
                adult = false,
                gender = 2,
                id = 17178,
                knownForDepartment = "Acting",
                name = "Patrick Wilson",
                originalName = "Patrick Wilson",
                popularity = 10.635,
                profilePath = "/tc1ezEfIY8BhCy85svOUDtpBFPt.jpg",
                castId = 3,
                character = "Ed Warren",
                creditId = "5ac72ba992514162a40202d7",
                order = 0
            )
        )

        movies.add(
            MovieModel(
                cast = cast,
                genreIds = (1..5).toList(),
                id = 423108,
                originalTitle = "The Conjuring: The Devil Made Me Do It",
                overview = "overview",
                posterPath = "/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg",
                releaseDate = "2021-05-25",
                title = "The Conjuring: The Devil Made Me Do It",
                voteAverage = 8.3,
                voteCount = 1832,
            )
        )

        return movies
    }

    fun generateDummyTv(): ArrayList<TvModel> {
        val tv = ArrayList<TvModel>()
        val cast = ArrayList<CastModel>()

        cast.add(
            CastModel(
                adult = false,
                gender = 2,
                id = 17178,
                knownForDepartment = "Acting",
                name = "Patrick Wilson",
                originalName = "Patrick Wilson",
                popularity = 10.635,
                profilePath = "/tc1ezEfIY8BhCy85svOUDtpBFPt.jpg",
                castId = 3,
                character = "Ed Warren",
                creditId = "5ac72ba992514162a40202d7",
                order = 0
            )
        )

        tv.add(
            TvModel(
                cast = cast,
                firstAirDate = "2021-05-25",
                genreIds = (1..5).toList(),
                id = 423108,
                name = "Loki",
                originCountry = listOf(),
                originalName = "Loki",
                overview = "overview",
                posterPath = "/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg",

                voteAverage = 8.3,
                voteCount = 1832,
            )
        )

        return tv
    }

}