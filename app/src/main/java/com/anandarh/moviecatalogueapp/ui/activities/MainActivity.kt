package com.anandarh.moviecatalogueapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.anandarh.moviecatalogueapp.R
import com.anandarh.moviecatalogueapp.adapters.MovieAdapter
import com.anandarh.moviecatalogueapp.databinding.ActivityMainBinding
import com.anandarh.moviecatalogueapp.models.MovieModel
import com.anandarh.moviecatalogueapp.models.ResourceMovieModel
import com.anandarh.moviecatalogueapp.utilities.ReadFile
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAdapter = MovieAdapter()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }

        val jsonString = ReadFile().getJsonFromAsset(this@MainActivity, "resource.json")
        val data = Gson().fromJson(jsonString, ResourceMovieModel::class.java)

        mAdapter.setDataList(data.movies)

    }
}