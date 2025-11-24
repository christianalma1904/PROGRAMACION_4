package com.example.hellojecktpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val PrimaryDark2 = Color(0xFF37474F)
val BackgroundDark2 = Color(0xFF263238)
val AccentGold2 = Color(0xFFFDD835)

class MainInputActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AppCampoTexto1() }
    }
}

@Composable
fun AppCampoTexto1() {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = PrimaryDark2,
            background = BackgroundDark2,
            surface = BackgroundDark2,
            onPrimary = Color.White,
            onSurface = Color.LightGray,
            secondary = AccentGold2,
        )
    ) {
        Surface(Modifier.fillMaxSize()) {
            CampoTextoScreen1()
        }
    }
}

@Composable
fun CampoTextoScreen1() {
    var nombre by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Escribe tu nombre", color = MaterialTheme.colorScheme.onSurface) },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = AccentGold2,
                unfocusedBorderColor = PrimaryDark2,
                cursorColor = AccentGold2,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.LightGray,
            ),
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Button(
            onClick = { nombre = "" },
            colors = ButtonDefaults.buttonColors(containerColor = AccentGold2)
        ) {
            Text("Limpiar", color = PrimaryDark2)
        }

        Text(
            text = if (nombre.isBlank()) "Aún no has escrito nada..." else "Hola, $nombre 👋",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CampoTextoPreview() { AppCampoTexto() }