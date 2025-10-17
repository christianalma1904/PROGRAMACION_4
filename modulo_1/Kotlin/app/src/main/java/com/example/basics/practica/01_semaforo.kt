package com.example.basics.practica

fun main(){
    val colorSemaforo = "verde"
    val botonPresionado = "si"

    val color = colorSemaforo.lowercase()
    val boton = botonPresionado.lowercase()

    println("Simulador")
    println("Semaforo: ${color.uppercase()}")
    println("Boton Presionado: ${boton.uppercase()}")

    if(color == "verde" && boton == "si"){
        println("Espera a rojo")
    } else if (color == "rojo"){
        println("Cruza")
    } else if (color == "amarillo"){
        println("Preparate")
    } else {
        println("Espera")
    }
}