package org.example.project.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.ui.graphics.vector.ImageVector

data class Historical(
    val id: Long = -1,
    val category: SensorHistoricalCategory,
    val description: String,
){
    val icon = category.icon
}

enum class SensorHistoricalCategory(val icon: ImageVector){

    TEMPERATURE(Icons.Default.WaterDrop),
    PH(Icons.Default.WaterDrop),
    TURBIDITY(Icons.Default.WaterDrop)

}