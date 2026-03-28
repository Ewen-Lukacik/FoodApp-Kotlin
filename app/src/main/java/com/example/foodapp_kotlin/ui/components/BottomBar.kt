import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

import androidx.compose.ui.unit.sp

@Composable
fun BottomBar(navController: androidx.navigation.NavController){
    Row(
        modifier = Modifier.fillMaxWidth()
            .background(Color.White)
            .navigationBarsPadding()
            .padding(vertical = 8.dp)
    ) {
        val buttons = listOf(
            Triple(Icons.Rounded.Home, "Home", "Home"),
            Triple(Icons.Rounded.Search, "Search", "Search"),
            Triple(Icons.Rounded.Favorite, "Favorites", "Favorites"),
            Triple(Icons.Rounded.Person, "Profile", "Profile"),

            )

        buttons.forEach { (icon, label, route) ->
            Button(
                onClick = { navController.navigate(route) {
                    launchSingleTop = true
                    popUpTo(navController.graph.startDestinationId)
                }},
                modifier = Modifier.weight(1f)
                    .padding(horizontal = 4.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                ),
                contentPadding = PaddingValues(
                    vertical = 4.dp,
                    horizontal = 2.dp
                ),
                elevation = ButtonDefaults.buttonElevation(0.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = label
                    )
                    Text(
                        text = label,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}