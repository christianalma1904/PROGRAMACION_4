package com.example.basics.practica

fun main() {
    println("Introduce un número entero:")
    val n = readln().toIntOrNull() ?: 0

    println("\n--- Tabla del $n ---")

    for (i in 1..10) {
        val resultado = n * i
        println("$n x $i = $resultado")
    }

    println("------------------")
}