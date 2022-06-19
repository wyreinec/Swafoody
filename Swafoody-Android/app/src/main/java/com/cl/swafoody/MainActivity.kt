package com.cl.swafoody

add_ingredients
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cl.swafoody.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.cl.swafoody.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

master
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
add_ingredients
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intentToAddIngredient()
    }

    private fun intentToAddIngredient() {
        binding.apply {
            btnIntent.setOnClickListener {
                val intent = Intent(this@MainActivity, AddIngredientsActivity::class.java)
                startActivity(intent)
            }
        }


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
master
    }
}