package com.example.basic
//archivo tipo class
fun main(){
    try{
        val resultados = 8/0;
    }catch (e:Exception){
        println(e)
        println("Error en division")
    }
}