package com.chdarsoft.kotlindersleri.collections

fun main() {
    val meyveler = HashSet<String>()

    meyveler.add("Elma")
    meyveler.add("Kiraz")
    meyveler.add("Muz")
    println(meyveler)

    meyveler.add("Amasya Elması")
    println(meyveler)

    println(meyveler.elementAt(1))
    println(meyveler.size)
    println(meyveler.isEmpty())

    for((i,meyve) in meyveler.withIndex()){
        println("Sonuç $i : $meyve")
    }

    meyveler.remove("Elma")
    print(meyveler)


}