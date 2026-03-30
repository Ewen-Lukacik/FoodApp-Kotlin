package com.example.foodapp_kotlin.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val time: Int,
    val difficulty: Int,
    val image: String,
    val price: Int = 0
)