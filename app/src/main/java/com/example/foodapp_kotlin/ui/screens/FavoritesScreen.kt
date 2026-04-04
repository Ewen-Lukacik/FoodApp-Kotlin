package com.example.foodapp_kotlin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodapp_kotlin.local.entity.Recipe
import com.example.foodapp_kotlin.ui.components.MainScaffold
import com.example.foodapp_kotlin.ui.components.RecipeCard
import com.example.foodapp_kotlin.ui.theme.Cream
import com.example.foodapp_kotlin.ui.theme.Primary
import com.example.foodapp_kotlin.ui.theme.TextPrimary
import com.example.foodapp_kotlin.ui.theme.TextSecondary

@Composable
fun FavoritesScreen(navController: NavController) {
    val dummyRecipe = Recipe(
        name = "Pâtes Carbonara",
        description = "Les vraies carbonara italiennes",
        time = 25,
        difficulty = 2,
        image = "",
        price = 12
    )

    MainScaffold(navController = navController) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .background(Cream)
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Favorite,
                        contentDescription = null,
                        tint = Primary,
                        modifier = Modifier.size(26.dp)
                    )
                    Text(
                        "Mes Favoris",
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp,
                        color = TextPrimary
                    )
                }
                Text(
                    "Toutes les recettes que vous avez sauvegardées",
                    fontSize = 14.sp,
                    color = TextSecondary
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    RecipeCard(recipe = dummyRecipe, modifier = Modifier.weight(1f), onClick = { navController.navigate("dish/${dummyRecipe.id}") })
                    RecipeCard(recipe = dummyRecipe, modifier = Modifier.weight(1f), onClick = { navController.navigate("dish/${dummyRecipe.id}") })
                }
                Spacer(modifier = Modifier.height(4.dp))
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    RecipeCard(recipe = dummyRecipe, modifier = Modifier.weight(1f), onClick = { navController.navigate("dish/${dummyRecipe.id}") })
                    RecipeCard(recipe = dummyRecipe, modifier = Modifier.weight(1f), onClick = { navController.navigate("dish/${dummyRecipe.id}") })
                }
                Spacer(modifier = Modifier.height(4.dp))
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    RecipeCard(recipe = dummyRecipe, modifier = Modifier.weight(1f), onClick = { navController.navigate("dish/${dummyRecipe.id}") })
                    RecipeCard(recipe = dummyRecipe, modifier = Modifier.weight(1f), onClick = { navController.navigate("dish/${dummyRecipe.id}") })
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
