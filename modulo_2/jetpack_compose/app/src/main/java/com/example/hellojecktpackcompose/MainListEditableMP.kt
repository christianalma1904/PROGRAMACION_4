package com.example.hellojecktpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


data class Lote(val id: Int, val nombreDifunto: String, val sector: String)

class LoteEditableActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { LoteEditableApp() }
    }
}

@Composable
fun LoteEditableApp() {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = PrimaryDark1,
            background = BackgroundDark1,
            surface = BackgroundDark1,
            onPrimary = Color.White,
            onSurface = Color.LightGray,
            secondary = AccentGold1,
        )
    ) {
        Surface(Modifier.fillMaxSize()) { LoteEditableScreen() }
    }
}

@Composable
fun LoteEditableScreen() {
    var autoId by rememberSaveable { mutableStateOf(5) }
    val lotes = remember {
        mutableStateListOf(
            Lote(1, "Ana Torres Ruiz", "A3"),
            Lote(2, "Luis Pérez Gómez", "B1"),
            Lote(3, "María López Díaz", "C5"),
            Lote(4, "Carlos Ruiz Solís", "F2")
        )
    }

    var nombreDifuntoInput by rememberSaveable { mutableStateOf("") }
    var sectorInput by rememberSaveable { mutableStateOf("") }
    var seleccionado by remember { mutableStateOf<Lote?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "Gestión de Lotes (Agregar / Eliminar)",
            style = MaterialTheme.typography.titleLarge,
            color = AccentGold1
        )

        OutlinedTextField(
            value = nombreDifuntoInput,
            onValueChange = { nombreDifuntoInput = it },
            label = { Text("Nombre del Difunto") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = AccentGold1,
                cursorColor = AccentGold1
            )
        )
        OutlinedTextField(
            value = sectorInput,
            onValueChange = { sectorInput = it },
            label = { Text("Sector (Ej. A3)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = AccentGold1,
                cursorColor = AccentGold1
            )
        )
        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
            TextButton(onClick = { nombreDifuntoInput = ""; sectorInput = "" }) {
                Text("Limpiar", color = Color.Gray)
            }
            Spacer(Modifier.width(8.dp))
            Button(
                onClick = {
                    val n = nombreDifuntoInput.trim()
                    val s = sectorInput.trim().uppercase()
                    if (n.isNotEmpty() && s.isNotEmpty()) {
                        autoId += 1
                        lotes.add(Lote(autoId, n, s))
                        nombreDifuntoInput = ""; sectorInput = ""
                    }
                },
                enabled = nombreDifuntoInput.isNotBlank() && sectorInput.isNotBlank(),
                colors = ButtonDefaults.buttonColors(containerColor = AccentGold1)
            ) { Text("Registrar Lote", color = PrimaryDark1) }
        }

        Divider(color = AccentGold1.copy(alpha = 0.5f))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(lotes, key = { it.id }) { lote ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = PrimaryDark1)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { seleccionado = lote }
                        ) {
                            Text(lote.nombreDifunto, style = MaterialTheme.typography.titleMedium, color = Color.White)
                            Text("Sector: ${lote.sector}", style = MaterialTheme.typography.bodyMedium, color = AccentGold1)
                        }
                        TextButton(onClick = {
                            lotes.removeIf { it.id == lote.id }
                            if (seleccionado?.id == lote.id) seleccionado = null
                        }) { Text("Eliminar", color = OffrendaRed1) }
                    }
                }
            }
        }

        if (seleccionado != null) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = GraveDark1)
            ) {
                Column(Modifier.padding(12.dp)) {
                    Text("Lote Seleccionado:", style = MaterialTheme.typography.titleMedium, color = AccentGold1)
                    Text("ID: ${seleccionado!!.id}", color = Color.White)
                    Text("Nombre: ${seleccionado!!.nombreDifunto}", color = Color.White)
                    Text("Sector: ${seleccionado!!.sector}", color = Color.White)
                }
            }
        } else {
            Text("Selecciona un lote para ver detalles.", color = Color.LightGray)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewEditable() { LoteEditableApp() }