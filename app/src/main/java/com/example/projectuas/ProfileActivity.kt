package com.example.projectuas


import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

    private lateinit var profilePicture: ImageView
    private lateinit var userName: TextView
    private lateinit var email: TextView
    private lateinit var logout: LinearLayout
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        profilePicture = findViewById(R.id.profile_picture)
        userName = findViewById(R.id.user_name)
        email = findViewById(R.id.email)
        logout = findViewById(R.id.logout)
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        // Handle logout click
        logout.setOnClickListener {
            showLogoutDialog()
        }

        // Bottom navigation item click handling
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Handle home action
                    true
                }
                R.id.navigation_snack -> {
                    // Handle snack action
                    true
                }
                R.id.navigation_history -> {
                    // Handle history action
                    true
                }
                R.id.navigation_profile -> {
                    // Handle profile action
                    true
                }
                else -> false
            }
        }
    }

    private fun showLogoutDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_logout_confirmation, null)
        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        val btnNo = dialogView.findViewById<Button>(R.id.btn_no)
        val btnYes = dialogView.findViewById<Button>(R.id.btn_yes)

        btnNo.setOnClickListener {
            dialog.dismiss()
        }

        btnYes.setOnClickListener {
            // Handle logout action
            Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
            finish()
        }

        dialog.show()
    }
}