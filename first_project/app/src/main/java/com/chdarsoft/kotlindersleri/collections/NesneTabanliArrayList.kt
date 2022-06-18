package com.chdarsoft.kotlindersleri.collections

fun main() {
    val u1 = Urunler(1, "Asus", 9.999)
    val u2 = Urunler(2, "Macbook", 8.999)
    val u3 = Urunler(3, "Dell", 9.229)

    var list = ArrayList<Urunler>()
    list.add(u1)
    list.add(u2)
    list.add(u3)

    for (u in list) {
        println("id: ${u.id} - Ad : ${u.ad} - Fiyat : ${u.fiyat}₺")
    }

    //Sıralama
    println("Sayısal : Küçükten - Büyüğe")
    val siralama1 = list.sortedWith(compareBy { it.fiyat })
    for (u in siralama1) {
        println("id: ${u.id} - Ad : ${u.ad} - Fiyat : ${u.fiyat}₺")
    }
    println("Sayısal : Büyükten - Küçüğe")
    val siralama2 = list.sortedWith(compareByDescending {it.fiyat })
    for (u in siralama2) {
        println("id: ${u.id} - Ad : ${u.ad} - Fiyat : ${u.fiyat}₺")
    }


    println("harfsel : Küçükten - Büyüğe")
    val siralama3 = list.sortedWith(compareBy { it.ad })
    for (u in siralama3) {
        println("id: ${u.id} - Ad : ${u.ad} - Fiyat : ${u.fiyat}₺")
    }
    println("harfsel : Büyükten - Küçüğe")
    val siralama4 = list.sortedWith(compareByDescending {it.ad })
    for (u in siralama4) {
        println("id: ${u.id} - Ad : ${u.ad} - Fiyat : ${u.fiyat}₺")
    }

    //Filtreleme
    println("Filtreleme 1")
    val filtreleme1 = list.filter { it.fiyat > 2 }
    for (u in filtreleme1) {
        println("id: ${u.id} - Ad : ${u.ad} - Fiyat : ${u.fiyat}₺")
    }

    println("Filtreleme 2")
    val filtreleme2 = list.filter { it.ad.contains("l") }
    for (u in filtreleme2) {
        println("id: ${u.id} - Ad : ${u.ad} - Fiyat : ${u.fiyat}₺")
    }

}