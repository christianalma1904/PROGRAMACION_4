package com.example.basic

fun main() {
    println("BIENVENIDO AL SISTEMA DE MI CEMENTERIO")
    println("Ingrese la cantidad de tumbas en el Sector A:")
    val sectorA: Int = readLine()?.toIntOrNull() ?: 0

    println("Ingrese la cantidad de tumbas en el Sector B:")
    val sectorB: Int = readLine()?.toIntOrNull() ?: 0

    println("Ingrese la operación a realizar:")
    println("Opciones: + (sumar), - (restar), * (multiplicar), / (dividir)")
    val operacion: String = readln()

    when (operacion) {
        "+" -> println("Total de tumbas: ${sectorA + sectorB}")
        "-" -> println("Diferencia entre sectores: ${sectorA - sectorB}")
        "*" -> println("Total de flores si cada tumba tiene flores en ambos sectores: ${sectorA * sectorB}")
        "/" -> {
            if (sectorB != 0) {
                println("Promedio de tumbas por sector: ${sectorA / sectorB}")
            } else {
                println("No se puede dividir por cero (no hay tumbas en el Sector B)")
            }
        }
        else -> println("Operación no reconocida. Solo se permite +, -, * o /")
    }

    println("\nContexto:")
    println("El cuidador del Cementerio Jardines del Silencio(Yo, Christian Alcocer) utiliza este sistema para calcular la cantidad total de tumbas,")
    println("comparar sectores, estimar flores necesarias o conocer el promedio de mantenimiento.")
}
