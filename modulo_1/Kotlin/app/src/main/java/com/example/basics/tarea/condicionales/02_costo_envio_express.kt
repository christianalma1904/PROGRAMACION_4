package com.example.envios

fun main() {

    // 1. Pedir distancia usando readLine()
    println("Ingrese la distancia del envío en kilómetros (km):")
    val distancia = readLine()?.toIntOrNull() ?: 0 // Si es nulo o inválido, asumimos 0 km

    // 2. Pedir si llueve
    println("¿Está lloviendo actualmente? (sí/no):")
    val llueveRespuesta = readLine().orEmpty().trim().lowercase() // Usamos orEmpty() para evitar nulos

    // 3. Calcular el costo total
    val costoTotal = calcularCostoEnvio(distancia, llueveRespuesta)

    println("\nRESULTADO DEL ENVÍO")
    println("Distancia: ${distancia} km")
    println("Lluvia: ${if (llueveRespuesta == "sí") "Sí" else "No"}")
    println("Costo total: ${String.format("%.2f", costoTotal)} €")
}

fun calcularCostoEnvio(distancia: Int, llueve: String): Double {
    var costoBase: Double = 0.0
    val recargoLluvia: Double = 1.5

    // Determinar el costo base según la distancia
    costoBase = when (distancia) {
        in 0..5 -> 2.5
        in 6..15 -> 5.0
        else -> 8.0
    }

    // Aplicar el recargo por lluvia
    if (llueve == "sí") {
        costoBase += recargoLluvia
    }

    return costoBase
}