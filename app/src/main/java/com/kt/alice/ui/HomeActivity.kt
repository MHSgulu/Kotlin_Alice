package com.kt.alice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kt.alice.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding :ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}