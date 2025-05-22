package org.example.project.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import aplicativo2.composeapp.generated.resources.Res
import aplicativo2.composeapp.generated.resources.ph
import aplicativo2.composeapp.generated.resources.temperatura
import aplicativo2.composeapp.generated.resources.turbidez
import org.example.project.getColorsTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun dashHome() {
    val semaforoColor = "gray"
    val colors = getColorsTheme()

    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Bienvenido",
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp,
                color = colors.textColor,
                letterSpacing = 4.sp
            )
            Spacer(modifier = Modifier.height(33.dp))
        }

        item {
            Box(
                modifier = Modifier
                    .background(Color.Cyan)
                    .padding(8.dp)
            ) {
                Text(
                    text = "-> NODO 1 <-",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }

        item { SensorRow("Temperatura", "35 °C", Res.drawable.temperatura, semaforoColor, 58.dp) }
        item { Spacer(modifier = Modifier.padding(10.dp)) }
        item { SensorRow("pH", "6.8", Res.drawable.ph, semaforoColor, 135.dp) }
        item { Spacer(modifier = Modifier.padding(10.dp)) }
        item { SensorRow("Turbidez", "20 NTU", Res.drawable.turbidez, semaforoColor, 94.dp) }

        item {
            Spacer(modifier = Modifier.height(42.dp))
            Box(
                modifier = Modifier
                    .background(Color(0xFFaed6f1))
                    .padding(8.dp)
            ) {
                Text(
                    text = "-> NODO 2 <-",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }

        item { SensorRow("Temperatura", "35 °C", Res.drawable.temperatura, semaforoColor, 58.dp) }
        item { Spacer(modifier = Modifier.padding(10.dp)) }
        item { SensorRow("pH", "6.8", Res.drawable.ph, semaforoColor, 135.dp) }
        item { Spacer(modifier = Modifier.padding(10.dp)) }
        item { SensorRow("Turbidez", "20 NTU", Res.drawable.turbidez, semaforoColor, 94.dp) }

        // Espacio adicional para evitar solapamiento con la barra de tabs
        item { Spacer(modifier = Modifier.height(80.dp)) }
    }
}



@Composable
fun SensorRow(
    label: String,
    value: String,
    iconRes: DrawableResource,
    semaforoColor: String,
    spacerWidth: Dp
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 13.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.width(spacerWidth))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    when (semaforoColor) {
                        "verde" -> Color.Green
                        "amarillo" -> Color.Yellow
                        "rojo" -> Color.Red
                        else -> Color.Gray
                    },
                    shape = RoundedCornerShape(15.dp)
                )
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(iconRes),
            contentDescription = label,
               modifier = Modifier
                    .size(34.dp)
                    .align(Alignment.Center)
            )
        }
    }
}
