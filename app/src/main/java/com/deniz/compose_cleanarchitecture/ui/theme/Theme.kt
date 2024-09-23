package com.deniz.compose_cleanarchitecture.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

/*
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun ComposeCleanArchitectureTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
 */

private val DarkColorPalette = darkColorScheme(
    primary = Color(0xFF1B263B), // Midnight Blue
    secondary = Color(0xFF6A0572), // Astro Purple
    background = Color(0xFF0A0A0A), // Night Sky Black
    surface = Color(0xFFEDEDED), // Moonlight White
    onPrimary = Color.White, // Text on Primary
    onSecondary = Color.White, // Text on Secondary
    onBackground = Color.White, // Text on Background
    onSurface = Color(0xFF1B263B), // Text on Surface (Dark)
    error = Color(0xFFFF6347) // Mars Red
)

private val LightColorPalette = lightColorScheme(
    primary = Color(0xFF1B263B), // Midnight Blue
    secondary = Color(0xFF6A0572), // Astro Purple
    background = Color(0xFFEDEDED), // Moonlight White
    surface = Color.White, // White surface
    onPrimary = Color.White, // Text on Primary
    onSecondary = Color.White, // Text on Secondary
    onBackground = Color(0xFF1B263B), // Text on Background
    onSurface = Color(0xFF1B263B), // Text on Surface
    error = Color(0xFFFF6347) // Mars Red
)

@Composable
fun ApplicationTheme(darkTheme: Boolean = true, content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}