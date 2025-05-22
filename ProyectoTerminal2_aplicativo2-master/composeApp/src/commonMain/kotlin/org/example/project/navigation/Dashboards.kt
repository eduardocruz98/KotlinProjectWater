package org.example.project.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.ui.SensorsHistoricalScreen
import org.example.project.ui.dashConexion
import org.example.project.ui.dashHome
import org.example.project.ui.dashNotificaciones


@Composable
fun Dashboard1() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 64.dp), // espacio para los tabs
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        dashHome()
    }
}

@Composable
fun Dashboard2() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SensorsHistoricalScreen() {
            // Aquí tu contenido
        }
    }
}

@Composable
fun Dashboard3() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        dashNotificaciones()
    }
}

@Composable
fun Dashboard4() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        dashConexion()
    }
}
