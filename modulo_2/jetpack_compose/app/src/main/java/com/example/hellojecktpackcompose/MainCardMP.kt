package com.example.hellojecktpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val PrimaryDark1 = Color(0xFF37474F)
val BackgroundDark1 = Color(0xFF263238)
val AccentGold1 = Color(0xFFFDD835)
val GraveDark1 = Color(0xFF5D4037)
val EmptyGreen1 = Color(0xFF4CAF50)
val OffrendaRed1 = Color(0xFFB71C1C)


class CementerioCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Llama al módulo principal de la aplicación
        setContent { CementerioAppModule() }
    }
}


@Composable
fun MonumentoDetalleScreen() {
    // Estado para gestionar la ofrenda virtual
    var ofrendaEnviada by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = PrimaryDark1),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Detalle del Monumento",
                color = AccentGold1,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Ricardo Gómez Pérez",
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
            Text(
                text = "1945 - 2020",
                fontSize = 18.sp,
                color = Color.LightGray,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Divider(color = AccentGold1.copy(alpha = 0.5f), thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp)) // Uso de AccentGold1

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Sector:", color = Color.White)
                Text("A3", color = AccentGold1, fontWeight = FontWeight.SemiBold)
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Lote:", color = Color.White)
                Text("12B", color = AccentGold1, fontWeight = FontWeight.SemiBold)
            }

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = { ofrendaEnviada = !ofrendaEnviada },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (ofrendaEnviada) Color.Gray else OffrendaRed1
                ),
                enabled = !ofrendaEnviada,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Filled.Favorite, contentDescription = "Ofrenda", tint = Color.White)
                Spacer(Modifier.width(8.dp))
                Text(
                    text = if (ofrendaEnviada) "Ofrenda Enviada (Gracias)" else "Dejar Ofrenda Virtual",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            if (ofrendaEnviada) {
                Text(
                    text = "Tu luz ha sido encendida en este monumento.",
                    color = EmptyGreen1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}


@Composable
fun RegistroLoteComponent() {
    // Nombres de variables cambiados para ser únicos
    var loteNombreDifunto by rememberSaveable { mutableStateOf("Juan Pérez") }
    var loteEstadoOcupado by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(BackgroundDark1, MaterialTheme.shapes.medium), // Uso de BackgroundDark1
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Registro de Lote (Formulario)",
            color = AccentGold1, // Uso de AccentGold1
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        // Campo de texto
        OutlinedTextField(
            value = loteNombreDifunto,
            onValueChange = { loteNombreDifunto = it },
            label = { Text("Nombre del Difunto / Título del Lote", color = Color.Gray) },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.LightGray,
                focusedBorderColor = AccentGold1, // Uso de AccentGold1
                unfocusedBorderColor = PrimaryDark1, // Uso de PrimaryDark1
                cursorColor = AccentGold1 // Uso de AccentGold1
            ),
            modifier = Modifier.fillMaxWidth()
        )

        // Switch de Ocupación
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Lote Ocupado",
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            Switch(
                checked = loteEstadoOcupado,
                onCheckedChange = { loteEstadoOcupado = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = GraveDark1, // Uso de GraveDark1
                    checkedTrackColor = GraveDark1.copy(alpha = 0.5f), // Uso de GraveDark1
                    uncheckedThumbColor = EmptyGreen1, // Uso de EmptyGreen1
                    uncheckedTrackColor = EmptyGreen1.copy(alpha = 0.5f) // Uso de EmptyGreen1
                )
            )
        }

        // Tarjeta de Visualización del Estado
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = PrimaryDark1), // Uso de PrimaryDark1
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                // Indicador de Estado
                Box(Modifier.size(48.dp).clip(CircleShape).background(if (loteEstadoOcupado) GraveDark1 else EmptyGreen1)) { // Uso de GraveDark1, EmptyGreen1
                    Icon(if (!loteEstadoOcupado) Icons.Filled.LocationOn else Icons.Filled.Warning, contentDescription = "Estado", tint = Color.White, modifier = Modifier.align(Alignment.Center).size(30.dp))
                }
                Column(Modifier.padding(start = 12.dp)) {
                    Text(text = if (loteNombreDifunto.isBlank()) "Lote sin Asignar" else loteNombreDifunto, style = MaterialTheme.typography.titleMedium, color = Color.White)
                    Text(text = if (loteEstadoOcupado) "Estado: Ocupado 💀" else "Estado: Disponible ✅", style = MaterialTheme.typography.bodySmall, color = if (loteEstadoOcupado) AccentGold1 else EmptyGreen1) // Uso de AccentGold1, EmptyGreen1
                }
            }
        }
    }
}

/**
 * 3. Componente: Búsqueda de Difunto
 * Simula la funcionalidad de búsqueda.
 */
