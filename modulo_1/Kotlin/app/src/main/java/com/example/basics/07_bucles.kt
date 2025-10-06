package com.example.basic

fun main(){
    println("!Bucles")
    val jedis =  listOf("luke","Leia","Obi-Wan","Yoda","Ahsoka")
    //
    for((index,jedi) in jedis.withIndex()){
        println("${index+1}.$jedi")
    }
    // Por rango de paso
    for (i in 0 ..20 step 5){
        println("Energìa: $i%")
    }
    //rangos descendentes
    for(countdown in 10 downTo 1){
        println("despegue en : $countdown")
    }

    // control de flujo
    for(jedi in jedis){
        if(jedi == "Obi-Wan") continue //saltar esta iteracion
        if(jedi == "Yoda") continue //saltar esta iteracion
        println("entrenando a $jedi" )
    }

    for((index,jedi) in jedis.withIndex()){
        if(jedi == "Obi-Wan") continue //saltar esta iteracion
        if(jedi == "Yoda") continue //saltar esta iteracion
        println("entrenando a ${index+1}. $jedi" )
    }
}