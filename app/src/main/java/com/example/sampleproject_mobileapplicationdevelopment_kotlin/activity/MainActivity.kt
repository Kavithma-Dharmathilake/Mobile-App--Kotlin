package com.example.sampleproject_mobileapplicationdevelopment_kotlin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.sampleproject_mobileapplicationdevelopment_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener(View.OnClickListener{
            val intent = Intent(this@MainActivity, ExpenseHome::class.java)
            startActivity(intent)
            finish()
        })

    }


}

