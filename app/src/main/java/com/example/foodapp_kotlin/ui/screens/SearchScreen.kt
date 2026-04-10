package com.example.foodapp_kotlin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.foodapp_kotlin.ui.components.CategoryCard
import com.example.foodapp_kotlin.ui.components.MainScaffold
import com.example.foodapp_kotlin.ui.components.RecipeCard
import com.example.foodapp_kotlin.ui.viewmodel.RecipeViewModel
import com.example.foodapp_kotlin.ui.theme.Cream
import com.example.foodapp_kotlin.ui.theme.DividerGray
import com.example.foodapp_kotlin.ui.theme.Primary
import com.example.foodapp_kotlin.ui.theme.TextPrimary
import com.example.foodapp_kotlin.ui.theme.TextSecondary

@Composable
fun SearchScreen(navController: NavController) {
    val viewModel: RecipeViewModel = viewModel()
    val categoriesWithRecipes by viewModel.categoriesWithRecipes.collectAsState()
    val searchResults by viewModel.searchResults.collectAsState()
    var query by remember { mutableStateOf("") }
    val isSearching = query.isNotBlank()

    MainScaffold(navController = navController) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .background(Cream)
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            // Header
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Explorer",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    color = TextPrimary
                )
                Text(
                    "Trouvez votre prochaine recette préférée",
                    fontSize = 14.sp,
                    color = TextSecondary
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            // Search bar
            item {
                OutlinedTextField(
                    value = query,
                    onValueChange = {
                        query = it
                        viewModel.searchRecipes(it)
                    },
                    placeholder = {
                        Text("Rechercher des recettes...", color = TextSecondary, fontSize = 14.sp)
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "Recherche",
                            tint = Primary
                        )
                    },
                    shape = RoundedCornerShape(16.dp),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor   = Color.White,
                        unfocusedBorderColor    = DividerGray,
                        focusedBorderColor      = Primary
                    )
                )
                Spacer(modifier = Modifier.height(24.dp))
            }

            if (isSearching) {
                // Search results section
                item {
                    Text(
                        "${searchResults.size} résultat${if (searchResults.size > 1) "s" else ""} pour \"$query\"",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp,
                        color = TextSecondary
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }

                // Display search results as a 2-column grid
                val chunked = searchResults.chunked(2)
                items(chunked) { rowRecipes ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        rowRecipes.forEach { recipe ->
                            RecipeCard(
                                recipe = recipe,
                                modifier = Modifier.weight(1f),
                                onClick = { navController.navigate("dish/${recipe.id}") }
                            )
                        }
                        // Fill empty space if odd number
                        if (rowRecipes.size == 1) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                }
            } else {
                // Categories section
                item {
                    Text(
                        "Catégories",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = TextPrimary
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

                items(categoriesWithRecipes) { categoryWithRecipes ->
                    CategoryCard(
                        category = categoryWithRecipes.category,
                        recipeCount = categoryWithRecipes.recipes.size,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        navController.navigate("all_recipes/${categoryWithRecipes.category.id}")
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}
