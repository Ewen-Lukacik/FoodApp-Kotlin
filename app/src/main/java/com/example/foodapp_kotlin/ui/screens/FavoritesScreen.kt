package com.example.foodapp_kotlin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodapp_kotlin.ui.components.MainScaffold
import com.example.foodapp_kotlin.ui.components.RecipeCard
import com.example.foodapp_kotlin.ui.theme.Background
import com.example.foodapp_kotlin.ui.theme.Primary
import com.example.foodapp_kotlin.ui.theme.TextPrimary
import com.example.foodapp_kotlin.ui.theme.TextSecondary
import com.example.foodapp_kotlin.ui.viewmodel.AuthViewModel

@Composable
fun FavoritesScreen(navController: NavController, authViewModel: AuthViewModel) {
    val favoriteRecipes by authViewModel.favoriteRecipes.collectAsState()
    val favoriteIds by authViewModel.favoriteIds.collectAsState()

    MainScaffold(navController = navController) { innerPadding ->
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
            item(span = { androidx.compose.foundation.lazy.grid.GridItemSpan(2) }) {
                Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
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
                        "${favoriteRecipes.size} recette${if (favoriteRecipes.size > 1) "s" else ""} sauvegardée${if (favoriteRecipes.size > 1) "s" else ""}",
                        fontSize = 14.sp,
                        color = TextSecondary
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            if (favoriteRecipes.isEmpty()) {
                item(span = { androidx.compose.foundation.lazy.grid.GridItemSpan(2) }) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 64.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Rounded.Favorite,
                                contentDescription = null,
                                tint = TextSecondary.copy(alpha = 0.3f),
                                modifier = Modifier.size(64.dp)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                "Aucun favori pour l'instant",
                                fontSize = 16.sp,
                                color = TextSecondary,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                "Appuyez sur le cœur d'une recette\npour l'ajouter à vos favoris",
                                fontSize = 13.sp,
                                color = TextSecondary.copy(alpha = 0.7f),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }
            } else {
                items(favoriteRecipes) { recipe ->
                    RecipeCard(
                        recipe = recipe,
                        modifier = Modifier.fillMaxWidth(),
                        isFavorite = recipe.id in favoriteIds,
                        onFavoriteClick = { authViewModel.toggleFavorite(recipe.id) }
                    )
                }
            }
        }
    }
}
