package com.example.foodapp_kotlin.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import com.example.foodapp_kotlin.R
import com.example.foodapp_kotlin.ui.components.MainScaffold
import com.example.foodapp_kotlin.ui.theme.Cream
import com.example.foodapp_kotlin.ui.theme.DividerGray
import com.example.foodapp_kotlin.ui.theme.GreenAccent
import com.example.foodapp_kotlin.ui.theme.Primary
import com.example.foodapp_kotlin.ui.theme.TextPrimary
import com.example.foodapp_kotlin.ui.theme.TextSecondary
import com.example.foodapp_kotlin.ui.theme.YellowStar



@Composable
fun DishScreen(navController: NavController) {
    MainScaffold(navController = navController) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(Cream)
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
                    contentDescription = "Dish image",
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
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .background(Primary)
                                .padding(horizontal = 10.dp, vertical = 4.dp)
                        ) {
                            Text("Italien", fontSize = 11.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            "Pâtes Carbonara",
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
                            "12,99 €",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = GreenAccent
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            InfoChip(Icons.Rounded.Star, "4,8", YellowStar)
                            InfoChip(Icons.Rounded.DateRange, "25 min", TextSecondary)
                            InfoChip(Icons.Rounded.ShoppingCart, "Facile", TextSecondary)
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    HorizontalDivider(color = DividerGray)
                    Spacer(modifier = Modifier.height(20.dp))

                    Text("Description", fontWeight = FontWeight.Bold, fontSize = 17.sp, color = TextPrimary)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Un grand classique de la cuisine italienne préparé avec des œufs, du Pecorino Romano, du Parmigiano-Reggiano, de la guanciale et du poivre noir. Crémeux, riche et incroyablement savoureux.",
                        fontSize = 14.sp,
                        color = TextSecondary,
                        lineHeight = 22.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                    HorizontalDivider(color = DividerGray)
                    Spacer(modifier = Modifier.height(20.dp))

                    Text("Ingrédients", fontWeight = FontWeight.Bold, fontSize = 17.sp, color = TextPrimary)
                    Spacer(modifier = Modifier.height(10.dp))

                    listOf(
                        "200g de spaghetti",
                        "100g de guanciale",
                        "2 œufs + 1 jaune",
                        "50g de Pecorino Romano",
                        "Poivre noir selon le goût"
                    ).forEach { ingredient ->
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
                            Text(ingredient, fontSize = 14.sp, color = TextPrimary)
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
