package org.example.project.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.data.SensorHistoricalManager
import org.example.project.getColorsTheme
import org.example.project.model.Historical


@Composable
fun SensorsHistoricalScreen(onSensorHistoricalClick: (historical: Historical) -> Unit) {


    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item { HistoricalData() }
        item { WeekMonth() }
        item { NodeDataDay() }


        items(SensorHistoricalManager.fakeSensorList) { historical ->
            SensorHistoricalItem(
                historical = historical,
                onSensorHistoricalClick = onSensorHistoricalClick
            )
        }

        item {
            val pagerState = rememberPagerState(pageCount = { 3 })

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) { page ->
                AnimatedContent(
                    targetState = page,
                    transitionSpec = {
                        slideInHorizontally(animationSpec = tween(500)) + fadeIn() togetherWith
                                slideOutHorizontally(animationSpec = tween(500)) + fadeOut()
                    }
                ) { targetPage ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        when (targetPage) {
                            0 -> SimpleBarChart(values = listOf(22f, 23f, 24f, 25f, 26f))
                            1 -> SimpleBarChart(values = listOf(7.1f, 7.2f, 7.0f, 7.3f, 7.2f))
                            2 -> SimpleBarChart(values = listOf(5f, 4.8f, 5.1f, 4.9f, 5.2f))
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = when (targetPage) {
                                0 -> "Temperatura"
                                1 -> "pH"
                                else -> "Turbidez"
                            },
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                color = Color.Black
                            ),
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }
                }
            }
        }

    }
}


@Composable
fun HistoricalData() {
    val colors = getColorsTheme()
    Row(
        modifier = Modifier.padding(vertical = 16.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Historico de Datos",
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp,
            color = colors.textColor
        )
    }
}


@Composable
fun WeekMonth() {

    val colors = getColorsTheme()

    Column(
        modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp)
                .clickable { },
            backgroundColor = colors.backgroundColor,
            shape = RoundedCornerShape(30)
        )
        {
            Box(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp)

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Última semana",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = colors.textColor
                    )

                    Surface(
                        modifier = Modifier.size(50.dp),
                        shape = RoundedCornerShape(35),
                        color = colors.backgroundColor
                    ) {
                        Icon(
                            modifier = Modifier.padding(10.dp),
                            imageVector = Icons.Default.Analytics,
                            contentDescription = "Icon Historical week"
                        )
                    }
                }

            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp)
                .clickable { },
            backgroundColor = colors.backgroundColor,
            shape = RoundedCornerShape(30)
        )
        {
            Box(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp)

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Último mes",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = colors.textColor
                    )

                    Surface(
                        modifier = Modifier.size(50.dp),
                        shape = RoundedCornerShape(35),
                        color = colors.backgroundColor
                    ) {
                        Icon(
                            modifier = Modifier.padding(10.dp),
                            imageVector = Icons.Default.Analytics,
                            contentDescription = "Icon Historical week"
                        )
                    }
                }

            }
        }

    }

}


@Composable
fun NodeDataDay() {
    val colors = getColorsTheme()

    Card(
        shape = RoundedCornerShape(10),
        backgroundColor = colors.backgroundColor,
        elevation = 5.dp
    ) {
        // Usamos una Column para alinear el texto al inicio
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top // Alinea el contenido al inicio
        ) {
            Text(
                text = "Datos del día --> Nodo #",
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black
            )
        }
    }
}


@Composable
fun SensorHistoricalItem(
    historical: Historical,
    onSensorHistoricalClick: (historical: Historical) -> Unit
) {
    val colors = getColorsTheme()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp)
            .clickable { onSensorHistoricalClick(historical) }, // Aquí se usa 'historical' correctamente
        backgroundColor = colors.colorSensorItem,
        shape = RoundedCornerShape(30)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            ) {
                Text(
                    text = historical.category.name,
                    fontWeight = FontWeight.Medium, fontSize = 18.sp, color = colors.textColor
                )

                Text(
                    text = historical.description,
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    color = Color.Gray
                )
            }

            Surface(
                modifier = Modifier.size(50.dp),
                shape = RoundedCornerShape(35),
                color = colors.backgroundColor
            ) {
                Image(
                    modifier = Modifier.padding(10.dp),
                    imageVector = historical.icon,
                    colorFilter = ColorFilter.tint(Color.Black),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Imagen Icono Expense Item"
                )
            }
        }
    }
}


@Composable
fun SimpleBarChart(values: List<Float>) {
    val maxValue = values.maxOrNull() ?: 1f

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(16.dp)
    ) {
        val barWidth = size.width / (values.size * 2)
        values.forEachIndexed { index, value ->
            val barHeight = (value / maxValue) * size.height
            drawRect(
                color = Color.Blue,
                topLeft = Offset(x = index * barWidth * 2f, y = size.height - barHeight),
                size = androidx.compose.ui.geometry.Size(width = barWidth, height = barHeight)
            )
        }
    }
}





