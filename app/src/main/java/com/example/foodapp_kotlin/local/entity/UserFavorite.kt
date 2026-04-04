package com.example.foodapp_kotlin.local.entity

import androidx.room.Entity

@Entity(primaryKeys = ["userId", "recipeId"])
data class UserFavorite(
    val userId: Int,
    val recipeId: Int
)
