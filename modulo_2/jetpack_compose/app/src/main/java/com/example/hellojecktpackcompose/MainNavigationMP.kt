package com.example.hellojecktpackcompose


import android.os.Bundle
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
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
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument


data class LoteCementerio(val id: Int, val nombreDifunto: String, val sector: String)

class LoteNavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { LoteNavigationApp() }
    }
}

@Composable
fun LoteNavigationApp() {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = PrimaryDark1,
            background = BackgroundDark1,
            surface = PrimaryDark1,
            onPrimary = Color.White,
            onSurface = Color.LightGray,
            secondary = AccentGold1,
            surfaceContainerHigh = GraveDark1
        )
    ) {
        Surface(Modifier.fillMaxSize()) {
            val nav = rememberNavController()
            NavHost(navController = nav, startDestination = "home") {

                composable("home") {
                    HomeScreen(
                        onOpenDetail = { id, difunto, sector ->
                            val safeDifunto = URLEncoder.encode(difunto, StandardCharsets.UTF_8.toString())
                            val safeSector = URLEncoder.encode(sector, StandardCharsets.UTF_8.toString())
                            nav.navigate("detail/$id/$safeDifunto/$safeSector")
                        }
                    )
                }

                composable(
                    route = "detail/{id}/{difunto}/{sector}",
                    arguments = listOf(
                        navArgument("id") { type = NavType.IntType },
                        navArgument("difunto") { type = NavType.StringType },
                        navArgument("sector") { type = NavType.StringType }
                    )
                ) { backStack ->
                    val id = backStack.arguments?.getInt("id") ?: -1
                    val difunto = backStack.arguments?.getString("difunto") ?: ""
                    val sector = backStack.arguments?.getString("sector") ?: ""
                    DetailScreen(
                        id = id,
                        nombreDifunto = difunto,
                        sector = sector,
                        onBack = { nav.popBackStack() }
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(onOpenDetail: (Int, String, String) -> Unit) {
    val lotes = remember {
        listOf(
            LoteCementerio(1, "Ana Torres Ruiz", "A3"),
            LoteCementerio(2, "Luis Pérez Gómez", "B1"),
            LoteCementerio(3, "María López Díaz", "C5"),
            LoteCementerio(4, "Carlos Ruiz Solís", "F2"),
            LoteCementerio(5, "Elena Martín Gil", "H7")
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "Mapa del Cementerio: 5 Lotes",
            style = MaterialTheme.typography.titleLarge,
            color = AccentGold1
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(lotes, key = { it.id }) { lote ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onOpenDetail(lote.id, lote.nombreDifunto, lote.sector) },
                    colors = CardDefaults.cardColors(containerColor = PrimaryDark1)
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                "Lote #${lote.id} - Sector ${lote.sector}",
                                style = MaterialTheme.typography.titleMedium,
                                color = AccentGold1
                            )
                            Text(
                                lote.nombreDifunto,
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DetailScreen(id: Int, nombreDifunto: String, sector: String, onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Detalle del Lote",
            style = MaterialTheme.typography.titleLarge,
            color = AccentGold1
        )
        Card(
            Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = GraveDark1)
        ) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    "Identificador: LOTE-$id",
                    style = MaterialTheme.typography.titleMedium,
                    color = AccentGold1
                )
                Divider(color = Color.White.copy(alpha = 0.3f))
                Text("Difunto: $nombreDifunto", style = MaterialTheme.typography.bodyLarge, color = Color.White)
                Text("Sector de Entierro: $sector", style = MaterialTheme.typography.bodyLarge, color = Color.White)
            }
        }
        Button(
            onClick = onBack,
            colors = ButtonDefaults.buttonColors(containerColor = OffrendaRed1)
        ) { Text("Volver a la Lista", color = Color.White) }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHome() { MaterialTheme { HomeScreen { _, _, _ -> } } }

@Preview(showBackground = true)
@Composable
private fun PreviewDetail() { MaterialTheme { DetailScreen(9, "Juan El Eterno", "Z99", onBack = {}) } }