import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodapp_kotlin.ui.components.RecipeCard

@Composable
fun FoodSection(){
    //Food section
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 16.dp, bottom = 4.dp)
    ) {
        Text(
            "Italian Classics",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                "Find more",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.Red
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Find more",
                tint = Color.Red
            )
        }
    }
    Spacer(modifier = Modifier.padding(vertical = 4.dp))
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        RecipeCard(modifier = Modifier.weight(1f))
        RecipeCard(modifier = Modifier.weight(1f))
    }
}
