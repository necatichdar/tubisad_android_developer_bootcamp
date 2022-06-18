package com.chdarsoft.kotlindersleri.nesnetabanli

data class Araba(var renk: String, var hiz: Int, var calisiyorMu: Boolean) {

    //Constructor
    init {
        println("Nesne Oluşturuldu")
    }

    fun bilgial() {
        print("Araba sınıfı")
    }

    fun calistir(){ // Side Effect : Sınıf özelliğini değiştirme
        hiz = 5
        calisiyorMu = true
    }

    fun durdur()   {
        hiz = 0
        calisiyorMu = false
    }

    fun hizlan(kacKm: Int) {
        hiz += kacKm
    }

    fun yavasla(kacKm: Int)  {
        hiz -= kacKm
    }
}