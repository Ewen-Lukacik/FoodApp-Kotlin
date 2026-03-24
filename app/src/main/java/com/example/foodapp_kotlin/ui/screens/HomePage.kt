import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomePage(){
    MainScaffold { innerPadding ->
        Text(
            "Home",
            modifier = Modifier.padding(innerPadding)
        )
    }
}