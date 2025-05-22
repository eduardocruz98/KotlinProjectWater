package org.example.project.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import aplicativo2.composeapp.generated.resources.Res
import aplicativo2.composeapp.generated.resources.logo
import kotlinx.coroutines.delay
import org.example.project.App
import org.jetbrains.compose.resources.painterResource


sealed class Screen {
    object Loading : Screen() // Pantalla de carga
    object PowerControl : Screen() // Pantalla de encendido/apagado
    object Dashboard : Screen() // Pantalla de dashboards
}

@Composable
fun NavigationFlow() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.PowerControl) } // Iniciamos con PowerControl

    // Control del flujo de navegación basado en la pantalla actual
    when (val screen = currentScreen) {

        is Screen.PowerControl -> {
            PowerControlScreen {
                currentScreen = Screen.Loading  // Navegar a Loading después de PowerControl
            }
        }

        is Screen.Loading -> {
            LoadingScreen {
                currentScreen = Screen.Dashboard  // Navegar a Dashboard después de Loading
            }
        }

        is Screen.Dashboard -> {
            App()  // Mostrar los dashboards
        }

        else -> { // Pantalla Splash no se usará más si comenzamos en PowerControl
            // Aquí podrías agregar un manejador de pantallas si es necesario.
        }
    }
}

@Composable
fun LoadingScreen(onNavigateToNext: () -> Unit) {  //P A N T A L L A  D E  L O A D I N G
    LaunchedEffect(Unit) {
        delay(3000) // Simula la carga durante 3 segundos (puedes ajustar el tiempo aquí)
        onNavigateToNext() // Navega a la siguiente pantalla cuando termine
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp), // Espaciado desde la parte superior
        horizontalAlignment = Alignment.CenterHorizontally,  // Centra los elementos horizontalmente
        verticalArrangement = Arrangement.Top // Organiza los elementos desde la parte superior
    ) {

        // Imagen alineada arriba
        Image(
            painter = painterResource(Res.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()  // Hace que la imagen ocupe todo el ancho disponible
                .height(350.dp)
        )

        // Texto debajo de la imagen
        Text(
            text = "Cargando...",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = 30.sp // Cambia el tamaño de la fuente según lo que necesites
            ),
            modifier = Modifier
                .padding(top = 30.dp),  // Ajusta el espacio entre la barra y el texto
            color = Color.Gray
        )

        Text(
            text = "Estamos configurando tu dispositivo.",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(top = 13.dp)  // Ajusta el espacio entre la barra y el texto
                .align(Alignment.CenterHorizontally),
            color = Color.Gray
        )

        // Barra de progreso
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(66.dp)
                .padding(horizontal = 40.dp)
                .padding(top = 55.dp),  // Opcional: Añadimos algo de espacio entre la imagen y la barra
            color = Color.Cyan, // Puedes cambiar el color si lo deseas
            backgroundColor = Color.LightGray // Puedes cambiar el color del fondo de la barra si lo deseas
        )

        // Controlamos la separación entre el Switch y el texto adicional
        Text(
            text = "Proyecto Terminal II - Ing. Telematica",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(top = 265.dp) // Separación entre el Switch y el texto adicional
                .align(Alignment.CenterHorizontally),  // Centra el texto
            color = Color(0xFFaed6f1) // Azul claro personalizado con un valor hexadecimal
        )

    }
}


@Composable
fun PowerControlScreen(onNavigateToNext: () -> Unit) {
    var isPowerOn by remember { mutableStateOf(false) }

    // Detectar cuando el Switch cambia a ON
    LaunchedEffect(isPowerOn) {
        if (isPowerOn) {
            // Si el Switch se activa, navegamos automáticamente al Dashboard
            onNavigateToNext()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 5.dp, vertical = 10.dp),  // Ajusta el padding de la pantalla
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top // Alinea los elementos al inicio de la columna
    ) {
        // Imagen en la parte superior
        Image(
            painter = painterResource(Res.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()  // Hace que la imagen ocupe todo el ancho disponible
                .height(350.dp)
        )

        // Controlamos la separación entre la imagen y el texto "ON/OFF"
        Text(
            text = if (isPowerOn) "ON" else "OFF",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .padding(top = 50.dp) // Asegura que haya una separación entre la imagen y el texto
        )

        // Controlamos la separación entre el texto y el Switch
        Switch(
            checked = isPowerOn,
            onCheckedChange = { isPowerOn = it },
            modifier = Modifier
                .padding(top = 140.dp)  // Espacio entre el texto y el switch
                .height(14.dp)  // Mantiene la altura original del Switch
                .scale(4.9f) // Aumenta el tamaño del Switch sin afectar su altura
        )

        // Controlamos la separación entre el Switch y el texto adicional
        Text(
            text = "Proyecto Terminal II - Ing. Telematica",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(top = 200.dp) // Separación entre el Switch y el texto adicional
                .align(Alignment.CenterHorizontally),  // Centra el texto
            color = Color(0xFFaed6f1) // Azul claro personalizado con un valor hexadecimal
        )
    }
}
