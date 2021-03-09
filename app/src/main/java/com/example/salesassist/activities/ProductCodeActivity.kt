package com.example.salesassist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.salesassist.R

class ProductCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_product_code)
    }
}