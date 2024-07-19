package com.rapidor.shoppingmart.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.rapidor.shoppingmart.R
import com.rapidor.shoppingmart.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
       setContentView(binding.root)

       supportActionBar?.hide()

       val navHostFragment =
           supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
       navController = navHostFragment.findNavController()

       binding.bottomNavigationView.apply {
           setupWithNavController(navController)
       }

       navController.addOnDestinationChangedListener { _, destination, _ ->

           when (destination.id) {
               R.id.homeFragment -> {
                   binding.bottomNavigationView.visibility = View.VISIBLE
               }
               R.id.addToCartFragment -> {
                   binding.bottomNavigationView.visibility = View.VISIBLE
               }

               else -> {
                   binding.bottomNavigationView.visibility = View.INVISIBLE
               }
           }
       }
    }
}