package com.example.foodapp_kotlin.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodapp_kotlin.R
import com.example.foodapp_kotlin.ui.theme.Background
import com.example.foodapp_kotlin.ui.theme.Primary

@Composable
fun TopBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Background)
            .statusBarsPadding()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "Tasty Recettes",
                colorFilter = ColorFilter.tint(Primary),
                modifier = Modifier
                    .height(36.dp)
                    .wrapContentWidth()
            )
            Text(
                "Tasty Recettes",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Primary
            )
        }

//        IconButton(
//            onClick = {},
//            modifier = Modifier
//                .size(40.dp)
//                .clip(CircleShape)
//                .background(Color.White)
//        ) {
//            Icon(
//                imageVector = Icons.Rounded.Notifications,
//                contentDescription = "Notifications",
//                tint = Primary,
//                modifier = Modifier.size(22.dp)
//            )
//        }
    }
}
