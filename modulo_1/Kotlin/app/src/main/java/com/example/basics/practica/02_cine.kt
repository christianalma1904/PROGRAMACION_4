package com.example.basics.practica

fun main(){
    val presioBase = 5
    val presioFinal : Int

    println("Simulador")
    println("El presio base es $${presioBase}")

    println("Introsuce tu edad:")
    val edadInput = readLine()
    val edad = edadInput?.toIntOrNull()

    if(edad == null){
        println("Porfavor introduce tu edad")
        return
    }

    if(edad <= 12){
        presioFinal = 3
        println("Descuento de niño aplicado! Su edad es $edad años")
    } else if (edad >= 65){
        presioFinal = 4
        println("Descuento de tercera edad aplicado! Su edad es $edad años")
    } else {
        presioFinal = presioBase
        println("Tarifa normal aplicada! Su edad es $edad años")
    }

    println("El precio final de la entrada es de $$presioFinal ")
}