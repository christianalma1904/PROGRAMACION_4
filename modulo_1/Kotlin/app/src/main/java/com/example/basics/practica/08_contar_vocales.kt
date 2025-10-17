package com.example.basics.practica

fun main() {
    println("Escribe un texto o frase:")
    val texto = readln()

    var contadorVocales = 0

    for (caracter in texto) {
        when (caracter) {
            'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' -> {
                contadorVocales++
            }
        }
    }

    println("\nResultado")
    println("El texto \"$texto\" tiene $contadorVocales vocales (a, e, i, o, u).")
}