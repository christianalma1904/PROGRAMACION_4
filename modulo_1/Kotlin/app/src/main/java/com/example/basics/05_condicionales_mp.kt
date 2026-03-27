package com.example.basics

fun main() {
    println("CONDICIONALES EN MI CEMENTERIO")

    val tumbasSectorA = 10
    val tumbasSectorB = 15

    if (tumbasSectorA > tumbasSectorB) {
        println("El sector con más tumbas es el A: $tumbasSectorA")
    } else {
        println("El sector con más tumbas es el B: $tumbasSectorB")
    }

    println("\nNivel de Luz en el Cementerio:")
    val nivelLuz: Int = 10

    if (nivelLuz > 10) {
        println("Cementerio completamente iluminado")
    } else if (nivelLuz > 5) {
        println("Iluminación tenue, el guardia puede patrullar con precaución")
    } else {
        println("Oscuridad total, se recomienda no ingresar")
    }

    println("\nContexto:")
    println("El guardia nocturno revisa qué sector tiene más tumbas y evalúa el nivel de luz para decidir si es seguro continuar su ronda.")
}
