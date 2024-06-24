package com.example.projectuas

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

class PaymentMethodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_method)

        val rbDana: RadioButton = findViewById(R.id.rb_dana)
        val rbBni: RadioButton = findViewById(R.id.rb_bni)

        setRadioButtonDrawableSize(rbDana, R.drawable.ic_dana, 150, 150)
        setRadioButtonDrawableSize(rbBni, R.drawable.ic_bni, 150, 150)

        val NextOrder = findViewById<Button>(R.id.btn_pay_order)
        NextOrder.setOnClickListener {
            navigateToSuccess()
        }
    }

    private fun setRadioButtonDrawableSize(radioButton: RadioButton, drawableId: Int, width: Int, height: Int) {
        val drawable: Drawable? = ContextCompat.getDrawable(this, drawableId)
        drawable?.let {
            val wrappedDrawable = DrawableCompat.wrap(it)
            val scaledDrawable = wrappedDrawable.mutate()
            scaledDrawable.setBounds(0, 0, width, height)
            radioButton.setCompoundDrawables(scaledDrawable, null, null, null)
        }
    }
    private fun navigateToSuccess() {

        val totalPrice = updateSeatInfo()

        val intent = Intent(this, InvoicePaymentActivity::class.java)
        intent.putExtra("total_price", totalPrice)
        startActivity(intent)
    }

    private fun updateSeatInfo(): Int {

        return 80000
    }

}
