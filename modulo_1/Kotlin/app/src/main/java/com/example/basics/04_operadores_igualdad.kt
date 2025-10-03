package com.example.basics

fun main(){
    println("Operadores de Igualdad!!!")
    val nombre1: String = "Yoda"
    val nombre2: String = "Yoda"
    val nombre3: String = String("Yoda".toCharArray())
    println("Igualdad Estructural(Contenidos)")
    println(nombre1==nombre2)
    println(nombre1==nombre3)
    println("Igualdad Referencial(Misma Instancia)")
    println(nombre1===nombre2)
    println(nombre1===nombre3)
}