package com.example.basics.practica

fun main() {
    println("Introduce la primera nota (0-20):")
    val nota1 = readln().toIntOrNull() ?: -1

    println("Introduce la segunda nota (0-20):")
    val nota2 = readln().toIntOrNull() ?: -1

    println("Introduce la tercera nota (0-20):")
    val nota3 = readln().toIntOrNull() ?: -1

    if (nota1 < 0 || nota1 > 20 || nota2 < 0 || nota2 > 20 || nota3 < 0 || nota3 > 20) {
        println("ERROR: Una o más notas introducidas no son válidas (deben estar entre 0 y 20).")
        return
    }

    val promedio = (nota1 + nota2 + nota3) / 3.0

    println("\nEl promedio es: ${"%.2f".format(promedio)}")

    if (promedio >= 14) {
        println("Resultado: Aprobado")
    } else {
        println("Resultado: Reprobado")
    }
}