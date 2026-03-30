package com.example.foodapp_kotlin.local.dao

import androidx.room.*
import com.example.foodapp_kotlin.local.entity.Ingredient
import com.example.foodapp_kotlin.local.relation.IngredientWithRecipes

@Dao
interface IngredientDao {

    // Insert a ingredient
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIngredient(ingredient: Ingredient)

    // Insert a recipe-ingredient connection
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipeIngredientCrossRef(crossRef: com.example.foodapp_kotlin.local.entity.RecipeIngredientCrossRef)

    // Collect all the ingredients
    @Query("SELECT * FROM Ingredient")
    suspend fun getAllIngredients(): List<Ingredient>

    // Collect an ingredient with its recipes
    @Transaction
    @Query("SELECT * FROM Ingredient")
    suspend fun getIngredientsWithRecipes(): List<IngredientWithRecipes>
}