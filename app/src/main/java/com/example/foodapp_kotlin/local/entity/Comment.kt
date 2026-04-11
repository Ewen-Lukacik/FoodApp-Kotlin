package com.example.foodapp_kotlin.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Comment(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val recipeId: Int,
    val userId: Int,
    val authorName: String,
    val content: String,
    val createdAt: Long = System.currentTimeMillis()
)

