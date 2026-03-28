import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController){
    TopAppBar(
        title = {
            Text(
                "Tasty Recipes",
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFFF6B00)
        ),
        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.Home,
                contentDescription = "Logo",
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 8.dp)
                    .clickable {
                        navController.navigate("home") {
                            launchSingleTop = true
                            popUpTo(navController.graph.startDestinationId)
                        }
                    },
                tint = Color.White
            )
        }
    )
}