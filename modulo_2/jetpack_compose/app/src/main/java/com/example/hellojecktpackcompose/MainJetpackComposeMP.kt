package com.example.hellojecktpackcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val PrimaryDark3 = Color(0xFF37474F)
val BackgroundDark3 = Color(0xFF263238)
val AccentGold3 = Color(0xFFFDD835)
val GraveDark3 = Color(0xFF5D4037)
val EmptyGreen3 = Color(0xFF4CAF50)
val OffrendaRed3 = Color(0xFFB71C1C)

class MainJetpackComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { HolaMundoApp1() }
    }
}

@Composable
fun HolaMundoApp1() {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = PrimaryDark3,
            background = BackgroundDark3,
            surface = BackgroundDark3,
            onPrimary = Color.White,
            onSurface = Color.LightGray,
            secondary = AccentGold3,
        )
    ) {
        Surface(Modifier.fillMaxSize()) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Hola, Jetpack Compose",
                    color = AccentGold3
                )
            }
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(top = 30.dp),
                contentAlignment = Alignment.TopStart
            ){
                Text(
                    "Hola, Desde Arriba",
                    color = EmptyGreen3,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHola() { HolaMundoApp() }