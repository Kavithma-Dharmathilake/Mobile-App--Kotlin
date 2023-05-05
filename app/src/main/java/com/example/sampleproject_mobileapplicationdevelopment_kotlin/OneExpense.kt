package com.example.sampleproject_mobileapplicationdevelopment_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.sampleproject_mobileapplicationdevelopment_kotlin.databinding.ActivityOneExpenseBinding


class OneExpense : AppCompatActivity() {

    private lateinit var binding: ActivityOneExpenseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOneExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        if (bundle != null) {

            binding.editAmount.setText(bundle.getString("Amount"))
            binding.editName.setText(bundle.getString("name"))
            binding.editDate.setText(bundle.getString("Date"))
            val category = bundle.getString("Category")
            val categoryIndex = getCategoryIndex(category)
            binding.editExpCat.setSelection(categoryIndex)


        }

    }

    private fun getCategoryIndex(category: String?): Int {
        val adapter = binding.editExpCat.adapter
        for (i in 0 until adapter.count) {
            val item = adapter.getItem(i) as String
            if (item == category) {
                return i
            }
        }
        return 0
    }
}