@Composable
fun DifuntoBusquedaFeature() {
    // Nombres de variables cambiados
    var nombreHalladoBusqueda by remember { mutableStateOf("") }
    var busquedaActiva by remember { mutableStateOf(false) }
    var textoInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(PrimaryDark1, MaterialTheme.shapes.medium), // Uso de PrimaryDark1
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Buscador Rápido", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 16.dp))
        Spacer(Modifier.height(8.dp))

        // Campo para ingresar la búsqueda
        OutlinedTextField(
            value = textoInput,
            onValueChange = { textoInput = it },
            label = { Text("Ingrese el nombre del difunto", color = Color.Gray) },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.LightGray,
                focusedBorderColor = AccentGold1, // Uso de AccentGold1
                unfocusedBorderColor = BackgroundDark1, // Uso de BackgroundDark1
                cursorColor = AccentGold1 // Uso de AccentGold1
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))

        if (busquedaActiva) {
            CircularProgressIndicator(color = AccentGold1) // Uso de AccentGold1
        } else if (nombreHalladoBusqueda.isNotEmpty()) {
            Text(
                text = "¡Encontrado! ${nombreHalladoBusqueda}",
                color = AccentGold1, // Uso de AccentGold1
                fontSize = 18.sp,
                modifier = Modifier.padding(12.dp)
            )
            Text(text = "Sector G, Lote 45", color = Color.LightGray)
        } else {
            Text(text = "Resultado de la búsqueda aparecerá aquí.", color = Color.Gray, modifier = Modifier.padding(12.dp))
        }

        Spacer(Modifier.height(16.dp))

        // Botón que simula la búsqueda
        Button(
            onClick = {
                busquedaActiva = true
                nombreHalladoBusqueda = ""
                // Simulación de búsqueda (tardar 1 segundo en entorno real)
                nombreHalladoBusqueda = if (textoInput.isNotBlank()) textoInput.uppercase() else "María Elena Rosales"
                busquedaActiva = false
            },
            colors = ButtonDefaults.buttonColors(containerColor = AccentGold1), // Uso de AccentGold1
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Icon(Icons.Filled.Search, contentDescription = "Buscar", tint = PrimaryDark1) // Uso de PrimaryDark1
            Spacer(Modifier.width(8.dp))
            Text("Iniciar Búsqueda", color = PrimaryDark1, fontWeight = FontWeight.Bold) // Uso de PrimaryDark1
        }
    }
}

/**
 * 4. Componente: Interruptor de Navegación GPS
 * Simula la activación de la guía de ubicación.
 */
@Composable
fun NavegacionUbicacionSwitch() {
    var gpsActivo by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(PrimaryDark1, MaterialTheme.shapes.medium) // Uso de PrimaryDark1
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(Icons.Filled.LocationOn, contentDescription = "Ubicación", tint = Color.White)
        Spacer(Modifier.width(16.dp))
        Column(Modifier.weight(1f)) {
            Text(text = "Guía de Navegación GPS", color = Color.White, fontWeight = FontWeight.SemiBold)
            Text(text = if (gpsActivo) "Activo: Ruta al lote" else "Desactivado", color = if (gpsActivo) AccentGold1 else Color.Gray, fontSize = 12.sp) // Uso de AccentGold1
        }

        // Interruptor
        Switch(
            checked = gpsActivo,
            onCheckedChange = { gpsActivo = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = AccentGold1, // Uso de AccentGold1
                uncheckedThumbColor = Color.LightGray,
                checkedTrackColor = AccentGold1.copy(alpha = 0.5f) // Uso de AccentGold1
            )
        )
    }
}

/**
 * 5. Componente: Contador de Visitas
 * Simula el registro de una visita.
 */
@Composable
fun VisitasContadorFeature() {
    var totalVisitas by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(PrimaryDark1, MaterialTheme.shapes.medium) // Uso de PrimaryDark1
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Registro de Visitas", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(16.dp))

        Text(
            text = "Total Registrado: $totalVisitas",
            color = AccentGold1, // Uso de AccentGold1
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Monospace
        )
        Spacer(Modifier.height(16.dp))

        // Botón para incrementar el contador
        Button(
            onClick = { totalVisitas++ },
            colors = ButtonDefaults.buttonColors(containerColor = AccentGold1) // Uso de AccentGold1
        ) {
            Text("Registrar Nueva Visita (+1)", color = PrimaryDark1, fontWeight = FontWeight.Bold) // Uso de PrimaryDark1
        }
    }
}


// --- Módulo Principal de la Aplicación (ROOT) ---

@Composable
fun CementerioAppModule() {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = PrimaryDark1, // Uso de PrimaryDark1
            background = BackgroundDark1, // Uso de BackgroundDark1
            surface = BackgroundDark1, // Uso de BackgroundDark1
            onPrimary = Color.White,
            onBackground = Color.LightGray
        )
    ) {
        Surface(Modifier.fillMaxSize()) {
            // Contenedor principal con Scroll
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(BackgroundDark1) // Uso de BackgroundDark1
                    .verticalScroll(rememberScrollState())
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Título de la Aplicación
                Text(
                    text = "Sistema de Gestión Cementerio",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = AccentGold1, // Uso de AccentGold1
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Llamada a los componentes individuales con nombres robustos
                MonumentoDetalleScreen()
                RegistroLoteComponent()
                DifuntoBusquedaFeature()
                NavegacionUbicacionSwitch()
                VisitasContadorFeature()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CementerioModulePreview() { CementerioAppModule() }