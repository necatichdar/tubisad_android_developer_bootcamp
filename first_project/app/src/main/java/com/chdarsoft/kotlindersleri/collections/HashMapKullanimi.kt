package com.chdarsoft.kotlindersleri.collections

fun main() {
    val iller = HashMap<Int,String>() // Swift : Dictionary
    iller.put(16, "Bursa")
    iller.put(34, "İSTANBUL")
    iller[6] = "ANKARA"
    println(iller)

    println(iller.get(16))

    for((anahtar,deger) in iller){
        println("$anahtar -> $deger")
    }

    iller.remove(34)
    println(iller)
}