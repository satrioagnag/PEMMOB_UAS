package com.example.projectuas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movieImageView: ImageView
    private lateinit var movieTitleTextView: TextView
    private lateinit var bookingButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        // Initialize views
        movieImageView = findViewById(R.id.movie_image)
        movieTitleTextView = findViewById(R.id.movie_title)
        bookingButton = findViewById(R.id.btnBooking)

        // Get the data passed from the previous activity
        val movieTitle = intent.getStringExtra("movie_title")
        val movieImage = intent.getIntExtra("movie_image", 0)

        Log.d("MovieDetailActivity", "Received movieTitle: $movieTitle, movieImage: $movieImage")

        // Set the data to views
        if (movieTitle != null) {
            movieTitleTextView.text = movieTitle
        } else {
            Log.e("MovieDetailActivity", "movieTitle is null")
        }

        if (movieImage != 0) {
            movieImageView.setImageResource(movieImage)
        } else {
            Log.e("MovieDetailActivity", "movieImage is 0")
        }

        // Set up onClickListener for the booking button
        bookingButton.setOnClickListener {
            val intent = Intent(this, SeatScreenActivity::class.java)
            startActivity(intent)
        }
    }
}
