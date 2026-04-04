package com.example.foodapp_kotlin.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.foodapp_kotlin.local.entity.Recipe
import com.example.foodapp_kotlin.local.entity.RecipeCategoryCrossRef
import com.example.foodapp_kotlin.local.relation.RecipeWithCategories
import com.example.foodapp_kotlin.local.relation.RecipeWithIngredients


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

    @Query("SELECT Recipe.* FROM Recipe INNER JOIN RecipeCategoryCrossRef ON Recipe.id = RecipeCategoryCrossRef.recipeId WHERE RecipeCategoryCrossRef.categoryId = :categoryId")
    suspend fun getAllRecipesFromCategory(categoryId: Int): List<Recipe>

    // Recover a recipe with its categories
    @Transaction
    @Query("SELECT * FROM Recipe")
    suspend fun getRecipesWithCategories(): List<RecipeWithCategories>

    // Recover a recipe with its ingredients
    @Transaction
    @Query("SELECT * FROM Recipe")
    suspend fun getRecipesWithIngredients(): List<RecipeWithIngredients>

    // Recover a single recipe by ID
    @Query("SELECT * FROM Recipe WHERE id = :recipeId")
    suspend fun getRecipeById(recipeId: Int): Recipe?

    // Recover a single recipe with its ingredients
    @Transaction
    @Query("SELECT * FROM Recipe WHERE id = :recipeId")
    suspend fun getRecipeWithIngredients(recipeId: Int): RecipeWithIngredients?

    // Recover a single recipe with its categories
    @Transaction
    @Query("SELECT * FROM Recipe WHERE id = :recipeId")
    suspend fun getRecipeWithCategories(recipeId: Int): RecipeWithCategories?
}