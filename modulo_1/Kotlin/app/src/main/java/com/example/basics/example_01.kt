package com.example.basic

fun main() {
    // Pedimos los datos al usuario
    print("Ingresar promedio: ")
    val promedio = readLine()?.toDoubleOrNull() ?: 0.0

    print("¿Trabaja? (si / no): ")
    val trabaja = readLine()?.lowercase()

    // Usamos if-else
    if (promedio >= 90 && trabaja == "no") {
        println("Beca completa")
    } else if (promedio >= 90 && trabaja == "si") {
        println("Beca parcial")
    } else if (promedio < 90 && trabaja == "no") {
        println("Sin beca")
    } else {
        println("No aplica a ninguna categoría.")
    }
}
