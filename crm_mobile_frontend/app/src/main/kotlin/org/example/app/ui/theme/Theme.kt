package org.example.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Ocean Professional palette
private val BluePrimary = Color(0xFF2563EB)
private val AmberSecondary = Color(0xFFF59E0B)
private val ErrorRed = Color(0xFFEF4444)
private val Background = Color(0xFFF9FAFB)
private val Surface = Color(0xFFFFFFFF)
private val TextPrimary = Color(0xFF111827)

private val LightColors = lightColorScheme(
    primary = BluePrimary,
    onPrimary = Color.White,
    secondary = AmberSecondary,
    onSecondary = Color.Black,
    error = ErrorRed,
    onError = Color.White,
    background = Background,
    onBackground = TextPrimary,
    surface = Surface,
    onSurface = TextPrimary
)

private val DarkColors = darkColorScheme(
    primary = BluePrimary,
    onPrimary = Color.White,
    secondary = AmberSecondary,
    onSecondary = Color.Black,
    error = ErrorRed,
    onError = Color.White
)

@Composable
fun CRMAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors: ColorScheme = if (darkTheme) DarkColors else LightColors
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
