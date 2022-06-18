package com.chdarsoft.kotlindersleri.collections

fun main() {
    //Tanımlama
    val meyveler = ArrayList<String>()

    //Veri Ekleme
    meyveler.add("Elma") //0.index
    meyveler.add("Muz") //1.index
    meyveler.add("Kiraz") //2.index
    println(meyveler)

    meyveler[1] = "Portakal"
    println(meyveler)

    //Insert
    meyveler.add(1, "Armut")
    println(meyveler)

    //Okuma işlemi
    println(meyveler.get(2))
    println(meyveler[3])

    println("Boyut : ${meyveler.size}")
    println("Boş kontrol : ${meyveler.isEmpty()}")
    println("İçeriyor mu : ${meyveler.contains("Kiraz")}")

    println(meyveler)
    meyveler.reverse()
    println(meyveler)
    meyveler.sort()
    println(meyveler)

    for (meyve in meyveler){
        println("Sonuç : $meyve")
    }
    for ((index,meyve) in meyveler.withIndex()){
        println("Sonuç : $index $meyve")
    }

    meyveler.removeAt(2)
    println(meyveler)

    meyveler.clear()
    println(meyveler)
}