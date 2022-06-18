package com.chdarsoft.kotlindersleri.nesnetabanli

fun main() {
    //Extension

    val sonuc = 5.carpi(5)
    println(sonuc)

    val sonuc1 = 5 topla 2
    println(sonuc1)
}


fun Int.carpi(sayi:Int): Int{
    return sayi * this
}
infix fun Int.topla(sayi:Int): Int{
    return sayi + this
}