package com.example.basic

fun main(){
    println("Ingrese primer valor:")
    val value1: Int = readLine()?.toIntOrNull()?:0
    println("Ingrese segundo valor:")
    val value2: Int = readLine()?.toIntOrNull()?:0
    println("Ingrese la operacion:")
    val operacion: String = readln()

    when(operacion){
        "+" -> println("Suma: ${value1 + value2}")
        "-" -> println("Resta: ${value1 - value2}")
        "*" -> println("Multiplicacion: ${value1 * value2}")
        "/" -> println("Division: ${value1 / value2}")
    }
}