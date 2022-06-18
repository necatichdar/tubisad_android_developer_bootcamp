package com.chdarsoft.kotlindersleri.degiskenler

import kotlin.reflect.typeOf

fun main() {
    //Tür Dönüşümü

    //Sayısaldan sayısala dönüşümü
    val i = 42
    val d = 78.95

    val sonuc1 = i.toDouble()
    println(sonuc1)

    val sonuc2 = d.toInt()
    println(sonuc2)

    //Sayısaldan metine dönüştürme
    val sonuc3 = i.toString()//"42"
    val sonuc4 = d.toString()//"78.95"
    println(sonuc3)
    println(sonuc4)

    //Metinden sayısala dönüşüm
    val yazi = "67.54,"

    val sonuc5 = yazi.toDoubleOrNull()
    print(sonuc5)

    if(sonuc5 != null){
        println(sonuc5)
    }else {
        println("Dönüşümde hata var")
    }

    sonuc5.let {//Sonuç5 null değilse çalışır
        println(sonuc5)
    }

}