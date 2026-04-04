package com.example.foodapp_kotlin.local.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.foodapp_kotlin.local.entity.Category
import com.example.foodapp_kotlin.local.entity.Recipe
import com.example.foodapp_kotlin.local.entity.RecipeCategoryCrossRef

data class CategoryWithRecipes(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = RecipeCategoryCrossRef::class,
            parentColumn = "categoryId",
            entityColumn = "recipeId"
        )
    )
    val recipes: List<Recipe>
)