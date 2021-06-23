package com.anandarh.moviecatalogueapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anandarh.moviecatalogueapp.BuildConfig
import com.anandarh.moviecatalogueapp.databinding.ItemMovieBinding
import com.anandarh.moviecatalogueapp.models.MovieModel
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var items: List<MovieModel> = ArrayList()

    internal fun setDataList(data: List<MovieModel>) {
        items = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val formatterIn = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val formatterOut = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())

        with(holder.binding) {
            with(items[position]) {
                Picasso.get().load("${BuildConfig.SERVER_URL}$posterPath").into(ivPoster)
                ratingBar.rating = (voteAverage / 2).toFloat()
                tvTitle.text = title
                tvDate.text = formatterOut.format(formatterIn.parse(releaseDate)!!)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)
}