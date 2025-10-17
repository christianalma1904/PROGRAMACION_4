package com.example.basics.practica

fun main(){
    println("INgresa la temperatura del agua(C):")
    var nInput = readLine()
    var n = nInput?.toIntOrNull()?:0
    var respuesta = ""

    if (n <= 0){
        respuesta = "Solido"
    } else if (n >= 1 && n <= 99){
        respuesta = "Liquido"
    } else {
        respuesta = "Gas"
    }
    println("El agua esta en estado $respuesta")
}