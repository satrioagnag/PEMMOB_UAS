package com.example.projectuas

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val movieList: List<Movie>, private val context: Context) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.movieImage.setImageResource(movie.imageResource)

        holder.itemView.setOnClickListener {
            Log.d("MovieAdapter", "Clicked on: ${movie.title}")
            val intent = Intent(context, MovieDetailActivity::class.java).apply {
                putExtra("movie_title", movie.title)
                putExtra("movie_image", movie.imageResource)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.movie_image)
    }
}
