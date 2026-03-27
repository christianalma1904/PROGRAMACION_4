package com.example.basics

fun main(){
    println("Mapas")

    val fuerzaJedis = mapOf(
        "Luke" to 85,
        "Leia" to 80,
        "Obi-Wan" to 95,
        "Yoda" to 100
    )
    println("Fuerza de los Jedis: ${fuerzaJedis}")

    println("Mapa Mutable")

    val misionesCompletadas = mutableMapOf<String, Int>()
    misionesCompletadas["Luke"] = 15
    misionesCompletadas["Leia"] = 12
    misionesCompletadas.put("Han", 20)

    println("Misiones: ${misionesCompletadas}")

    for ((jedi, fuerza) in fuerzaJedis){
        println("$jedi tiene nivel de fuerza $fuerza")
    }

    val planetasVisitados = setOf("Tatooine", "Coruscant", "Dagobah")
    println("Planetas Visitados: ${planetasVisitados}")

    val planetasPeligrosos = setOf("Mustafar", "Coruscant", "Korriban")
    println("Planetas Peligrosos: ${planetasPeligrosos}")

    println("Operaciones de Conjuntos")
    val interseccion = planetasPeligrosos intersect planetasVisitados
    val union = planetasPeligrosos union planetasVisitados
    val diferencia = planetasPeligrosos - planetasVisitados
    println("Planetas Visitados y Peligrosos: ${interseccion}")
    println("Todos los Planetas: ${union}")
    println("Planetas Seguros Visitados: ${diferencia}")
}