package com.chdarsoft.kotlindersleri.nesnetabanli

class Fonksiyonlar {

    fun selamla() {
        val sonuc = "Merhaba Ahmet"
        println("$sonuc")
    }

    fun selamla2() : String {
        val sonuc = "Merhaba Ahmet"
        return sonuc
    }

    fun selamla3(isim:String) {
        val sonuc = "Merhaba $isim"
        println("$sonuc")
    }

    //Overloading
    fun carpma(sayi1: Int, sayi2: Int){
        println("$sayi1 x $sayi2 = ${sayi1*sayi2}")
    }
    fun carpma(sayi1: Double, sayi2: Double){
        println("$sayi1 x $sayi2 = ${sayi1*sayi2}")
    }
}