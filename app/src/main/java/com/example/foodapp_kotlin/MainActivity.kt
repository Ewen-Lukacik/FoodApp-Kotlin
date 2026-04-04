package com.example.foodapp_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
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
import com.example.foodapp_kotlin.ui.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {

    private val authViewModel: AuthViewModel by viewModels()

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
                        composable("splash")   { SplashScreen(navController, authViewModel) }
                        composable("login")    { LoginScreen(navController, authViewModel) }
                        composable("register") { RegisterScreen(navController, authViewModel) }

                        // Application principale
                        composable("home")      { HomeScreen(navController) }
                        composable("search")    { SearchScreen(navController) }
                        composable("favorites") { FavoritesScreen(navController) }
                        composable("profile")   { ProfileScreen(navController, authViewModel) }
                        composable("dish")      { DishScreen(navController) }

                        // Sous-pages
                        composable("edit_profile")    { EditProfileScreen(navController, authViewModel) }
                        composable("contact")         { ContactScreen(navController) }
                        composable(
                            "all_recipes/{categoryId}",
                            arguments = listOf(
                                androidx.navigation.navArgument("categoryId") {
                                    type = androidx.navigation.NavType.IntType
                                }
                            )
                        ) { backStackEntry ->
                            val categoryId = backStackEntry.arguments?.getInt("categoryId") ?: 0
                            AllRecipesScreen(navController, categoryId = categoryId)
                        }
                        composable("category_detail") { CategoryDetailScreen(navController) }
                    }
                }
            }
        }
    }
}
