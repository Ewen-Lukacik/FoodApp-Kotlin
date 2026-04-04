package com.example.foodapp_kotlin.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodapp_kotlin.local.entity.Category
import com.example.foodapp_kotlin.local.entity.Recipe
import com.example.foodapp_kotlin.ui.theme.Primary
import com.example.foodapp_kotlin.ui.theme.TextPrimary

@Composable
fun FoodSection(
    navController: NavController,
    category: Category,
    recipes: List<Recipe>
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 8.dp)
    ) {
        Text(
            category.name,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = TextPrimary
        )
        TextButton(onClick = { navController.navigate("all_recipes") }) {
            Text(
                "Voir tout",
                fontSize = 13.sp,
                color = Primary,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.width(2.dp))
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                contentDescription = null,
                tint = Primary,
                modifier = Modifier.size(16.dp)
            )
        }
    }
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        recipes.forEach { recipe ->
            RecipeCard(recipe = recipe)
        }
    }
}
