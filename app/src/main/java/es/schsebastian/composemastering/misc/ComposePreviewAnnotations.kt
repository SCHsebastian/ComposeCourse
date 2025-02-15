package es.schsebastian.composemastering.misc

import android.content.res.Configuration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import es.schsebastian.composemastering.base.BaseContent

/**
 * Comprehensive Preview Pack for Jetpack Compose
 * Contains various preview configurations for different use cases
 */

// ==============================================
//  Basic Previews
// ==============================================

@Preview(name = "📱 Phone (Default)")
@Preview(name = "📱 Light Theme", showBackground = true)
@Preview(name = "📱 Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
annotation class PhonePreviews

@Preview(name = "🖥️ Tablet", device = "spec:width=1280dp,height=800dp,dpi=240")
@Preview(name = "🖥️ Landscape", device = "spec:width=1280dp,height=800dp,dpi=240", widthDp = 1280, heightDp = 800)
annotation class TabletPreviews

// ==============================================
//  Advanced Device Configurations
// ==============================================

@Preview(name = "📱 Foldable", device = "spec:width=673dp,height=841dp")
@Preview(name = "📱 Desktop", device = "spec:width=1920dp,height=1080dp,dpi=160")
@Preview(name = "📱 Pixel 6 Pro", device = Devices.PIXEL_6_PRO)
@Preview(name = "📱 Nexus 10", device = Devices.NEXUS_10)
annotation class AlternativeDevicePreviews

// ==============================================
//  Theming & Styling
// ==============================================

@Preview(name = "🎨 Material 3", group = "Theming")
@Preview(name = "🎨 Custom Font Scale", fontScale = 1.5f)
@Preview(name = "🎨 High Contrast", backgroundColor = 0xFF000000)
@Preview(name = "🎨 Transparent BG", showBackground = false)
annotation class ThemingPreviews

// ==============================================
//  Internationalization
// ==============================================

@Preview(name = "🌐 Arabic (RTL)", locale = "ar")
@Preview(name = "🌐 Japanese", locale = "ja")
@Preview(name = "🌐 German", locale = "de")
@Preview(name = "🌐 Hindi", locale = "hi")
annotation class LocalizationPreviews

// ==============================================
//  Screen States
// ==============================================

@Preview(name = "🔄 Portrait", widthDp = 360, heightDp = 640)
@Preview(name = "🔄 Landscape", widthDp = 640, heightDp = 360)
@Preview(name = "🔄 Square", widthDp = 360, heightDp = 360)
annotation class OrientationPreviews

// ==============================================
//  Component States
// ==============================================

@Preview(name = "✅ Enabled State", showBackground = true)
@Preview(name = "🚫 Disabled State", showBackground = true)
@Preview(name = "⚠️ Error State", showBackground = true)
annotation class ComponentStatePreviews

// ==============================================
//  API Level Specific
// ==============================================

@Preview(name = "🤖 API 33", apiLevel = 33)
@Preview(name = "🤖 API 35", apiLevel = 35)
annotation class ApiLevelPreviews

// ==============================================
//  Combined Usage Example
// ==============================================

@PhonePreviews
@TabletPreviews
@Preview(
    name = "🚀 Super Preview",
    device = Devices.PIXEL_4_XL,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    locale = "es",
    fontScale = 1.2f,
    showSystemUi = true
)
annotation class MegaPreview

// ==============================================
//  Practical Implementation Example
// ==============================================

@MegaPreview
@PhonePreviews
@TabletPreviews
@Composable
private fun PreviewGreeting() {
    Greeting(
        text = "Hello Android!"
    )
}

@Composable
fun Greeting(
    text: String,
) {
    BaseContent{
        Text(text)
    }
}

// ==============================================
//  Best Practices Guide
// ==============================================
/*
1. Group related previews using annotation classes
2. Use emojis in names for visual scanning
3. Combine multiple annotations for complex previews
4. Test different device configurations
5. Verify theming across light/dight modes
6. Check localization with RTL languages
7. Preview error/loading states
8. Test different API level appearances
9. Verify accessibility (font scaling)
10. Use showSystemUi for full-screen previews
*/