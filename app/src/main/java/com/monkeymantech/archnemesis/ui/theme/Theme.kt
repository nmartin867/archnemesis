package com.monkeymantech.archnemesis.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview

private val DarkColorPalette = darkColors(
    primary = Gray59,
    primaryVariant = Gray71,
    secondary = Blue245,
    secondaryVariant = Blue65,
    background = Gray46,
    surface = Gray46,
    onPrimary = White229,
    onSecondary = Gray46,
    onBackground = White199,
    onSurface = White199
)

private val LightColorPalette = lightColors()

@Composable
fun ArchNemesisTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}