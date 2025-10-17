package com.example.basics.practica

fun main(){
    println("Introduce un numero:")
    val nInput = readLine()
    val n = nInput?.toIntOrNull()?:0
    var i = 1
    var numerosPares = 0

    while (i <= n){
        if(i % 2 == 0){
            numerosPares++
        }
        i++
    }
    println("El total de numeros pares entre 1 y $n es igual a $numerosPares")
}