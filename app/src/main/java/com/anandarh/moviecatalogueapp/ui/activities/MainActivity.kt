package com.anandarh.moviecatalogueapp.ui.activities

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.anandarh.moviecatalogueapp.R
import com.anandarh.moviecatalogueapp.adapters.PagerAdapter
import com.anandarh.moviecatalogueapp.databinding.ActivityMainBinding
import com.anandarh.moviecatalogueapp.ui.fragments.MovieFragment
import com.anandarh.moviecatalogueapp.ui.fragments.TvFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.movie,
            R.string.tv_show
        )

        private val FRAGMENTS = listOf(
            MovieFragment(),
            TvFragment()
        )
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeUI()

    }

    private fun initializeUI() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0F

        binding.viewPager.adapter = PagerAdapter(this, FRAGMENTS)

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
    }
}