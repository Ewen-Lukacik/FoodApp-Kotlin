package com.example.foodapp_kotlin

import MainScaffold
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun FavoritesScreen(navController: NavController) {
    MainScaffold(navController = navController) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Favorites Screen",
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}