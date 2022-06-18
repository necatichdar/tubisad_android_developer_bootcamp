package com.chdarsoft.kotlindersleri.nesnetabanli.override_kullanimi

fun main() {
    val hayvan = Hayvan()
    val memeli = Memeli()
    val kedi = Kedi()
    val kopek = Kopek()

    hayvan.sesCikar()
    memeli.sesCikar()
    kedi.sesCikar()
    kopek.sesCikar()
}