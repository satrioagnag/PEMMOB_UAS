package com.example.projectuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PaymentActivity : AppCompatActivity() {

    private lateinit var movieImageView: ImageView
    private lateinit var movieTitleTextView: TextView
    private lateinit var totalPriceTextView: TextView
    private lateinit var serviceFeeTextView: TextView
    private lateinit var totalPaymentTextView: TextView
    private lateinit var btnPay: Button

    private val serviceFeeAmount = 5000 // Biaya layanan tetap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        findViewById<View>(R.id.btnBack).setOnClickListener {
            startActivity(Intent(this@PaymentActivity, SeatScreenActivity::class.java))
            finish()
        }
        // Initialize views
        movieImageView = findViewById(R.id.imageViewPoster)
        movieTitleTextView = findViewById(R.id.textViewTitle)
        totalPriceTextView = findViewById(R.id.totalPrice)
        serviceFeeTextView = findViewById(R.id.serviceFee)
        totalPaymentTextView = findViewById(R.id.totalPayment)
        btnPay = findViewById(R.id.btnPay)

        val movieTitle = intent.getStringExtra("movie_title")
        val movieImage = intent.getIntExtra("movie_image", 0)
        val totalPrice = intent.getIntExtra("total_price", 0)

        Log.d("PaymentActivity", "Received movieTitle: $movieTitle, movieImage: $movieImage, totalPrice: $totalPrice")

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

        // Calculate total payment
        val totalServiceFee = serviceFeeAmount
        val totalPaymentValue = totalPrice + totalServiceFee

        // Set the text views
        totalPriceTextView.text = "Rp$totalPrice"
        serviceFeeTextView.text = "Rp$totalServiceFee"
        totalPaymentTextView.text = "Rp$totalPaymentValue"

        // Set button click listener
        btnPay.setOnClickListener {
            navigateToMethod()
        }
    }

    private fun navigateToMethod() {
        // Start PaymentMethodActivity
        val intent = Intent(this, PaymentMethodActivity::class.java)
        startActivity(intent)
    }
}
