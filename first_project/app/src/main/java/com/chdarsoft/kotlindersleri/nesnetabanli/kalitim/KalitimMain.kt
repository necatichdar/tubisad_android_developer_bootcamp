package com.chdarsoft.kotlindersleri.nesnetabanli.kalitim

import android.os.Build

fun main() {
    val topkapiSarayi = Saray(5, 100)
    val bogazVilla = Villa(true, 30)

    println(topkapiSarayi.kuleSayisi)
    println(topkapiSarayi.pencereSayisi)

    println(bogazVilla.garajVarmi)
    println(bogazVilla.pencereSayisi)

    if(bogazVilla is Villa){
        println("villadır.")
    }else {
        println("villa değildir.")
    }

    //Upcasting
    val ev: Ev = topkapiSarayi

    //Downcasting
    val saray:Saray = ev as Saray

}