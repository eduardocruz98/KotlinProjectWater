package org.example.project.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.getColorsTheme

@Composable
fun dashConexion() {
    var checked2 by remember { mutableStateOf(true) }
    var checked3 by remember { mutableStateOf(true) }
    val colors = getColorsTheme()

    Text(
        text = "Conexión",
        fontWeight = FontWeight.SemiBold,
        fontSize = 25.sp,
        color = colors.textColor
    )

    Spacer(modifier = Modifier.height(46.dp))  // Ajusté el espacio

    // Fila para alinear texto a la izquierda y Switch centrado
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 32.dp)  // Ajusta el margen izquierdo (start) y derecho (end)
        ,
        horizontalArrangement = Arrangement.Center // Centra el contenido horizontalmente
    ) {
        Text(
            text = "N O D O  1",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.weight(1f) // El texto ocupa todo el espacio disponible
        )
        Switch(
            checked = checked2,
            onCheckedChange = {
                checked2 = it
            },
            modifier = Modifier.scale(2.1f) // Aumenta el tamaño del Switch sin afectar su altura
        )
    }



    Spacer(modifier = Modifier.height(46.dp))  // Ajusté el espacio

    // Fila para alinear texto a la izquierda y Switch centrado
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 32.dp)  // Ajusta el margen izquierdo (start) y derecho (end)
        ,
        horizontalArrangement = Arrangement.Center // Centra el contenido horizontalmente
    ) {
        Text(
            text = "N O D O  2",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.weight(1f) // El texto ocupa todo el espacio disponible
        )
        Switch(
            checked = checked3,
            onCheckedChange = {
                checked3 = it
            },
            modifier = Modifier.scale(2.1f), // Aumenta el tamaño del Switch sin afectar su altura
            //colors = SwitchDefaults.colors(
            //  checkedThumbColor = Color.Green,    // Color cuando el Switch está activado (thumb)
            //uncheckedThumbColor = Color.Red,    // Color cuando el Switch está desactivado (thumb)
            //checkedTrackColor = Color.Gray, // Color del fondo cuando el Switch está activado
            //uncheckedTrackColor = Color.Gray    // Color del fondo cuando el Switch está desactivado
            //)
        )
    }


    // Detectar cuando el Switch cambia a ON
    LaunchedEffect(checked2) {
        if (checked2) {
            // Si el Switch se activa, se activan las notificaciones
        }
    }

    // Detectar cuando el Switch cambia a ON
    LaunchedEffect(checked3) {
        if (checked3) {
            // Si el Switch se activa, se activan las notificaciones
        }
    }


} //END dashConexion()
