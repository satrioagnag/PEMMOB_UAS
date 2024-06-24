package com.example.projectuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val Next1 = findViewById<Button>(R.id.btnNext)
        Next1.setOnClickListener {
            navigateToMethod()
        }
    }

private fun navigateToMethod() {
    // Start PaymentActivity
    val intent = Intent(this, PaymentMethodActivity::class.java)
    startActivity(intent)
}
}