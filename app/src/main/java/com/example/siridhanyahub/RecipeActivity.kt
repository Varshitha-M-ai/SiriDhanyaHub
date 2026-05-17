package com.example.siridhanyahub

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecipeActivity : AppCompatActivity() {

    private lateinit var adapter: RecipeAdapter
    private lateinit var recipeList: List<Recipe>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerRecipe)
        val search = findViewById<EditText>(R.id.searchRecipe)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recipeList = listOf(

                        Recipe(
                            "Navane Pongal",
                            "Healthy millet breakfast rich in fiber",
                            R.drawable.navane_pongal,
                            """
            Ingredients:
            - 1 cup navane millet
            - 1/2 cup moong dal
            - Pepper, cumin, ginger
            - Ghee and curry leaves
            
            Steps:
            1. Wash millet and dal.
            2. Pressure cook with water.
            3. Prepare seasoning with spices.
            4. Mix everything well.
            5. Serve hot with chutney.
                    """.trimIndent()
                        ),

                        Recipe(
                            "Ragi Dosa",
                            "Traditional crispy dosa rich in calcium",
                            R.drawable.ragi_dosa,
                            """
            Ingredients:
            - Ragi flour
            - Rice flour
            - Onion and green chilli
            - Salt and water
            
            Steps:
            1. Mix all ingredients.
            2. Prepare smooth batter.
            3. Pour on hot tawa.
            4. Cook until crispy.
            5. Serve with chutney.
                    """.trimIndent()
                        ),

                        Recipe(
                            "Sajje Roti",
                            "Soft millet roti for healthy meals",
                            R.drawable.sajje_roti,
                            """
            Ingredients:
            - Sajje flour
            - Warm water
            - Salt
            
            Steps:
            1. Prepare soft dough.
            2. Flatten into roti.
            3. Cook on hot pan.
            4. Apply little ghee.
            5. Serve hot with curry.
                    """.trimIndent()
                        )
        )

        adapter = RecipeAdapter(recipeList)

        recyclerView.adapter = adapter

        search.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                filterRecipes(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun filterRecipes(text: String) {

        val filteredList = recipeList.filter {

            it.title.contains(text, ignoreCase = true)
        }

        adapter.filterList(filteredList)
    }
}