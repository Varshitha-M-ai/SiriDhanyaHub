package com.example.siridhanyahub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DirectBuyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_direct_buy)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}