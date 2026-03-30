package com.example.foodapp_kotlin.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.foodapp_kotlin.local.entity.Recipe
import com.example.foodapp_kotlin.local.entity.RecipeCategoryCrossRef
import com.example.foodapp_kotlin.local.relation.RecipeWithCategories
import com.example.foodapp_kotlin.local.relation.IngredientWithRecipes


@Dao
interface RecipeDao {

    // Insert a recipe
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: Recipe)

    // Insert a recipe-category connection
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipeCategoryCrossRef(crossRef: RecipeCategoryCrossRef)

    // Recover all the recipes
    @Query("SELECT * FROM Recipe")
    suspend fun getAllRecipes(): List<Recipe>

    // Recover a recipe with its categories
    @Transaction
    @Query("SELECT * FROM Recipe")
    suspend fun getRecipesWithCategories(): List<RecipeWithCategories>

    // Recover a recipe with its ingredients
    @Transaction
    @Query("SELECT * FROM Recipe")
    suspend fun getRecipesWithIngredients(): List<IngredientWithRecipes>
}