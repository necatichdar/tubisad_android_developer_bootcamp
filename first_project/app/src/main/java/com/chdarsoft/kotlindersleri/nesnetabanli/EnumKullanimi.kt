package com.chdarsoft.kotlindersleri.nesnetabanli

fun main() {
    ucretHesapla(34, KonserveBoyut.ORTA)
}

fun ucretHesapla(adet: Int, boyut: KonserveBoyut) {
    when (boyut) {
        KonserveBoyut.BUYUK -> println("Toplam maliyet: ${adet * 140}₺")
        KonserveBoyut.KUCUK -> println("Toplam maliyet: ${adet * 30}₺")
        KonserveBoyut.ORTA -> println("Toplam maliyet: ${adet * 80}₺")

    }
}