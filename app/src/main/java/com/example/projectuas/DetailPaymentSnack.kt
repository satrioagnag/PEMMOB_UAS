package com.example.projectuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class DetailPaymentSnack : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_payment_snack)

        val NextOrder = findViewById<Button>(R.id.btnPay)
        NextOrder.setOnClickListener {
            navigateToSuccess()
        }
    }

    private fun navigateToSuccess() {
        val intent = Intent(this, PaymentMethodActivity2::class.java)
        startActivity(intent)
    }
}
