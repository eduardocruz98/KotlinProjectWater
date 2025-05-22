package org.example.project.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Switch
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.getColorsTheme

@Composable
fun dashNotificaciones() {
    var checked by remember { mutableStateOf(true) }
    val colors = getColorsTheme()

    Text(
        text = "Notificaciones",
        fontWeight = FontWeight.SemiBold,
        fontSize = 25.sp,
        color = colors.textColor
    )

    Spacer(modifier = Modifier.height(46.dp))  // Ajusté el espacio

    // Fila para alinear texto a la izquierda y Switch a la derecha
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)  // Ajusta el margen izquierdo y derecho
    ) {
        Text(
            text = "Activar/Desactivar\nNotificaciones",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f) // El texto ocupa todo el espacio disponible
        )
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            },
            modifier = Modifier.scale(2.1f) // Aumenta el tamaño del Switch sin afectar su altura
        )
    }

    Spacer(modifier = Modifier.height(25.dp))

    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        // Notificaciones del N O D O  1
        Text(
            text = "Historial de Notificaciones",
            style = MaterialTheme.typography.headlineSmall
        )

        // Temperatura NODO1
        Box(
            modifier = Modifier.padding(12.dp)
        ) {
            // Column para Temperatura
            Column(
                modifier = Modifier
                    .fillMaxWidth()  // Ancho completo de la pantalla
                    .padding(horizontal = 6.dp), // Un poco de padding a los lados
                verticalArrangement = Arrangement.Top, // Alineación vertical
            ) {
                // Fila para el texto de temperatura y el icono
                Row(
                    modifier = Modifier
                        .fillMaxWidth(), // Ancho completo de la pantalla
                    verticalAlignment = Alignment.CenterVertically, // Alineación vertical
                    horizontalArrangement = Arrangement.SpaceBetween // El texto a la izquierda y el icono a la derecha
                ) {
                    // Texto de temperatura
                    Text(
                        text = "Temperatura",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(1f), // El texto ocupa el espacio disponible
                        textAlign = TextAlign.Left // Alinear el texto a la izquierda
                    )

                    // Icono de temperatura a la derecha
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "Información de temperatura",
                        modifier = Modifier.size(30.dp), // Tamaño del icono
                        tint = Color.Gray // El color del icono
                    )
                }

                Spacer(modifier = Modifier.height(4.dp)) // Espacio entre los textos

                // Segundo texto debajo del de "Temperatura"
                Text(
                    text = "La temperatura del Nodo1 es: 35 °C",  // Nuevo texto
                    style = MaterialTheme.typography.bodyMedium, // Estilo de texto (puedes ajustarlo)
                    color = Color.Gray, // Color del texto
                    modifier = Modifier.fillMaxWidth(), // Aseguramos que ocupe todo el ancho
                    textAlign = TextAlign.Left // Alinear el texto a la izquierda
                )
            } //END Column Temperatura
        }

        // Box de pH  N O D O  1
        Box(
            modifier = Modifier.padding(12.dp)
        ) {
            // Column para pH
            Column(
                modifier = Modifier
                    .fillMaxWidth()  // Ancho completo de la pantalla
                    .padding(horizontal = 6.dp), // Un poco de padding a los lados
                verticalArrangement = Arrangement.Top, // Alineación vertical
            ) {
                // Fila para el texto de pH y el icono
                Row(
                    modifier = Modifier
                        .fillMaxWidth(), // Ancho completo de la pantalla
                    verticalAlignment = Alignment.CenterVertically, // Alineación vertical
                    horizontalArrangement = Arrangement.SpaceBetween // El texto a la izquierda y el icono a la derecha
                ) {
                    // Texto de pH
                    Text(
                        text = "pH",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(1f), // El texto ocupa el espacio disponible
                        textAlign = TextAlign.Left // Alinear el texto a la izquierda
                    )

                    // Icono de pH a la derecha
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "Información de pH",
                        modifier = Modifier.size(30.dp), // Tamaño del icono
                        tint = Color.Gray // El color del icono
                    )
                }

                Spacer(modifier = Modifier.height(4.dp)) // Espacio entre los textos

                // Segundo texto debajo del de "pH"
                Text(
                    text = "El pH del Nodo1 es: 6.5",  // Nuevo texto
                    style = MaterialTheme.typography.bodyMedium, // Estilo de texto (puedes ajustarlo)
                    color = Color.Gray, // Color del texto
                    modifier = Modifier.fillMaxWidth(), // Aseguramos que ocupe todo el ancho
                    textAlign = TextAlign.Left // Alinear el texto a la izquierda
                )
            } //END Column pH
        }

        // Box de Turbidez  N O D O  1
        Box(
            modifier = Modifier.padding(12.dp)
        ) {
            // Column para Turbidez
            Column(
                modifier = Modifier
                    .fillMaxWidth()  // Ancho completo de la pantalla
                    .padding(horizontal = 6.dp), // Un poco de padding a los lados
                verticalArrangement = Arrangement.Top, // Alineación vertical
            ) {
                // Fila para el texto de Turbidez y el icono
                Row(
                    modifier = Modifier
                        .fillMaxWidth(), // Ancho completo de la pantalla
                    verticalAlignment = Alignment.CenterVertically, // Alineación vertical
                    horizontalArrangement = Arrangement.SpaceBetween // El texto a la izquierda y el icono a la derecha
                ) {
                    // Texto de Turbidez
                    Text(
                        text = "Turbidez",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(1f), // El texto ocupa el espacio disponible
                        textAlign = TextAlign.Left // Alinear el texto a la izquierda
                    )

                    // Icono de Turbidez a la derecha
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "Información de Turbidez",
                        modifier = Modifier.size(30.dp), // Tamaño del icono
                        tint = Color.Gray // El color del icono
                    )
                }

                Spacer(modifier = Modifier.height(4.dp)) // Espacio entre los textos

                // Segundo texto debajo del de "Turbidez"
                Text(
                    text = "La Turbidez del Nodo1 es: 4.0",  // Nuevo texto
                    style = MaterialTheme.typography.bodyMedium, // Estilo de texto (puedes ajustarlo)
                    color = Color.Gray, // Color del texto
                    modifier = Modifier.fillMaxWidth(), // Aseguramos que ocupe todo el ancho
                    textAlign = TextAlign.Left // Alinear el texto a la izquierda
                )
            } //END Column Turbidez
        }

        // Box de Turbidez  N O D O  2 - por ejemplo
        Box(
            modifier = Modifier.padding(12.dp)
        ) {
            // Column para Turbidez
            Column(
                modifier = Modifier
                    .fillMaxWidth()  // Ancho completo de la pantalla
                    .padding(horizontal = 6.dp), // Un poco de padding a los lados
                verticalArrangement = Arrangement.Top, // Alineación vertical
            ) {
                // Fila para el texto de Turbidez y el icono
                Row(
                    modifier = Modifier
                        .fillMaxWidth(), // Ancho completo de la pantalla
                    verticalAlignment = Alignment.CenterVertically, // Alineación vertical
                    horizontalArrangement = Arrangement.SpaceBetween // El texto a la izquierda y el icono a la derecha
                ) {
                    // Texto de Turbidez
                    Text(
                        text = "Turbidez",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(1f), // El texto ocupa el espacio disponible
                        textAlign = TextAlign.Left // Alinear el texto a la izquierda
                    )

                    // Icono de Turbidez a la derecha
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "Información de Turbidez",
                        modifier = Modifier.size(30.dp), // Tamaño del icono
                        tint = Color.Gray // El color del icono
                    )
                }

                Spacer(modifier = Modifier.height(4.dp)) // Espacio entre los textos

                // Segundo texto debajo del de "Turbidez"
                Text(
                    text = "La Turbidez del Nodo2 es: 4.0",  // Nuevo texto
                    style = MaterialTheme.typography.bodyMedium, // Estilo de texto (puedes ajustarlo)
                    color = Color.Gray, // Color del texto
                    modifier = Modifier.fillMaxWidth(), // Aseguramos que ocupe todo el ancho
                    textAlign = TextAlign.Left // Alinear el texto a la izquierda
                )
            } //END Column Turbidez
        }
    } //END Column() MAIN

    // Detectar cuando el Switch cambia a ON
    LaunchedEffect(checked) {
        if (checked) {
            // Si el Switch se activa, se activan las notificaciones
        }
    }
}

