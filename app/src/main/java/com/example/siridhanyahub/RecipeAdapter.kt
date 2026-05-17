package com.example.siridhanyahub

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecipeAdapter(private var recipeList: List<Recipe>) :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image = itemView.findViewById<ImageView>(R.id.imgRecipe)
        val title = itemView.findViewById<TextView>(R.id.txtRecipeTitle)
        val desc = itemView.findViewById<TextView>(R.id.txtRecipeDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)

        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {

        val recipe = recipeList[position]

        holder.title.text = recipe.title
        holder.desc.text = recipe.description

//        Glide.with(holder.itemView.context)
//            .load(recipe.imageUrl)
//            .into(holder.image)
        holder.image.setImageResource(recipe.imageResId)

        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, RecipeDetailActivity::class.java)

            intent.putExtra("title", recipe.title)
            intent.putExtra("steps", recipe.steps)
//            intent.putExtra("image", recipe.imageUrl)
            intent.putExtra("image", recipe.imageResId)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    fun filterList(filteredList: List<Recipe>) {
        recipeList = filteredList
        notifyDataSetChanged()
    }
}