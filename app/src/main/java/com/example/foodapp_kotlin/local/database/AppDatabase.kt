package com.example.foodapp_kotlin.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foodapp_kotlin.local.dao.*
import com.example.foodapp_kotlin.local.entity.*

@Database(
    entities = [
        Ingredient::class,
        Recipe::class,
        Category::class,
        RecipeIngredientCrossRef::class,
        RecipeCategoryCrossRef::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    // DAO for  ingredient
    abstract fun ingredientDao(): IngredientDao

    // DAO for recipe
    abstract fun recipeDao(): RecipeDao

    // DAO for category
    abstract fun categoryDao(): CategoryDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app-db")
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}