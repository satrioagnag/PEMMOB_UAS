package com.example.projectuas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InvoicePaymentActivity : AppCompatActivity() {
    private lateinit var movieImageView: ImageView
    private lateinit var movieTitleTextView: TextView
    private lateinit var totalPriceTextView: TextView
    private lateinit var serviceFeeTextView: TextView
    private lateinit var totalPaymentTextView: TextView

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

        // Get intent extras
        val movieTitle = intent.getStringExtra("movie_title")
        val movieImage = intent.getIntExtra("movie_image", 0)
        val totalPrice = intent.getIntExtra("total_price", 0)

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

        val nextOrder = findViewById<Button>(R.id.btn_back)
        nextOrder.setOnClickListener {
            navigateToSuccess()
        }
    }

    private fun navigateToSuccess() {
        val intent = Intent(this, ActivitySnack::class.java)
        startActivity(intent)
    }
}
