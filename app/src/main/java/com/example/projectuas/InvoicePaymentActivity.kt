package com.example.projectuas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class InvoicePaymentActivity : AppCompatActivity() {
    private lateinit var movieImageView: ImageView
    private lateinit var movieTitleTextView: TextView
    private lateinit var totalPriceTextView: TextView
    private lateinit var serviceFeeTextView: TextView
    private lateinit var totalPaymentTextView: TextView
    private lateinit var btn_back: Button

    private val serviceFeeAmount = 5000 // Fixed service fee

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invoice_payment)

        // Initialize views
        movieImageView = findViewById(R.id.ivPoster)
        movieTitleTextView = findViewById(R.id.movieTitle)
        totalPriceTextView = findViewById(R.id.totalPrice)
        serviceFeeTextView = findViewById(R.id.serviceFee)
        totalPaymentTextView = findViewById(R.id.totalPayment)
        btn_back = findViewById(R.id.btn_back)

        // Get intent extras
        val movieTitle = intent.getStringExtra("movie_title")
        val movieImage = intent.getIntExtra("movie_image", 0)
        val totalPrice = intent.getIntExtra("total_price", 0)
        val intent = Intent(this, InvoicePaymentActivity::class.java)
        intent.putExtra("movie_title", movieTitle)
        intent.putExtra("movie_image", movieImage)
        intent.putExtra("total_price", totalPrice)
        startActivity(intent)

        if (movieTitle != null) {
            movieTitleTextView.text = movieTitle
        }

        if (movieImage != 0) {
            movieImageView.setImageResource(movieImage)
        }

        val totalServiceFee = serviceFeeAmount
        val totalPaymentValue = totalPrice + totalServiceFee

        // Set the text views
        totalPriceTextView.text = "Rp$totalPrice"
        serviceFeeTextView.text = "Rp$totalServiceFee"
        totalPaymentTextView.text = "Rp$totalPaymentValue"

        btn_back.setOnClickListener {
            navigateToSnack()
        }
    }

    private fun navigateToSnack() {
        startActivity(Intent(this@InvoicePaymentActivity, ActivitySnack::class.java))
    }
}
