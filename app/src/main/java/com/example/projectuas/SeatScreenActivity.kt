package com.example.projectuas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class SeatScreenActivity : AppCompatActivity() {

    private lateinit var gridLayout: GridLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_screen)

        gridLayout = findViewById(R.id.seatGridLayout)
        setupSeatButtons()

        val btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener {
            navigateToPayment()
        }
    }

    private fun setupSeatButtons() {
        for (i in 0 until gridLayout.childCount) {
            val button = gridLayout.getChildAt(i) as Button
            button.setOnClickListener {
                toggleSeatSelection(button)
            }
        }
    }

    private fun toggleSeatSelection(button: Button) {
        // Implement logic to toggle seat selection here
        val currentBackground = button.background.constantState
        val availableBackground = resources.getDrawable(R.drawable.seat_available, null).constantState
        val bookedBackground = resources.getDrawable(R.drawable.seat_booked, null).constantState

        if (currentBackground == availableBackground) {
            button.setBackgroundResource(R.drawable.seat_yourseat)
        } else if (currentBackground == bookedBackground) {
            Toast.makeText(this, "Seat already booked", Toast.LENGTH_SHORT).show()
        } else {
            button.setBackgroundResource(R.drawable.seat_available)
        }
    }
    private fun navigateToPayment() {
        // Start PaymentActivity
        val intent = Intent(this, PaymentActivity::class.java)
        startActivity(intent)
    }
}
