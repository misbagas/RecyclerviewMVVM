package com.example.recyclerviewmvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewmvvm.databinding.RecyclerviewMovieBinding

class MoviesAdapter(
    private val movie: List<Movie>
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {


    override fun getItemCount() = movie.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_movie,
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.recyclerviewMovieBinding.movie = movie[position]
    }

    inner class MovieViewHolder(
        val recyclerviewMovieBinding: RecyclerviewMovieBinding
    ) : RecyclerView.ViewHolder(recyclerviewMovieBinding.root)
}