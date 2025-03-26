package com.zywczas.commoncompose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RippleConfiguration
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Theme {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun App(
        darkTheme: Boolean = isSystemInDarkTheme(),
        content: @Composable () -> Unit
    ) {
        CompositionLocalProvider(
            LocalRippleConfiguration provides RippleConfiguration(PrimaryColorLight)
        ) {
            MaterialTheme(
                colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
                typography = typography,
                content = content
            )
        }
    }

    @Composable
    fun Preview(content: @Composable () -> Unit) {
        App(content = content)
    }
}

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryColorLight,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

private val typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 22.sp,
    ),
    labelLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        letterSpacing = 0.5.sp,
        lineHeight = 24.sp,
    )
)
