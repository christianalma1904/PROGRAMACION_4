package com.example.basic

fun main() {
    println("🕯SISTEMA DE MI CEMENTERIO - CÁLCULO DE OFRENDAS")
    println("Ingrese el número de tumbas en el sector a calcular: ")

    val tumbas: Int = readLine()?.toIntOrNull() ?: 0

    println("\nTabla de Ofrendas (Velas por Tumba)")
    println("Cada fila representa las velas que se deben colocar si cada tumba tiene diferente cantidad:")

    for (i in 0..12 step 1) {
        println("$i.   $tumbas tumbas × $i velas = ${tumbas * i} velas en total")
    }

    println("\nContexto:")
    println("El cuidador del Cementerio Jardines del Silencio Christian Alcocer utiliza esta tabla para saber cuántas velas encender en cada ronda,")
    println("dependiendo del número de tumbas y la cantidad de velas por tumba.")
    println("De esta forma, mantiene viva la luz del recuerdo en cada rincón del camposanto")
}
