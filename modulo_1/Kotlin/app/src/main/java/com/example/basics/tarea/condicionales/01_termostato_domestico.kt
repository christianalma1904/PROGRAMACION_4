package com.example.controlclima

fun main() {

    // 1. Pedir temperatura
    println("Ingrese la temperatura actual en grados Celsius (°C):")
    val temperatura = readLine()?.toDoubleOrNull() ?: 0.0

    // 2. Pedir preferencia
    println("Ingrese su preferencia ('frío', 'templado', 'caliente'):")
    val preferenciaUsuario = readLine().orEmpty().trim().lowercase()

    // 3. Evaluar y mostrar la recomendación
    val recomendacion = evaluarClima(temperatura, preferenciaUsuario)

    println("\nRECOMENDACIÓN DEL TERMOSTATO")
    println("Temperatura: ${temperatura}°C, Preferencia: $preferenciaUsuario")
    println("Acción Sugerida: $recomendacion")
}

fun evaluarClima(temp: Double, pref: String): String {
    return when (pref) {
        "frío" -> {
            if (temp > 22) {
                "Encender aire"
            } else {
                "Ventilar" // (Si Temp <= 22)
            }
        }

        "caliente" -> {
            if (temp < 18) {
                "Encender calefacción"
            } else {
                "Ventilar" // (Si Temp >= 18)
            }
        }

        "templado" -> {
            // Verifica el rango 18.0 a 22.0 (inclusivo)
            if (temp >= 18 && temp <= 22) {
                "En confort"
            } else {
                "Ventilar" // (Si Temp < 18 o Temp > 22)
            }
        }
        else -> "Ventilar"
    }
}