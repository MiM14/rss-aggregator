package com.example.rss_aggregator_2022

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.rss_aggregator_2022.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setUpNavigation()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }

    private fun setUpNavigation(){
        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemReselectedListener {
            when(it.itemId){
                R.id.to_rss_feed_item -> findNavController(R.id.main_fragment_view).navigate(R.id.feed)
                R.id.to_rss_manager_item-> findNavController(R.id.main_fragment_view).navigate(R.id.management)
                R.id.to_your_profile_item-> findNavController(R.id.main_fragment_view).navigate(R.id.profile)
            }
            true
        }
    }
}

