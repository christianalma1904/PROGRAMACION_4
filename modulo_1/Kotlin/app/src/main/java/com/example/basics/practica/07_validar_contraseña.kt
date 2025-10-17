package com.example.basics.practica

fun main() {
    println("Introduce tu contraseña:")
    val password = readln()

    val longitudValida = password.length >= 8

    val contieneDigito = password.any { it.isDigit() }

    if (longitudValida && contieneDigito) {
        println("Contraseña VÁLIDA")
    } else {
        println("Contraseña INVÁLIDA")
    }
}