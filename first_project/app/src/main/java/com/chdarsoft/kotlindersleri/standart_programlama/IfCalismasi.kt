package com.chdarsoft.kotlindersleri.standart_programlama

fun main() {
    val yas = 19
    val isim = "Ahmet"

    if(yas >= 18){
        println("Reşitsiniz")
    }else{
        println("Reşit değilsiniz")
    }

    if (isim == "Ahmet"){
        println("Merhaba Ahmet")
    }else if (isim == "Mehmet") {
        println("Merhaba Mehmet")
    }else{
        println("Tanınmayan Kişi")
    }

    val gun = 9
    when(gun){
        1,9,8 -> println("Pazartesi")
        2 -> println("Salı")
        3 -> println("Çarşamba")
        4 -> println("Perşembe")
        5 -> println("Cuma")
        6 -> println("Cumartesi")
        7 -> println("Pazar")
        else -> print("yok")
    }


}