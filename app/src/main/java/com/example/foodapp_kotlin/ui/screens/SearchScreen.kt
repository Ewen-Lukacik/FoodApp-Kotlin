package com.example.foodapp_kotlin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.navigation.NavController
import com.example.foodapp_kotlin.ui.components.CategoryCard
import com.example.foodapp_kotlin.ui.components.MainScaffold
import com.example.foodapp_kotlin.ui.theme.Cream
import com.example.foodapp_kotlin.ui.theme.DividerGray
import com.example.foodapp_kotlin.ui.theme.Primary
import com.example.foodapp_kotlin.ui.theme.TextPrimary
import com.example.foodapp_kotlin.ui.theme.TextSecondary

@Composable
fun SearchScreen(navController: NavController) {
    var query by remember { mutableStateOf("") }

    MainScaffold(navController = navController) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(Cream)
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {

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

            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                placeholder = {
                    Text("Rechercher des recettes, ingrédients...", color = TextSecondary, fontSize = 14.sp)
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = "Search",
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

            Text(
                "Catégories",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = TextPrimary
            )

            Spacer(modifier = Modifier.height(8.dp))

            CategoryCard(modifier = Modifier.fillMaxWidth()) { navController.navigate("category_detail") }
            CategoryCard(modifier = Modifier.fillMaxWidth()) { navController.navigate("category_detail") }
            CategoryCard(modifier = Modifier.fillMaxWidth()) { navController.navigate("category_detail") }
            CategoryCard(modifier = Modifier.fillMaxWidth()) { navController.navigate("category_detail") }
            CategoryCard(modifier = Modifier.fillMaxWidth()) { navController.navigate("category_detail") }
        }
    }
}
