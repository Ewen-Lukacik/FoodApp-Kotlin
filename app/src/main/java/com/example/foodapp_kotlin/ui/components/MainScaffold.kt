import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier



@Composable
fun MainScaffold(content: @Composable (PaddingValues) -> Unit) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        content(innerPadding)
    }
}