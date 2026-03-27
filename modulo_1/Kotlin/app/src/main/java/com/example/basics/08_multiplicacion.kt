package com.example.basic

fun main(){
    println("Ingresa la tabla de multiplcacion que desea: ")
    val tabla: Int = readLine()?.toIntOrNull()?:0
    for (i in 0 ..12 step 1){
        println("$i.   $tabla * $i =  ${tabla*i}")
    }
}