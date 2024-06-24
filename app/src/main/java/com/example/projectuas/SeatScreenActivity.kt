package com.example.projectuas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity

class SeatScreenActivity : AppCompatActivity() {

    private lateinit var gridLayout: GridLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_screen)

        // Find the next button and set click listener
        val btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener {
            navigateToPayment()
        }
    }

    private fun navigateToPayment() {
        // Start PaymentActivity
        val intent = Intent(this, PaymentActivity::class.java)
        startActivity(intent)
    }
}
