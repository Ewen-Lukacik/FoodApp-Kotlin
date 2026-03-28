package com.example.foodapp_kotlin.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary           = Primary,
    onPrimary         = SurfaceWhite,
    primaryContainer  = PrimaryLight,
    onPrimaryContainer= PrimaryDark,
    background        = Background,
    surface           = SurfaceWhite,
    onBackground      = TextPrimary,
    onSurface         = TextPrimary,
    outline           = DividerGray,
    secondary         = GreenAccent,
    onSecondary       = SurfaceWhite
)

@Composable
fun FoodAppKotlinTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography  = Typography,
        content     = content
    )
}
