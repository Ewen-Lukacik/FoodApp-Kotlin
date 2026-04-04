package com.example.foodapp_kotlin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.foodapp_kotlin.ui.components.RecipeCard
import com.example.foodapp_kotlin.ui.viewmodel.AuthViewModel
import com.example.foodapp_kotlin.ui.viewmodel.RecipeViewModel
import com.example.foodapp_kotlin.ui.theme.Background
import com.example.foodapp_kotlin.ui.theme.TextPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllRecipesScreen(navController: NavController, categoryId: Int, authViewModel: AuthViewModel) {
    val viewModel: RecipeViewModel = viewModel()
    val recipes by viewModel.recipesForCategory.collectAsState()
    val categoryName by viewModel.categoryName.collectAsState()
    val favoriteIds by authViewModel.favoriteIds.collectAsState()

    LaunchedEffect(categoryId) {
        viewModel.loadRecipesForCategory(categoryId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(categoryName, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(
                            "${recipes.size} recette${if (recipes.size > 1) "s" else ""}",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Retour",
                            tint = TextPrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Background)
            )
        },
        containerColor = Background
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(innerPadding)
                .background(Background)
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(vertical = 12.dp)
        ) {
            items(recipes) { recipe ->
                RecipeCard(
                    recipe = recipe,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { navController.navigate("dish/${recipe.id}") },
                    isFavorite = recipe.id in favoriteIds,
                    onFavoriteClick = { authViewModel.toggleFavorite(recipe.id) }
                )
            }
        }
    }
}
