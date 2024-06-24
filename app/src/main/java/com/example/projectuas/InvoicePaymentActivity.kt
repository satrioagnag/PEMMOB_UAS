package com.example.projectuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class InvoicePaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invoice_payment)

        findViewById<View>(R.id.btn_pay_order).setOnClickListener {
            startActivity(Intent(this@InvoicePaymentActivity, ActivitySnack::class.java))
            finish()
        }
    }
}