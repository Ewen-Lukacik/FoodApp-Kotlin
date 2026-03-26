import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun MainScaffold(navController: androidx.navigation.NavController, content: @Composable (PaddingValues) -> Unit) {
    Scaffold(
        topBar = { TopBar(navController) },
        bottomBar = { BottomBar(navController) },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        content(innerPadding)
    }
}