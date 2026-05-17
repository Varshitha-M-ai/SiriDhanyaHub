package com.example.siridhanyahub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val mandiCard = findViewById<CardView>(R.id.cardMandi)

        mandiCard.setOnClickListener {
            startActivity(Intent(this, MandiActivity::class.java))
        }

        val recipeCard = findViewById<CardView>(R.id.cardRecipe)

        recipeCard.setOnClickListener {
            startActivity(Intent(this, RecipeActivity::class.java))
        }

        val healthCard = findViewById<CardView>(R.id.cardHealth)

        healthCard.setOnClickListener {
            startActivity(Intent(this, HealthActivity::class.java))
        }

        val buyCard = findViewById<CardView>(R.id.cardBuy)

        buyCard.setOnClickListener {
            startActivity(Intent(this, DirectBuyActivity::class.java))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}