package com.example.foodapp_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.foodapp_kotlin.ui.theme.FoodAppKotlinTheme
import HomeScreen
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodAppKotlinTheme {
                val navController = rememberNavController()

                Column {
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.weight(1f)
                    ) {
                        composable("home") { HomeScreen(navController) }
                        composable("search") { SearchScreen(navController) }
                        composable("favorites") { FavoritesScreen(navController) }
                        composable("profile") { ProfileScreen(navController) }
                    }
                }
            }
        }
    }
}