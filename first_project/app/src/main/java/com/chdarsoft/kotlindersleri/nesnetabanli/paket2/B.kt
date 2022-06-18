package com.chdarsoft.kotlindersleri.nesnetabanli.paket2

import com.chdarsoft.kotlindersleri.nesnetabanli.paket1.A

class B : A() {
    fun metodB(){
        val a = A()
        val liste = ArrayList<String>()
        println(a.publicDegisken)
        println(a.varsayilanDegisken)
        println(protectedDegisken)
    }

}

//Visibilty veya Access Modifier