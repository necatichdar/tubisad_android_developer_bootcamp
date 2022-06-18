package com.chdarsoft.kotlindersleri.nesnetabanli.composition

fun main() {
    // Composition
    val k1 = Kategoriler(1,"Dram")
    val k2 = Kategoriler(2,"Bilim Kurgu")

    val y1 = Yonetmenler(1,"Quentin Tarantino")
    val y2 = Yonetmenler(2,"Christopher Nolan")

    var f1 = Filmler(1,"Django",2013,k1,y1)

    println(f1.film_id)
    println(f1.film_ad)
    println(f1.film_yil)
    println(f1.kategori.kategori_ad)
    println(f1.yonetmen.yonetmen_ad)
}