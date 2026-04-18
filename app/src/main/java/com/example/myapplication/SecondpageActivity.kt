package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.myapplication.databinding.ActivitySecondpageBinding

class SecondpageActivity : AppCompatActivity()  {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySecondpageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondpageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}