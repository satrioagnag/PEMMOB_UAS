package com.example.projectuas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        findViewById<View>(R.id.sign_up_button).setOnClickListener { // Handle sign up logic here
            // For example, navigate to MainActivity
            startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
            finish()
        }
        findViewById<View>(R.id.sign_in_text).setOnClickListener { // Navigate to Sign In Activity
            startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
        }
    }
}