package com.example.foodapp_kotlin.local.dao

import androidx.room.*
import com.example.foodapp_kotlin.local.entity.Category
import com.example.foodapp_kotlin.local.entity.RecipeCategoryCrossRef
import com.example.foodapp_kotlin.local.relation.CategoryWithRecipes

@Dao
interface CategoryDao {

    // Insert a category
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

    // Insert a recipe-category connection
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipeCategoryCrossRef(crossRef: RecipeCategoryCrossRef)

    // Recover all the categories
    @Query("SELECT * FROM Category")
    suspend fun getAllCategories(): List<Category>

    // Recover a category with its recipes
    @Transaction
    @Query("SELECT * FROM Category")
    suspend fun getCategoriesWithRecipes(): List<CategoryWithRecipes>
}