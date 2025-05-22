package org.example.project.data

import org.example.project.model.Historical
import org.example.project.model.SensorHistoricalCategory

object SensorHistoricalManager {
    private var currentID = 1L

    val fakeSensorList = mutableListOf(
        Historical(
            id = currentID++,
            category = SensorHistoricalCategory.TEMPERATURE,
            description = "Last alert: 10/11/2022.\n" +
                    "Alert when the temperature exceeds 25°C."
        ),
        Historical(
            id = currentID++,
            category = SensorHistoricalCategory.PH,
            description = "Last alert: 10/11/2022. Alert when the pH is below 6.5."
        ),
        Historical(
            id = currentID++,
            category = SensorHistoricalCategory.TURBIDITY,
            description = "Last alert: 10/11/2022. Turbidity alert."
        )
    )

}