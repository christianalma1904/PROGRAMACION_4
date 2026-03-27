package com.example.basic

// Que son los enum? Es un objeto donde podemos incluir una clasificacion. Ej. medio, alto, bajo
// hacemos un enum colocando esa característica

enum class TipoSable(val color:String, val poder: Int){

    AZUL(color= "azul", poder= 85){
        override fun descripcion()="Sable tradicional de los Jedi"
    },
    VERDE(color ="verde", poder=90){
        override fun descripcion()="Sable de los Jedi consultares"
    },
    ROJO(color="MORADO", poder=95){
        override fun descripcion()="Sable de los Sith"
    },
    MORADO(color="morado", poder=95){
        override fun descripcion()="Sable Equiliobra luz y oscuridad"
    };
    abstract fun descripcion(): String

    companion object{
        fun porColor(color: String) = values().find {it.color===color }
    }
}

class SableDeLuz(val tipo: TipoSable, val portador: String){
    fun activar() = "!ZZZrum! El sable color ${tipo.color} de ${portador} se enciende"
    fun info()= "${tipo.descripcion()} - tipo poder ${tipo.poder}"
}

fun main(){
    val sableWindoo = SableDeLuz(TipoSable.MORADO, portador="Windoo")
    println(sableWindoo)
    println(sableWindoo.activar())
    println(sableWindoo.info())

    val sableLuke = SableDeLuz(TipoSable.VERDE, portador="Luke Skywalter")
    println(sableLuke)
    println(sableLuke.activar())
    println(sableLuke.info())

}