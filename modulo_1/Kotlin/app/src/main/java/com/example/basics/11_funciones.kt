package com.example.basics

fun saludar(){
    println("Hola desde una funcion Kotlin")
}

//Funcion con parametros y retorno
fun sumar(a:Int, b:Int): Int{
    return a + b
}

//Funcion con expresion single-expression function
fun cuadrado(numero: Int) = numero * numero

//Funcion con retorno multiple
fun retornoMultiple(a: Int, b: Int): Pair <Int, Int>{
    val suma = a + b
    val resta = a - b
    return Pair(suma, resta)
}

fun main(){
    saludar()
    val resultado = sumar(5,6)
    println(resultado)
    println(cuadrado(5))
    println(retornoMultiple(15,5))
    //Funcion Lambda
    val cuadradoLambda = {x: Int -> x * x}
    val saludoLambda = {nombre: String -> "Good Moorning, $nombre"}
    println(cuadradoLambda(4))
    println(saludoLambda("Juan Luis Guerra"))
}