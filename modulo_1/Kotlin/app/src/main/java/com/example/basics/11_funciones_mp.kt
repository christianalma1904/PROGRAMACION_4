package com.example.cementerio

fun registrarTumba(id: String, anio: Int, estaOcupada: Boolean) {
    println("REGISTRAR LA TUMBA")

    println("ID: $id")
    println("Año de Creación: $anio")

    if (estaOcupada) {
        println("Estado de Ocupación: OCUPADA")
    } else {
        println("Estado de Ocupación: DISPONIBLE")
    }
}

fun main() {

    val id1 = "C-101"
    val año1 = 1955
    val ocupacion1 = true
    registrarTumba(id1, año1, ocupacion1)

    val id2 = "C-102"
    val año2 = 2020
    val ocupacion2 = false

    println("\n")
    registrarTumba("D-250", 2024, false)
}