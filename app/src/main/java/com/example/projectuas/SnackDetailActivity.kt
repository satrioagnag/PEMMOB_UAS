package com.example.projectuas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SnackDetailActivity : AppCompatActivity() {

    private lateinit var backButton: ImageView
    private lateinit var decreaseButton: Button
    private lateinit var increaseButton: Button
    private lateinit var quantityText: TextView
    private lateinit var noteEditText: EditText
    private lateinit var totalText: TextView
    private lateinit var payButton: Button

    private var quantity = 3
    private val pricePerPack = 110000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack_detail)

        backButton = findViewById(R.id.back_button2)
        decreaseButton = findViewById(R.id.decrease_button)
        increaseButton = findViewById(R.id.increase_button)
        quantityText = findViewById(R.id.quantity_text)
        noteEditText = findViewById(R.id.note_edit_text)
        totalText = findViewById(R.id.total_text)
        payButton = findViewById(R.id.sign_up_button)

        // Set initial quantity and total price
        updateQuantity()
        updateTotalPrice()

        backButton.setOnClickListener {
            onBackPressed()
        }

        decreaseButton.setOnClickListener {
            if (quantity > 1) {
                quantity--
                updateQuantity()
                updateTotalPrice()
            }
        }

        increaseButton.setOnClickListener {
            quantity++
            updateQuantity()
            updateTotalPrice()
        }

        payButton.setOnClickListener {
            val intent = Intent(this, DetailPaymentSnack::class.java)
            startActivity(intent)
        }
    }

    private fun updateQuantity() {
        quantityText.text = quantity.toString()
    }

    private fun updateTotalPrice() {
        val totalPrice = quantity * pricePerPack
        totalText.text = "Rp.$totalPrice"
    }
}
