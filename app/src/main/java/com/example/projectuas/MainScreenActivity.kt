package com.example.projectuas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainScreenActivity : AppCompatActivity() {

    private lateinit var nowPlayingRecyclerView: RecyclerView
    private lateinit var comingSoonRecyclerView: RecyclerView
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        nowPlayingRecyclerView = findViewById(R.id.now_playing_recyclerview)
        comingSoonRecyclerView = findViewById(R.id.coming_soon_recyclerview)
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        // Set up RecyclerViews
        nowPlayingRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        comingSoonRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Set up Adapters for RecyclerViews
        val nowPlayingAdapter = MovieAdapter(getNowPlayingMovies(), this)
        val comingSoonAdapter = MovieAdapter(getComingSoonMovies(), this)

        nowPlayingRecyclerView.adapter = nowPlayingAdapter
        comingSoonRecyclerView.adapter = comingSoonAdapter

        // Handle BottomNavigationView item clicks
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(this, MainScreenActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_snack -> {
                    val intent = Intent(this, Snack::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_history -> {
                    val intent = Intent(this, HistoryActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun getNowPlayingMovies(): List<Movie> {
        return listOf(
            Movie("Toy Story", R.drawable.toy_story),
            Movie("Trolls", R.drawable.trolls),
            Movie("Frozen", R.drawable.frozen)
            // Add more movies here
        )
    }

    private fun getComingSoonMovies(): List<Movie> {
        return listOf(
            Movie("A Bug's Life", R.drawable.bugs_life),
            Movie("Finding Nemo", R.drawable.finding_nemo),
            Movie("Guardians of the Galaxy", R.drawable.guardians_of_the_galaxy)
            // Add more movies here
        )
    }
}
