package com.example.projectuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PaymentSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_success)
        val btnNext = findViewById<Button>(R.id.btn_print_e_ticket)
        btnNext.setOnClickListener {
            navigateToHome()
        }
    }

    private fun navigateToHome() {
        // Start PaymentActivity
        val intent = Intent(this, MainScreenActivity::class.java)
        startActivity(intent)
    }
}