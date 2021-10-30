package com.emranul.dashboardui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.emranul.dashboardui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val eAdapter = AdapterExplore()


        binding.recyclerBestRating.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = eAdapter
        }


        binding.recyclerPopular.apply {
            layoutManager = CustomLinearLayoutManager(context)
            adapter = eAdapter
        }

        binding.recyclerSuperHost.apply {
            layoutManager =  CustomLinearLayoutManager(context)
            adapter = eAdapter
        }

        binding.recyclerBestRating.apply {
            layoutManager =  CustomLinearLayoutManager(context)
            adapter = eAdapter
        }

    }
}