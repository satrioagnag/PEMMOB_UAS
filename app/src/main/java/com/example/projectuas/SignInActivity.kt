package com.example.projectuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        findViewById<View>(R.id.sign_up_button).setOnClickListener {
            startActivity(Intent(this@SignInActivity, MainScreenActivity::class.java))
            finish()
        }
    }
}