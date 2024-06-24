package com.example.projectuas

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class SeatScreenActivity : AppCompatActivity() {
    private lateinit var seatButtons: List<Button>
    private lateinit var ticketCountTextView: TextView
    private lateinit var totalPriceTextView: TextView
    private var selectedSeats = mutableSetOf<Button>()
    private val seatPrice = 40000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_screen)

        val btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener {
            navigateToPayment()
        }

        // Inisialisasi ID kursi
        seatButtons = listOf(
            findViewById(R.id.seat1),
            findViewById(R.id.seat2),
            findViewById(R.id.seat3),
            findViewById(R.id.seat4),
            findViewById(R.id.seat5),
            findViewById(R.id.seat6),
            findViewById(R.id.seat7),
            findViewById(R.id.seat8),
            findViewById(R.id.seat9),
            findViewById(R.id.seat10),
            findViewById(R.id.seat11),
            findViewById(R.id.seat12),
            findViewById(R.id.seat13),
            findViewById(R.id.seat14),
            findViewById(R.id.seat15),
            findViewById(R.id.seat16),
            findViewById(R.id.seat17),
            findViewById(R.id.seat18),
            findViewById(R.id.seat19),
            findViewById(R.id.seat20),
            findViewById(R.id.seat21),
            findViewById(R.id.seat22),
            findViewById(R.id.seat23),
            findViewById(R.id.seat24),
            findViewById(R.id.seat25),
            findViewById(R.id.seat26),
            findViewById(R.id.seat27),
            findViewById(R.id.seat28),
            findViewById(R.id.seat29),
            findViewById(R.id.seat30),
            findViewById(R.id.seat31),
            findViewById(R.id.seat32),
            findViewById(R.id.seat33),
            findViewById(R.id.seat34),
            findViewById(R.id.seat35),
        )

        ticketCountTextView = findViewById(R.id.ticketCount)
        totalPriceTextView = findViewById(R.id.totalPrice)

        seatButtons.forEach { seat ->
            seat.setOnClickListener { handleSeatClick(seat) }
        }
    }

    private fun handleSeatClick(seat: Button) {
        val yourSeatDrawable: Drawable? = ContextCompat.getDrawable(this, R.drawable.seat_yourseat)
        val availableSeatDrawable: Drawable? = ContextCompat.getDrawable(this, R.drawable.seat_available)

        if (selectedSeats.contains(seat)) {
            selectedSeats.remove(seat)
            seat.background = availableSeatDrawable
        } else {
            selectedSeats.add(seat)
            seat.background = yourSeatDrawable
        }
        updateSeatInfo()
    }

    private fun updateSeatInfo() {
        val ticketCount = selectedSeats.size
        val totalPrice = ticketCount * seatPrice

        ticketCountTextView.text = "$ticketCount Ticket"
        totalPriceTextView.text = "Rp$totalPrice"
    }

    private fun navigateToPayment() {
        val intent = Intent(this, PaymentActivity::class.java)
        startActivity(intent)
    }
}
