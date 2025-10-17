package com.example.basics.practica

fun main(){
    println("Introduce un numero:")
    val nInput = readLine()
    val n = nInput?.toIntOrNull()?:0
    var i = 1
    var sumaMultiplos = 0

    while (i <= n){
        if (i % 3 == 0){
            sumaMultiplos += i
            println("Sumando el múltiplo: $i")
        }
        i++
    }

    println("La suma de todos los multiplos de 3 es igual a $sumaMultiplos")
}