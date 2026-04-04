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
            Category(id = 1, name = "Italien",  description = "Plats traditionnels italiens", image = "food_italian"),
            Category(id = 2, name = "Pizza",    description = "Toutes sortes de pizzas",      image = "food_pizza"),
            Category(id = 3, name = "Burger",   description = "Burgers gourmets",             image = "food_burger"),
            Category(id = 4, name = "Salade",   description = "Fraîcheur et santé",           image = "food_salade"),
            Category(id = 5, name = "Dessert",  description = "Douceurs sucrées",             image = "food_dessert")
        )
        categories.forEach { categoryDao.insertCategory(it) }

        // 2. Insert Ingredients
        val ingredients = listOf(
            Ingredient(id = 1,  name = "Pâtes",           price = 2, type = "Base"),
            Ingredient(id = 2,  name = "Tomate",          price = 1, type = "Légume"),
            Ingredient(id = 3,  name = "Fromage",         price = 3, type = "Laitage"),
            Ingredient(id = 4,  name = "Basilic",         price = 1, type = "Herbe"),
            Ingredient(id = 5,  name = "Lardons",         price = 4, type = "Viande"),
            Ingredient(id = 6,  name = "Steak haché",     price = 5, type = "Viande"),
            Ingredient(id = 7,  name = "Pain Burger",     price = 2, type = "Base"),
            Ingredient(id = 8,  name = "Poulet",          price = 5, type = "Viande"),
            Ingredient(id = 9,  name = "Laitue",          price = 1, type = "Légume"),
            Ingredient(id = 10, name = "Crème fraîche",   price = 2, type = "Laitage"),
            Ingredient(id = 11, name = "Oeuf",            price = 1, type = "Base"),
            Ingredient(id = 12, name = "Riz",             price = 1, type = "Base"),
            Ingredient(id = 13, name = "Aubergine",       price = 2, type = "Légume"),
            Ingredient(id = 14, name = "Courgette",       price = 2, type = "Légume"),
            Ingredient(id = 15, name = "Jambon",          price = 3, type = "Viande"),
            Ingredient(id = 16, name = "Champignons",     price = 2, type = "Légume"),
            Ingredient(id = 17, name = "Oignon",          price = 1, type = "Légume"),
            Ingredient(id = 18, name = "Avocat",          price = 2, type = "Légume"),
            Ingredient(id = 19, name = "Crevettes",       price = 6, type = "Poisson"),
            Ingredient(id = 20, name = "Farine",          price = 1, type = "Base"),
            Ingredient(id = 21, name = "Beurre",          price = 2, type = "Laitage"),
            Ingredient(id = 22, name = "Sucre",           price = 1, type = "Base"),
            Ingredient(id = 23, name = "Chocolat",        price = 3, type = "Base"),
            Ingredient(id = 24, name = "Fraises",         price = 3, type = "Fruit"),
            Ingredient(id = 25, name = "Mascarpone",      price = 4, type = "Laitage"),
            Ingredient(id = 26, name = "Café",            price = 2, type = "Base"),
            Ingredient(id = 27, name = "Saumon",          price = 7, type = "Poisson"),
            Ingredient(id = 28, name = "Mozzarella",      price = 3, type = "Laitage"),
            Ingredient(id = 29, name = "Pesto",           price = 3, type = "Sauce"),
            Ingredient(id = 30, name = "Bacon",           price = 4, type = "Viande")
        )
        ingredients.forEach { ingredientDao.insertIngredient(it) }

        // 3. Insert Recipes
        val recipes = listOf(
            // Italien (id 1–6)
            Recipe(id = 1,  name = "Pâtes Carbonara",         description = "Les vraies carbonara italiennes",        time = 25, difficulty = 2, image = "recipe_1",  price = 12, note = 4.8),
            Recipe(id = 2,  name = "Risotto aux champignons", description = "Risotto crémeux aux champignons",        time = 35, difficulty = 3, image = "recipe_2",  price = 13, note = 4.6),
            Recipe(id = 3,  name = "Lasagnes",                description = "Lasagnes à la bolognaise maison",        time = 60, difficulty = 3, image = "recipe_3",  price = 15, note = 4.9),
            Recipe(id = 4,  name = "Penne all'Arrabbiata",    description = "Pâtes épicées à la sauce tomate",       time = 20, difficulty = 1, image = "recipe_4",  price = 10, note = 4.3),
            Recipe(id = 5,  name = "Gnocchis au pesto",       description = "Gnocchis maison au pesto basilic",      time = 40, difficulty = 3, image = "recipe_5",  price = 14, note = 4.7),
            Recipe(id = 6,  name = "Tagliatelles au saumon",  description = "Tagliatelles crème et saumon fumé",     time = 20, difficulty = 2, image = "recipe_6",  price = 16, note = 4.5),

            // Pizza (id 7–12)
            Recipe(id = 7,  name = "Pizza Margherita",        description = "La reine des pizzas",                   time = 20, difficulty = 1, image = "recipe_7",  price = 10, note = 4.4),
            Recipe(id = 8,  name = "Pizza Quatre Fromages",   description = "Pizza généreuse aux 4 fromages",        time = 25, difficulty = 2, image = "recipe_8",  price = 13, note = 4.8),
            Recipe(id = 9,  name = "Pizza Jambon-Champignons",description = "Classique indémodable",                 time = 25, difficulty = 1, image = "recipe_9",  price = 11, note = 4.2),
            Recipe(id = 10, name = "Pizza Pesto-Poulet",      description = "Pizza au pesto et poulet grillé",       time = 30, difficulty = 2, image = "recipe_10", price = 13, note = 4.6),
            Recipe(id = 11, name = "Pizza Végétarienne",      description = "Légumes grillés et mozzarella",         time = 25, difficulty = 1, image = "recipe_11", price = 11, note = 4.1),
            Recipe(id = 12, name = "Calzone",                 description = "Pizza pliée farcie au jambon",          time = 30, difficulty = 3, image = "recipe_12", price = 12, note = 4.7),

            // Burger (id 13–17)
            Recipe(id = 13, name = "Cheeseburger",            description = "Burger classique avec beaucoup de fromage", time = 15, difficulty = 2, image = "recipe_13", price = 14, note = 4.5),
            Recipe(id = 14, name = "Bacon Burger",            description = "Burger avec bacon croustillant",        time = 15, difficulty = 2, image = "recipe_14", price = 15, note = 4.8),
            Recipe(id = 15, name = "Chicken Burger",          description = "Burger au poulet croustillant",         time = 20, difficulty = 2, image = "recipe_15", price = 13, note = 4.3),
            Recipe(id = 16, name = "Burger Végétarien",       description = "Steak de légumes et avocat",            time = 20, difficulty = 2, image = "recipe_16", price = 12, note = 4.0),
            Recipe(id = 17, name = "Double Smash Burger",     description = "Double steak smashé façon fast-food",   time = 20, difficulty = 3, image = "recipe_17", price = 17, note = 4.9),

            // Salade (id 18–22)
            Recipe(id = 18, name = "Salade César",            description = "La célèbre salade au poulet",           time = 15, difficulty = 1, image = "recipe_18", price = 11, note = 4.6),
            Recipe(id = 19, name = "Salade Niçoise",          description = "Thon, tomates, oeufs et olives",        time = 15, difficulty = 1, image = "recipe_19", price = 10, note = 4.4),
            Recipe(id = 20, name = "Salade de Crevettes",     description = "Crevettes, avocat et agrumes",          time = 10, difficulty = 1, image = "recipe_20", price = 13, note = 4.7),
            Recipe(id = 21, name = "Salade Grecque",          description = "Concombre, tomate, feta et olives",     time = 10, difficulty = 1, image = "recipe_21", price = 9, note = 4.2),
            Recipe(id = 22, name = "Bowl Quinoa-Avocat",      description = "Bowl healthy au quinoa et avocat",      time = 15, difficulty = 1, image = "recipe_22", price = 12, note = 4.8),

            // Dessert (id 23–28)
            Recipe(id = 23, name = "Tiramisu",                description = "Le dessert italien incontournable",     time = 30, difficulty = 2, image = "recipe_23", price = 8, note = 4.9),
            Recipe(id = 24, name = "Fondant au chocolat",     description = "Cœur coulant au chocolat noir",        time = 20, difficulty = 2, image = "recipe_24", price = 7, note = 4.8),
            Recipe(id = 25, name = "Tarte aux fraises",       description = "Tarte fraîche et légère",               time = 45, difficulty = 3, image = "recipe_25", price = 9, note = 4.5),
            Recipe(id = 26, name = "Crème brûlée",            description = "Crème vanille et caramel croustillant", time = 40, difficulty = 3, image = "recipe_26", price = 8, note = 4.7),
            Recipe(id = 27, name = "Mousse au chocolat",      description = "Mousse aérienne au chocolat noir",      time = 20, difficulty = 2, image = "recipe_27", price = 6, note = 4.6),
            Recipe(id = 28, name = "Panna Cotta",             description = "Panna cotta vanille et coulis fraise",  time = 20, difficulty = 1, image = "recipe_28", price = 7, note = 4.4)
        )
        recipes.forEach { recipeDao.insertRecipe(it) }

        // 4. Connect Recipes to Categories
        val recipeCategoryLinks = listOf(
            // Italien
            RecipeCategoryCrossRef(1, 1),
            RecipeCategoryCrossRef(2, 1),
            RecipeCategoryCrossRef(3, 1),
            RecipeCategoryCrossRef(4, 1),
            RecipeCategoryCrossRef(5, 1),
            RecipeCategoryCrossRef(6, 1),
            // Pizza
            RecipeCategoryCrossRef(7,  2),
            RecipeCategoryCrossRef(8,  2),
            RecipeCategoryCrossRef(9,  2),
            RecipeCategoryCrossRef(10, 2),
            RecipeCategoryCrossRef(11, 2),
            RecipeCategoryCrossRef(12, 2),
            // Burger
            RecipeCategoryCrossRef(13, 3),
            RecipeCategoryCrossRef(14, 3),
            RecipeCategoryCrossRef(15, 3),
            RecipeCategoryCrossRef(16, 3),
            RecipeCategoryCrossRef(17, 3),
            // Salade
            RecipeCategoryCrossRef(18, 4),
            RecipeCategoryCrossRef(19, 4),
            RecipeCategoryCrossRef(20, 4),
            RecipeCategoryCrossRef(21, 4),
            RecipeCategoryCrossRef(22, 4),
            // Dessert
            RecipeCategoryCrossRef(23, 5),
            RecipeCategoryCrossRef(24, 5),
            RecipeCategoryCrossRef(25, 5),
            RecipeCategoryCrossRef(26, 5),
            RecipeCategoryCrossRef(27, 5),
            RecipeCategoryCrossRef(28, 5)
        )
        recipeCategoryLinks.forEach { recipeDao.insertRecipeCategoryCrossRef(it) }

        // 5. Connect Recipes to Ingredients (principaux seulement)
        val recipeIngredientLinks = listOf(
            // Carbonara
            RecipeIngredientCrossRef(1, 1), RecipeIngredientCrossRef(1, 5), RecipeIngredientCrossRef(1, 3), RecipeIngredientCrossRef(1, 11),
            // Risotto
            RecipeIngredientCrossRef(2, 12), RecipeIngredientCrossRef(2, 16), RecipeIngredientCrossRef(2, 10), RecipeIngredientCrossRef(2, 3),
            // Lasagnes
            RecipeIngredientCrossRef(3, 1), RecipeIngredientCrossRef(3, 6), RecipeIngredientCrossRef(3, 2), RecipeIngredientCrossRef(3, 3),
            // Penne Arrabbiata
            RecipeIngredientCrossRef(4, 1), RecipeIngredientCrossRef(4, 2), RecipeIngredientCrossRef(4, 17),
            // Gnocchis pesto
            RecipeIngredientCrossRef(5, 20), RecipeIngredientCrossRef(5, 29), RecipeIngredientCrossRef(5, 3),
            // Tagliatelles saumon
            RecipeIngredientCrossRef(6, 1), RecipeIngredientCrossRef(6, 27), RecipeIngredientCrossRef(6, 10),
            // Margherita
            RecipeIngredientCrossRef(7, 2), RecipeIngredientCrossRef(7, 28), RecipeIngredientCrossRef(7, 4),
            // Quatre Fromages
            RecipeIngredientCrossRef(8, 3), RecipeIngredientCrossRef(8, 28),
            // Jambon-Champignons
            RecipeIngredientCrossRef(9, 15), RecipeIngredientCrossRef(9, 16), RecipeIngredientCrossRef(9, 28),
            // Pesto-Poulet
            RecipeIngredientCrossRef(10, 29), RecipeIngredientCrossRef(10, 8), RecipeIngredientCrossRef(10, 28),
            // Végétarienne
            RecipeIngredientCrossRef(11, 13), RecipeIngredientCrossRef(11, 14), RecipeIngredientCrossRef(11, 28),
            // Calzone
            RecipeIngredientCrossRef(12, 15), RecipeIngredientCrossRef(12, 3), RecipeIngredientCrossRef(12, 28),
            // Cheeseburger
            RecipeIngredientCrossRef(13, 7), RecipeIngredientCrossRef(13, 6), RecipeIngredientCrossRef(13, 3),
            // Bacon Burger
            RecipeIngredientCrossRef(14, 7), RecipeIngredientCrossRef(14, 6), RecipeIngredientCrossRef(14, 30),
            // Chicken Burger
            RecipeIngredientCrossRef(15, 7), RecipeIngredientCrossRef(15, 8), RecipeIngredientCrossRef(15, 9),
            // Burger Végétarien
            RecipeIngredientCrossRef(16, 7), RecipeIngredientCrossRef(16, 18), RecipeIngredientCrossRef(16, 9),
            // Double Smash
            RecipeIngredientCrossRef(17, 7), RecipeIngredientCrossRef(17, 6), RecipeIngredientCrossRef(17, 3), RecipeIngredientCrossRef(17, 30),
            // César
            RecipeIngredientCrossRef(18, 9), RecipeIngredientCrossRef(18, 8), RecipeIngredientCrossRef(18, 3),
            // Niçoise
            RecipeIngredientCrossRef(19, 2), RecipeIngredientCrossRef(19, 11), RecipeIngredientCrossRef(19, 9),
            // Crevettes
            RecipeIngredientCrossRef(20, 19), RecipeIngredientCrossRef(20, 18), RecipeIngredientCrossRef(20, 9),
            // Grecque
            RecipeIngredientCrossRef(21, 2), RecipeIngredientCrossRef(21, 3), RecipeIngredientCrossRef(21, 9),
            // Bowl Quinoa
            RecipeIngredientCrossRef(22, 18), RecipeIngredientCrossRef(22, 9), RecipeIngredientCrossRef(22, 2),
            // Tiramisu
            RecipeIngredientCrossRef(23, 25), RecipeIngredientCrossRef(23, 26), RecipeIngredientCrossRef(23, 11), RecipeIngredientCrossRef(23, 22),
            // Fondant chocolat
            RecipeIngredientCrossRef(24, 23), RecipeIngredientCrossRef(24, 21), RecipeIngredientCrossRef(24, 11), RecipeIngredientCrossRef(24, 20),
            // Tarte fraises
            RecipeIngredientCrossRef(25, 24), RecipeIngredientCrossRef(25, 20), RecipeIngredientCrossRef(25, 21), RecipeIngredientCrossRef(25, 22),
            // Crème brûlée
            RecipeIngredientCrossRef(26, 10), RecipeIngredientCrossRef(26, 11), RecipeIngredientCrossRef(26, 22),
            // Mousse chocolat
            RecipeIngredientCrossRef(27, 23), RecipeIngredientCrossRef(27, 11), RecipeIngredientCrossRef(27, 22),
            // Panna Cotta
            RecipeIngredientCrossRef(28, 10), RecipeIngredientCrossRef(28, 22), RecipeIngredientCrossRef(28, 24)
        )
        recipeIngredientLinks.forEach { ingredientDao.insertRecipeIngredientCrossRef(it) }
    }
}
