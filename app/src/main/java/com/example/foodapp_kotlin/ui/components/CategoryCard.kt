package com.example.foodapp_kotlin.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodapp_kotlin.local.entity.Category
import com.example.foodapp_kotlin.ui.theme.Primary
import com.example.foodapp_kotlin.ui.theme.PrimaryLight
import com.example.foodapp_kotlin.ui.theme.TextPrimary
import com.example.foodapp_kotlin.ui.theme.TextSecondary
import com.example.foodapp_kotlin.ui.utils.imageResForName

@Composable
fun CategoryCard(
    category: Category,
    recipeCount: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val context = LocalContext.current
    Card(
        modifier = modifier.padding(vertical = 4.dp).clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Primary.copy(alpha = 0.05f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(PrimaryLight),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imageResForName(context, category.image)),
                    contentDescription = category.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(56.dp)
                        .clip(RoundedCornerShape(14.dp))
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    category.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = TextPrimary
                )
                Text(
                    "$recipeCount recette${if (recipeCount > 1) "s" else ""}",
                    fontSize = 12.sp,
                    color = TextSecondary
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(PrimaryLight)
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text(
                    "Voir",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Primary
                )
            }
        }
    }
}
