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

class PaymentMethodActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_method2)

        val rbDana2: RadioButton = findViewById(R.id.rb_dana2)
        val rbBni2: RadioButton = findViewById(R.id.rb_bni2)

        setRadioButtonDrawableSize(rbDana2, R.drawable.ic_dana, 150, 150)
        setRadioButtonDrawableSize(rbBni2, R.drawable.ic_bni, 150, 150)

        val NextOrder = findViewById<Button>(R.id.btn_pay_order2)
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
        // Start PaymentActivity
        val intent = Intent(this, PaymentSnackSuccessActivity::class.java)
        startActivity(intent)
    }
}
