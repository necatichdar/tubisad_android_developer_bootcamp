package com.chdarsoft.kotlindersleri.nesnetabanli

fun main() {
    //Yöntem 1 : Standart Nesne Erişimi
    val a = ASinifi()
    println(a.x)
    a.metod()

    //Yöntem 2 : Sanal Nesne Oluşturma
    print(ASinifi().x)

    ASinifi().metod()

    //Yöntem 3 : Static Erişim
    println(ASinifi.sx)
    ASinifi.smetod()

}