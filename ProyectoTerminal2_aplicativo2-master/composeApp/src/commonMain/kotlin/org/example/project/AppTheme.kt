package org.example.project

import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//Este archivo va aplicar colores y estilos a nuestra app
@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = MaterialTheme.colors.copy(primary = Color.Black),
        shapes = MaterialTheme.shapes.copy(
            small = AbsoluteCutCornerShape(0.dp),
            medium = AbsoluteCutCornerShape(0.dp),
            large = AbsoluteCutCornerShape(0.dp)
        )
    ) {
        content()
    }
}

@Composable
fun getColorsTheme(): DarkModeColors {
    val isDarkMode = false

    val Blue = Color(0xFFB7FFF3)
    val ColorSensorItem = if (isDarkMode) Color(0xFF090808) else Color(0xFFF1F1F1)
    val BackgroundColor = if (isDarkMode) Color(0xFF1E1C1C) else Color(0xFFF7FAFC)
    val TextColor = if (isDarkMode) Color.White else Color.Black
    val ColorTrafficLightsR = Color(0xFFFE0002).copy(alpha = .2f)  //Transparente
    val ColorTrafficLightsG = Color(0xFF419E2B).copy(alpha = .2f)  //Transparente
    val ColorTrafficLightsY = Color(0xFFFFE400).copy(alpha = .2f)  //Transparente
    val ColorNode = Blue
    val ColorNode2 = Color(0xFF91B8FA)
    val Dashboard = Color(0xFF4F7396)

    return DarkModeColors(
        blue = Blue,
        colorSensorItem = ColorSensorItem,
        backgroundColor = BackgroundColor,
        textColor = TextColor,
        colorTrafficLightsR = ColorTrafficLightsR,
        colorTrafficLightsG = ColorTrafficLightsG,
        colorTrafficLightsY = ColorTrafficLightsY,
        colorNode = ColorNode,
        colorNode2 = ColorNode2,
        dashboard = Dashboard
    )
}

data class DarkModeColors(
    val blue: Color,
    val colorSensorItem: Color,
    val backgroundColor: Color,
    val textColor: Color,
    val colorTrafficLightsR: Color,
    val colorTrafficLightsG: Color,
    val colorTrafficLightsY: Color,
    val colorNode: Color,
    val colorNode2: Color,
    val dashboard: Color
)