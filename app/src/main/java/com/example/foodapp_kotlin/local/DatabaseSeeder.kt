package com.example.foodapp_kotlin.local

import com.example.foodapp_kotlin.local.database.AppDatabase
import com.example.foodapp_kotlin.local.entity.*

object DatabaseSeeder {
    suspend fun seedDatabase(db: AppDatabase) {
        val recipeDao = db.recipeDao()
        val categoryDao = db.categoryDao()
        val ingredientDao = db.ingredientDao()

        // Check if already seeded
        if (categoryDao.getAllCategories().isNotEmpty()) return

        // 1. Insert Categories
        val categories = listOf(
            Category(id = 1, name = "Italien", description = "Plats traditionnels italiens"),
            Category(id = 2, name = "Pizza", description = "Toutes sortes de pizzas"),
            Category(id = 3, name = "Burger", description = "Burgers gourmets"),
            Category(id = 4, name = "Salade", description = "Fraîcheur et santé"),
            Category(id = 5, name = "Dessert", description = "Douceurs sucrées")
        )
        categories.forEach { categoryDao.insertCategory(it) }

        // 2. Insert Ingredients
        val ingredients = listOf(
            Ingredient(id = 1, name = "Pâtes", price = 2, type = "Base"),
            Ingredient(id = 2, name = "Tomate", price = 1, type = "Légume"),
            Ingredient(id = 3, name = "Fromage", price = 3, type = "Laitage"),
            Ingredient(id = 4, name = "Basilic", price = 1, type = "Herbe"),
            Ingredient(id = 5, name = "Lardons", price = 4, type = "Viande"),
            Ingredient(id = 6, name = "Steak haché", price = 5, type = "Viande"),
            Ingredient(id = 7, name = "Pain Burger", price = 2, type = "Base"),
            Ingredient(id = 8, name = "Poulet", price = 5, type = "Viande"),
            Ingredient(id = 9, name = "Laitue", price = 1, type = "Légume")
        )
        ingredients.forEach { ingredientDao.insertIngredient(it) }

        // 3. Insert Recipes
        val recipes = listOf(
            Recipe(id = 1, name = "Pâtes Carbonara", description = "Les vraies carbonara italiennes", time = 25, difficulty = 2, image = "", price = 12),
            Recipe(id = 2, name = "Pizza Margherita", description = "La reine des pizzas", time = 20, difficulty = 1, image = "", price = 10),
            Recipe(id = 3, name = "Cheeseburger", description = "Burger classique avec beaucoup de fromage", time = 15, difficulty = 2, image = "", price = 14),
            Recipe(id = 4, name = "Salade César", description = "La célèbre salade au poulet", time = 15, difficulty = 1, image = "", price = 11)
        )
        recipes.forEach { recipeDao.insertRecipe(it) }

        // 4. Connect Recipes to Categories
        val recipeCategoryLinks = listOf(
            RecipeCategoryCrossRef(1, 1), // Carbonara -> Italien
            RecipeCategoryCrossRef(2, 1), // Margherita -> Italien
            RecipeCategoryCrossRef(2, 2), // Margherita -> Pizza
            RecipeCategoryCrossRef(3, 3), // Burger -> Burger
            RecipeCategoryCrossRef(4, 4)  // Salade -> Salade
        )
        recipeCategoryLinks.forEach { recipeDao.insertRecipeCategoryCrossRef(it) }

        // 5. Connect Recipes to Ingredients
        val recipeIngredientLinks = listOf(
            RecipeIngredientCrossRef(1, 1), // Carbonara -> Pâtes
            RecipeIngredientCrossRef(1, 5), // Carbonara -> Lardons
            RecipeIngredientCrossRef(1, 3), // Carbonara -> Fromage
            RecipeIngredientCrossRef(2, 2), // Margherita -> Tomate
            RecipeIngredientCrossRef(2, 3), // Margherita -> Fromage
            RecipeIngredientCrossRef(2, 4), // Margherita -> Basilic
            RecipeIngredientCrossRef(3, 7), // Burger -> Pain
            RecipeIngredientCrossRef(3, 6), // Burger -> Steak
            RecipeIngredientCrossRef(3, 3), // Burger -> Fromage
            RecipeIngredientCrossRef(4, 9), // Salade -> Laitue
            RecipeIngredientCrossRef(4, 8)  // Salade -> Poulet
        )
        recipeIngredientLinks.forEach { ingredientDao.insertRecipeIngredientCrossRef(it) }
    }
}
