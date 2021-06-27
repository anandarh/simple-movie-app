package com.anandarh.moviecatalogueapp.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.anandarh.moviecatalogueapp.data.DummyData
import com.anandarh.moviecatalogueapp.data.MovieRepository
import com.anandarh.moviecatalogueapp.models.MovieModel
import com.anandarh.moviecatalogueapp.models.TvModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MovieRepository

    @Mock
    private lateinit var observerMovie: Observer<List<MovieModel>>

    @Mock
    private lateinit var observerTv: Observer<List<TvModel>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(repository)
    }

    @Test
    fun getMovies() {
        val dummyData = DummyData.generateDummyMovies()
        val movies = MutableLiveData<List<MovieModel>>()
        movies.value = dummyData

        `when`(repository.getMovie()).thenReturn(movies)

        val movieData = viewModel.getMovie.value

        verify(repository).getMovie()

        assertNotNull(movieData)
        assertEquals(1, movieData?.size)

        viewModel.getMovie.observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyData)
    }

    @Test
    fun getTv() {
        val dummyData = DummyData.generateDummyTv()
        val tv = MutableLiveData<List<TvModel>>()
        tv.value = dummyData

        `when`(repository.getTv()).thenReturn(tv)

        val tvData = viewModel.getTv.value

        verify(repository).getTv()

        assertNotNull(tvData)
        assertEquals(1, tvData?.size)

        viewModel.getTv.observeForever(observerTv)
        verify(observerTv).onChanged(tvData)
    }

}