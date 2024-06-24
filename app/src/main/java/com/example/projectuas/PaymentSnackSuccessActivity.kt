package com.example.projectuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class PaymentSnackSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_snack_success)

        val NextOrder = findViewById<Button>(R.id.btn_print_e_ticket)
        NextOrder.setOnClickListener {
            navigateToSuccess()
        }
    }

    private fun navigateToSuccess() {
        val intent = Intent(this, InvoiceSnackActivity::class.java)
        startActivity(intent)
    }
}