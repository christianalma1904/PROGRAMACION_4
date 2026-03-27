package com.example.basic

fun main() {
    println("🕯BUCLES EN EL CEMENTERIO")

    val tumbas = listOf("María", "José", "Lucía")

    // Recorriendo lista de tumbas
    println("\nRegistro de tumbas:")
    for ((index, tumba) in tumbas.withIndex()) {
        println("${index + 1}. Tumba de $tumba")
    }

    // Por rango con paso
    println("\nEncendiendo velas cada 5 metros del camino:")
    for (i in 0..20 step 5) {
        println("Encendidas hasta el metro $i")
    }

    // Rangos descendentes
    println("\nCuenta regresiva para el cierre del cementerio:")
    for (countdown in 10 downTo 1) {
        println("Cierre en: $countdown minutos...")
    }

    // Control de flujo: saltar tumbas especiales
    println("\nRonda nocturna:")
    for (tumba in tumbas) {
        if (tumba == "Lucía") continue // tumba en mantenimiento
        if (tumba == "Rafael") continue // tumba protegida por historia local
        println("Revisando tumba de $tumba...")
    }

    // Recorriendo con índice y salto de condiciones
    println("\nLimpieza de tumbas (exceptuando las protegidas):")
    for ((index, tumba) in tumbas.withIndex()) {
        if (tumba == "Lucía") continue
        if (tumba == "Rafael") continue
        println("Limpieza realizada en ${index + 1}. Tumba de $tumba")
    }

    println("\nContexto:")
    println("El cuidador Christian Alcocer realiza su ronda nocturna revisando y limpiando las tumbas.")
    println("Algunas tumbas, como las de Lucía y Rafael, no deben tocarse por respeto o mantenimiento especial.")
}