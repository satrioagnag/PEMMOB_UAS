package com.example.projectuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PaymentActivity : AppCompatActivity() {

    private lateinit var movieImageView: ImageView
    private lateinit var movieTitleTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        // Initialize views
        movieImageView = findViewById(R.id.imageViewPoster)
        movieTitleTextView = findViewById(R.id.textViewTitle)

        val movieTitle = intent.getStringExtra("movie_title")
        val movieImage = intent.getIntExtra("movie_image", 0)

        Log.d("PaymentActivity", "Received movieTitle: $movieTitle, movieImage: $movieImage")

        if (movieTitle != null) {
            movieTitleTextView.text = movieTitle
        } else {
            Log.e("PaymentActivity", "movieTitle is null")
        }

        if (movieImage != 0) {
            movieImageView.setImageResource(movieImage)
        } else {
            Log.e("PaymentActivity", "movieImage is 0")
        }

        val Next1 = findViewById<Button>(R.id.btnNext)
        Next1.setOnClickListener {
            navigateToMethod()
        }
    }

private fun navigateToMethod() {
    // Start PaymentActivity
    val intent = Intent(this, PaymentMethodActivity::class.java)
    startActivity(intent)
}
}