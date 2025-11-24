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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val PrimaryDark4 = Color(0xFF37474F)
val BackgroundDark4 = Color(0xFF263238)
val AccentGold4 = Color(0xFFFDD835)
val GraveDark4 = Color(0xFF5D4037)
val EmptyGreen4 = Color(0xFF4CAF50)
val OffrendaRed4 = Color(0xFFB71C1C)

data class Empleado(val id: Int, val nombre: String, val rol: String)

class MainListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ListaUsuariosApp1() }
    }
}

@Composable
fun ListaUsuariosApp1() {1
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = PrimaryDark4,
            background = BackgroundDark4,
            surface = BackgroundDark4,
            onPrimary = Color.White,
            onSurface = Color.LightGray,
            secondary = AccentGold4,
        )
    ) {
        Surface(Modifier.fillMaxSize()) {
            ListaUsuariosScreen1()
        }
    }
}

@Composable
fun ListaUsuariosScreen1() {
    val usuarios = remember {
        listOf(
            Empleado(1, "Ana Torres", "Diseñadora"),
            Empleado(2, "Luis Pérez", "Desarrollador"),
            Empleado(3, "María López", "Tester QA"),
            Empleado(4, "Carlos Ruiz", "Project Manager")
        )
    }

    var seleccionado by remember { mutableStateOf<Empleado?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "Lista de Empleados",
            style = MaterialTheme.typography.titleLarge,
            color = AccentGold4
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(usuarios) { user ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { seleccionado = user },
                    colors = CardDefaults.cardColors(containerColor = PrimaryDark4)
                ) {
                    Column(Modifier.padding(12.dp)) {
                        Text(
                            user.nombre,
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White
                        )
                        Text(
                            user.rol,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }

        Divider(color = AccentGold4.copy(alpha = 0.5f))

        if (seleccionado != null) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                colors = CardDefaults.cardColors(containerColor = GraveDark4)
            ) {
                Column(Modifier.padding(12.dp)) {
                    Text(
                        "Detalles del Empleado:",
                        style = MaterialTheme.typography.titleMedium,
                        color = AccentGold4
                    )
                    Text("Nombre: ${seleccionado!!.nombre}", color = Color.White)
                    Text("Rol: ${seleccionado!!.rol}", color = Color.White)
                }
            }
        } else {
            Text(
                "Selecciona un empleado para ver detalles.",
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLista() { ListaUsuariosApp() }