package com.example.foodapp_kotlin.local.entity

import androidx.room.Entity

@Entity(primaryKeys = ["recipeId", "categoryId"])
data class RecipeCategoryCrossRef(
    val recipeId: Int,
    val categoryId: Int
)