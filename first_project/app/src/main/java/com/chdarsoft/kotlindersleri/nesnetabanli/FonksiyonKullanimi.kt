package com.chdarsoft.kotlindersleri.nesnetabanli

fun main() {
    val f = Fonksiyonlar()

    f.selamla()

    val gelenSonuc = f.selamla2()
    println("Gelen sonuç : $gelenSonuc")

    f.selamla3("Necati")
}