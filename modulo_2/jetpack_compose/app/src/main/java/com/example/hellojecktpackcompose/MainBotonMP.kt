package com.example.hellojecktpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val PrimaryDark = Color(0xFF37474F)
val BackgroundDark = Color(0xFF263238)
val AccentGold = Color(0xFFFDD835)

class CementerioAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AppPrincipalCementerio() }
    }
}

/**
 * 1. Ejemplo: Búsqueda de Difunto
 * Muestra el nombre del difunto al hacer clic en buscar, simulando una búsqueda exitosa.
 */
@Composable
fun BusquedaDifunto() {
    var difuntoEncontrado by remember { mutableStateOf("") }
    var buscando by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(PrimaryDark, MaterialTheme.shapes.medium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Buscar Difunto",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )
        Spacer(Modifier.height(8.dp))

        if (buscando && difuntoEncontrado.isEmpty()) {
            CircularProgressIndicator(color = AccentGold)
        } else if (difuntoEncontrado.isNotEmpty()) {
            Text(
                text = "Encontrado: ${difuntoEncontrado}",
                color = AccentGold,
                fontSize = 18.sp,
                modifier = Modifier.padding(12.dp)
            )
            Text(
                text = "Sector G, Lote 45",
                color = Color.LightGray
            )
        } else {
            Text(
                text = "Ingrese el nombre para buscar...",
                color = Color.Gray,
                modifier = Modifier.padding(12.dp)
            )
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                buscando = true
                difuntoEncontrado = ""
                if (!buscando) {
                    difuntoEncontrado = "María Elena Rosales"
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = AccentGold),
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Icon(Icons.Filled.Search, contentDescription = "Buscar", tint = PrimaryDark)
            Spacer(Modifier.width(8.dp))
            Text("Iniciar Búsqueda", color = PrimaryDark)
        }
    }
}


@Composable
fun UbicacionMapa() {
    // Estado booleano similar a tu ejemplo, pero usado para un Switch
    var guiaActiva by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(PrimaryDark, MaterialTheme.shapes.medium)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(Icons.Filled.LocationOn, contentDescription = "Ubicación", tint = Color.White)
        Spacer(Modifier.width(16.dp))
        Column(Modifier.weight(1f)) {
            Text(
                text = "Guía de Navegación",
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = if (guiaActiva) "GPS Activo - Ruta al lote" else "Desactivado",
                color = if (guiaActiva) AccentGold else Color.Gray,
                fontSize = 12.sp
            )
        }

        Switch(
            checked = guiaActiva,
            onCheckedChange = { guiaActiva = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = AccentGold,
                checkedTrackColor = AccentGold.copy(alpha = 0.5f),
                uncheckedThumbColor = Color.LightGray,
                uncheckedTrackColor = Color.DarkGray
            )
        )
    }
}


@Composable
fun RegistroVisitas() {
    // Estado para un contador (Int)
    var contadorVisitas by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(PrimaryDark, MaterialTheme.shapes.medium)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Registro de Visitas al Lote",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(16.dp))

        Text(
            text = "Visitas registradas: $contadorVisitas",
            color = AccentGold,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace
        )
        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { contadorVisitas++ },
            colors = ButtonDefaults.buttonColors(containerColor = AccentGold)
        ) {
            Text("Registrar Visita (+1)", color = PrimaryDark)
        }
    }
}


@Composable
fun AppPrincipalCementerio() {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = PrimaryDark,
            background = BackgroundDark,
            surface = BackgroundDark,
            onPrimary = Color.White,
            onBackground = Color.LightGray
        )
    ) {
        Surface(Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BackgroundDark)
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Cementerio App",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = AccentGold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                BusquedaDifunto()
                UbicacionMapa()
                RegistroVisitas()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CementerioPreview() { AppPrincipalCementerio() }