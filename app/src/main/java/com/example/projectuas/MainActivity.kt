package com.example.projectuas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.user).setOnClickListener {
            startActivity(Intent(this@MainActivity, SignUpActivity::class.java))
            finish()
        }
        findViewById<View>(R.id.admin).setOnClickListener {
            startActivity(Intent(this@MainActivity, SignUpActivity::class.java))
            finish()
        }
    }
}