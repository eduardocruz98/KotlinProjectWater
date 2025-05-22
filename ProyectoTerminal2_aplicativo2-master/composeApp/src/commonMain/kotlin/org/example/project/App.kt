package org.example.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import aplicativo2.composeapp.generated.resources.Res
import aplicativo2.composeapp.generated.resources.conexion
import aplicativo2.composeapp.generated.resources.grafica
import org.example.project.navigation.Dashboard1
import org.example.project.navigation.Dashboard2
import org.example.project.navigation.Dashboard3
import org.example.project.navigation.Dashboard4
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    var selectedTab by remember { mutableStateOf(0) }

    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                // Contenido de los Dashboards
                when (selectedTab) {
                    0 -> Dashboard1()
                    1 -> Dashboard2()
                    2 -> Dashboard3()
                    3 -> Dashboard4()
                }
            }

            // Tab Row (parte inferior)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                TabRow(selectedTabIndex = selectedTab) {
                    Tab(
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 },
                        icon = {
                            Icon(
                                Icons.Filled.Home,
                                contentDescription = "Dashboard1",
                                modifier = Modifier.size(34.dp),
                                tint = if (selectedTab == 0) androidx.compose.ui.graphics.Color.Black else androidx.compose.ui.graphics.Color.Gray
                            )
                        }
                    )
                    Tab(
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 },
                        icon = {
                            Image(
                                painter = painterResource(Res.drawable.grafica),
                                contentDescription = "Gráficas",
                                modifier = Modifier.size(34.dp).align(Alignment.CenterHorizontally),
                                colorFilter = ColorFilter.tint(
                                    if (selectedTab == 1) androidx.compose.ui.graphics.Color.Black else androidx.compose.ui.graphics.Color.Gray
                                )
                            )
                        }
                    )
                    Tab(
                        selected = selectedTab == 2,
                        onClick = { selectedTab = 2 },
                        icon = {
                            Icon(
                                Icons.Filled.Notifications,
                                contentDescription = "Notificaciones",
                                modifier = Modifier.size(34.dp),
                                tint = if (selectedTab == 2) androidx.compose.ui.graphics.Color.Black else androidx.compose.ui.graphics.Color.Gray
                            )
                        }
                    )
                    Tab(
                        selected = selectedTab == 3,
                        onClick = { selectedTab = 3 },
                        icon = {
                            Image(
                                painter = painterResource(Res.drawable.conexion),
                                contentDescription = "Conexión",
                                modifier = Modifier.size(34.dp).align(Alignment.CenterHorizontally),
                                colorFilter = ColorFilter.tint(
                                    if (selectedTab == 3) androidx.compose.ui.graphics.Color.Black else androidx.compose.ui.graphics.Color.Gray
                                )
                            )
                        }
                    )
                }
            }
        }
    }
}
