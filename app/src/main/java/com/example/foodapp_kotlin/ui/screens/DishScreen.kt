package com.example.foodapp_kotlin.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.foodapp_kotlin.ui.viewmodel.RecipeViewModel
import com.example.foodapp_kotlin.ui.theme.Cream
import com.example.foodapp_kotlin.ui.theme.DividerGray
import com.example.foodapp_kotlin.ui.theme.GreenAccent
import com.example.foodapp_kotlin.ui.theme.Primary
import com.example.foodapp_kotlin.ui.theme.TextPrimary
import com.example.foodapp_kotlin.ui.theme.TextSecondary
import com.example.foodapp_kotlin.ui.theme.YellowStar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DishScreen(navController: NavController, recipeId: Int) {
    val viewModel: RecipeViewModel = viewModel()
    val recipe by viewModel.selectedRecipe.collectAsState()
    val ingredients by viewModel.recipeIngredients.collectAsState()
    val categories by viewModel.recipeCategories.collectAsState()

    LaunchedEffect(recipeId) {
        viewModel.loadRecipeDetail(recipeId)
    }

    val difficultyLabel = when (recipe?.difficulty) {
        1 -> "Facile"
        2 -> "Moyen"
        3 -> "Difficile"
        else -> "—"
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Retour",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        },
        containerColor = Cream
    ) { innerPadding ->
        if (recipe == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = Primary)
            }
        } else {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = recipe!!.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.5f))
                                )
                            )
                    )
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Column {
                            if (categories.isNotEmpty()) {
                                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                    categories.forEach { category ->
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(50))
                                                .background(Primary)
                                                .padding(horizontal = 10.dp, vertical = 4.dp)
                                        ) {
                                            Text(
                                                category.name,
                                                fontSize = 11.sp,
                                                color = Color.White,
                                                fontWeight = FontWeight.SemiBold
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                            }
                            Text(
                                recipe!!.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 26.sp,
                                color = Color.White
                            )
                        }
                    }
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-20).dp),
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                    colors = CardDefaults.cardColors(containerColor = Cream),
                    elevation = CardDefaults.cardElevation(0.dp)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                "${recipe!!.price} €",
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                                color = GreenAccent
                            )
                            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                                InfoChip(Icons.Rounded.Star, "4,8", YellowStar)
                                InfoChip(Icons.Rounded.DateRange, "${recipe!!.time} min", TextSecondary)
                                InfoChip(Icons.Rounded.ShoppingCart, difficultyLabel, TextSecondary)
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))
                        HorizontalDivider(color = DividerGray)
                        Spacer(modifier = Modifier.height(20.dp))

                        Text("Description", fontWeight = FontWeight.Bold, fontSize = 17.sp, color = TextPrimary)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            recipe!!.description,
                            fontSize = 14.sp,
                            color = TextSecondary,
                            lineHeight = 22.sp
                        )

                        Spacer(modifier = Modifier.height(20.dp))
                        HorizontalDivider(color = DividerGray)
                        Spacer(modifier = Modifier.height(20.dp))

                        Text("Ingrédients", fontWeight = FontWeight.Bold, fontSize = 17.sp, color = TextPrimary)
                        Spacer(modifier = Modifier.height(10.dp))

                        if (ingredients.isEmpty()) {
                            Text(
                                "Aucun ingrédient renseigné",
                                fontSize = 14.sp,
                                color = TextSecondary
                            )
                        } else {
                            ingredients.forEach { ingredient ->
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(vertical = 5.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(8.dp)
                                            .background(Primary, shape = RoundedCornerShape(50))
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(ingredient.name, fontSize = 14.sp, color = TextPrimary)
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(54.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Primary),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text("Ajouter aux favoris", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun InfoChip(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    iconTint: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(Color.White)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = iconTint, modifier = Modifier.size(14.dp))
        Spacer(modifier = Modifier.width(4.dp))
        Text(label, fontSize = 12.sp, color = TextPrimary, fontWeight = FontWeight.Medium)
    }
}
