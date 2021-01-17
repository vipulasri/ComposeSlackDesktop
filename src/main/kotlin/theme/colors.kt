package theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val graySurface = Color(0xFF2A2A2A)
val lightGray = Color(0xFFD3D3D3)
val green700 = Color(0xff388e3c)
val slackBlack = Color(0xff1E2228)
val darkGray = Color(0xFF565656)
val divider = Color(0xff35383D)

object SlackColors {
    val online = Color(0xffA7E476)
    val onlineDark = Color(0xff34785C)
    val grey = Color(0xffABABAD)
    val black = Color(0xff1E2228)
    val reactionBg = Color(0xff232529)
    val optionSelected = Color(0xff5B7AA2)
    val detailsBg = Color(0xff1B1D21)
    val linkBg = Color(0xff1D2A32)
    val link = Color(0xff489ACC)
    val emptyThread = Color(0xff8CBD58)
    val emptyMention = Color(0xffCE5838)
    val emptySaved = Color(0xffCE375C)
}

val DarkColorPalette = darkColors(
    primary = green700,
    primaryVariant = green700,
    secondary = graySurface,
    background = slackBlack,
    surface = slackBlack,
    onPrimary = slackBlack,
    onSecondary = lightGray,
    onBackground = Color.White,
    onSurface = Color.White,
    error = Color.Red,
)

val LightColorPalette = lightColors(
    primary = green700,
    primaryVariant = green700,
    secondary = lightGray,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = graySurface,
    onBackground = slackBlack,
    onSurface = slackBlack
)