package com.example.foodapp_kotlin.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.foodapp_kotlin.R
import com.example.foodapp_kotlin.ui.components.FoodSection
import com.example.foodapp_kotlin.ui.components.MainScaffold
import com.example.foodapp_kotlin.ui.viewmodel.RecipeViewModel
import com.example.foodapp_kotlin.ui.theme.Background
import com.example.foodapp_kotlin.ui.theme.Primary
import com.example.foodapp_kotlin.ui.theme.TextPrimary
import com.example.foodapp_kotlin.ui.theme.TextSecondary

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: RecipeViewModel = viewModel()
    val categoriesWithRecipes by viewModel.categoriesWithRecipes.collectAsState()

    MainScaffold(navController = navController) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .background(Background)
                .fillMaxSize()
        ) {
            item {
                Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Bonjour !",
                        fontSize = 14.sp,
                        color = TextSecondary
                    )
                    Text(
                        "Qu'est-ce qu'on\ncuisine aujourd'hui ?",
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp,
                        color = TextPrimary,
                        lineHeight = 34.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            item {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(24.dp))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Featured recipe",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        Color.Black.copy(alpha = 0.6f),
                                        Color.Transparent
                                    )
                                )
                            )
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp)
                    ) {
                        Text(
                            "Recette du jour",
                            fontSize = 11.sp,
                            color = Color.White.copy(alpha = 0.8f),
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            "Pâtes Carbonara",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                        Text(
                            "Italien • 25 min • Facile",
                            fontSize = 12.sp,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(12.dp)
                            .clip(RoundedCornerShape(50))
                            .background(Primary)
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text("À la une", fontSize = 11.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
                    }
                }
            }

            items(categoriesWithRecipes) { categoryWithRecipes ->
                Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                    FoodSection(
                        navController = navController,
                        category = categoryWithRecipes.category,
                        recipes = categoryWithRecipes.recipes
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }
    }
}
