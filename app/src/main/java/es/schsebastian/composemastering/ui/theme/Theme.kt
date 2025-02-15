package es.schsebastian.composemastering.ui.theme

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

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFD500F9),    // Púrpura vibrante
    secondary = Color(0xFF00E676),  // Verde vibrante
    tertiary = Color(0xFFFF4081),   // Rosa vibrante
    background = Color(0xFF121212), // Fondo oscuro elegante
    surface = Color(0xFF1E1E1E),    // Superficie oscura y refinada
    onPrimary = Color.Black,        // Contraste para el primary
    onSecondary = Color.Black,      // Contraste para el secondary
    onTertiary = Color.Black,       // Contraste para el tertiary
    onBackground = Color(0xFFEEEEEE), // Texto claro en fondo oscuro
    onSurface = Color(0xFFEEEEEE)     // Texto claro en superficies oscuras
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF7C4DFF),    // Púrpura vibrante
    secondary = Color(0xFF00C853),  // Verde vibrante
    tertiary = Color(0xFFFF4081),   // Rosa vibrante
    background = Color(0xFFFFFFFF), // Fondo blanco puro
    surface = Color(0xFFF2F2F2),    // Superficie clara y refinada
    onPrimary = Color.White,        // Contraste para el primary
    onSecondary = Color.White,      // Contraste para el secondary
    onTertiary = Color.White,       // Contraste para el tertiary
    onBackground = Color(0xFF1C1B1F), // Texto oscuro en fondo claro
    onSurface = Color(0xFF1C1B1F)     // Texto oscuro en superficies claras
)

@Composable
fun ComposeMasteringTheme(
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