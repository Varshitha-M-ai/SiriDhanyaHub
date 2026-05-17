package com.example.siridhanyahub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MandiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mandi)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerMandi)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val mandiList = listOf(
            Mandi("Navane", "₹52/kg", "↑ Rising", "High: 55 | Low: 48"),
            Mandi("Sajje", "₹40/kg", "↓ Falling", "High: 44 | Low: 38"),
            Mandi("Baragu", "₹60/kg", "↑ Rising", "High: 65 | Low: 58"),
            Mandi("Ragi", "₹35/kg", "↑ Rising", "High: 39 | Low: 30")
        )

        recyclerView.adapter = MandiAdapter(mandiList)
    }
}