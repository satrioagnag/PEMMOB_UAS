package com.example.projectuas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivitySnack : AppCompatActivity() {

    private lateinit var drinksRecyclerView: RecyclerView
    private lateinit var packagesRecyclerView: RecyclerView
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack)

        drinksRecyclerView = findViewById(R.id.drinks_recyclerview)
        packagesRecyclerView = findViewById(R.id.packages_recyclerview)
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        drinksRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        packagesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val drinksAdapter = SnackAdapter(getDrinks(), this)
        val packagesAdapter = SnackAdapter(getPackages(), this)

        drinksRecyclerView.adapter = drinksAdapter
        packagesRecyclerView.adapter = packagesAdapter

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

    private fun getDrinks(): List<Snack> {
        return listOf(
            Snack("Chocolate", R.drawable.chocolate, "Rp30.000"),
            Snack("Ice Tea", R.drawable.ice_tea, "Rp15.000"),
            Snack("Matcha Latte", R.drawable.matcha_latte, "Rp30.000")
        )
    }

    private fun getPackages(): List<Snack> {
        return listOf(
            Snack("Date Pack", R.drawable.date_pack, "Rp100.000"),
            Snack("Kenyang Pack", R.drawable.kenyang_pack, "Rp110.000"),
            Snack("Lite Pack", R.drawable.lite_pack, "Rp70.000")
        )
    }
}
