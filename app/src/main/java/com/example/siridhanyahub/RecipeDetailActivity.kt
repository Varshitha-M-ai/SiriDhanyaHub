package com.example.siridhanyahub

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class RecipeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val image = findViewById<ImageView>(R.id.detailImage)
        val title = findViewById<TextView>(R.id.detailTitle)
        val steps = findViewById<TextView>(R.id.detailSteps)
        val saveBtn = findViewById<Button>(R.id.btnSave)

        val recipeTitle = intent.getStringExtra("title")
        val recipeSteps = intent.getStringExtra("steps")
//        val recipeImage = intent.getStringExtra("image")
        val recipeImage = intent.getIntExtra("image", 0)

        title.text = recipeTitle
        steps.text = recipeSteps

//        Glide.with(this)
//            .load(recipeImage)
//            .into(image)
        image.setImageResource(recipeImage)

        saveBtn.setOnClickListener {

            val sharedPref = getSharedPreferences("Favorites", Context.MODE_PRIVATE)

            with(sharedPref.edit()) {
                putString("savedRecipe", recipeTitle)
                apply()
            }

            Toast.makeText(this, "Recipe Saved!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}