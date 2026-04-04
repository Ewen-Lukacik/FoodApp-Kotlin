package com.example.foodapp_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodapp_kotlin.local.DatabaseSeeder
import com.example.foodapp_kotlin.local.database.AppDatabase
import kotlinx.coroutines.launch
import com.example.foodapp_kotlin.ui.screens.AllRecipesScreen
import com.example.foodapp_kotlin.ui.screens.CategoryDetailScreen
import com.example.foodapp_kotlin.ui.screens.ContactScreen
import com.example.foodapp_kotlin.ui.screens.DishScreen
import com.example.foodapp_kotlin.ui.screens.EditProfileScreen
import com.example.foodapp_kotlin.ui.screens.FavoritesScreen
import com.example.foodapp_kotlin.ui.screens.HomeScreen
import com.example.foodapp_kotlin.ui.screens.LoginScreen
import com.example.foodapp_kotlin.ui.screens.ProfileScreen
import com.example.foodapp_kotlin.ui.screens.RegisterScreen
import com.example.foodapp_kotlin.ui.screens.SearchScreen
import com.example.foodapp_kotlin.ui.screens.SplashScreen
import com.example.foodapp_kotlin.ui.theme.FoodAppKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        lifecycleScope.launch {
            DatabaseSeeder.seedDatabase(AppDatabase.getInstance(this@MainActivity))
        }

        setContent {
            FoodAppKotlinTheme {
                val navController = rememberNavController()

                Surface(modifier = Modifier.fillMaxSize()) {
                    NavHost(
                        navController = navController,
                        startDestination = "splash"
                    ) {
                        // Flux d'authentification
                        composable("splash")   { SplashScreen(navController) }
                        composable("login")    { LoginScreen(navController) }
                        composable("register") { RegisterScreen(navController) }

                        // Application principale
                        composable("home")      { HomeScreen(navController) }
                        composable("search")    { SearchScreen(navController) }
                        composable("favorites") { FavoritesScreen(navController) }
                        composable("profile")   { ProfileScreen(navController) }
                        composable("dish")      { DishScreen(navController) }

                        // Sous-pages
                        composable("edit_profile")    { EditProfileScreen(navController) }
                        composable("contact")         { ContactScreen(navController) }
                        composable("all_recipes")     { AllRecipesScreen(navController) }
                        composable("category_detail") { CategoryDetailScreen(navController) }
                    }
                }
            }
        }
    }
}
