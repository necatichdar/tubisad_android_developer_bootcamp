package com.chdarsoft.kotlindersleri.standart_programlama

fun main() {
    //1,2,3

    for (i in 1..3) { //foreach
        println("$i")
    }

    //5'er 5'er artma
    for (a in 10..20 step 5) {
        println("Döngü 2 : $a")
    }

    //5'er 5'er azalma
    for (a in 20 downTo 10 step 5) {
        println("Döngü 3 : $a")
    }

    var sayac = 1
    while (sayac < 6) {
        println("Döngü 4 : $sayac")

        sayac += 1 // sayac = sayac + 1 // sayac++
    }

    for (i in 1..5){
        if ( i == 3){
            break
        }
        println("İndex : $i")
    }



}