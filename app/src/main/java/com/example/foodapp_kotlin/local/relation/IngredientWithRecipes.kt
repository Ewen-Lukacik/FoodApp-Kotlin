package com.example.foodapp_kotlin.local.relation


import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.foodapp_kotlin.local.entity.Ingredient
import com.example.foodapp_kotlin.local.entity.Recipe
import com.example.foodapp_kotlin.local.entity.RecipeIngredientCrossRef

data class IngredientWithRecipes(
    @Embedded val ingredient: Ingredient,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(RecipeIngredientCrossRef::class)
    )
    val recipes: List<Recipe>
)