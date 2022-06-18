package com.chdarsoft.kotlindersleri.nesnetabanli

fun main() {

    var str1 = "Merhaba"
    var str2:String? = null
    println(str1)
    println("${str2}")
    println("${str2}")

    //Unwrapping
//    if(str2 != null){
//        println("Sonuç 3 $str2")
//    }else {
//
//    }

    //Null ise çalışmaz null değil ise çalışır
    str2?.let {
        println("çalış $str2")
    }
}