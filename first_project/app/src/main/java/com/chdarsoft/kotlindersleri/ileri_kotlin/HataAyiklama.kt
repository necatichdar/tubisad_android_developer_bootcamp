package com.chdarsoft.kotlindersleri.ileri_kotlin

import java.lang.Exception

fun main() {
    val x = 10
    val y = 0


    try {
        println("Sonuç : ${x/y}")
        println("İşlem Tamam")
    }catch (e:Exception){
        println("İkinci sayı sıfır olamaz")
    }
}