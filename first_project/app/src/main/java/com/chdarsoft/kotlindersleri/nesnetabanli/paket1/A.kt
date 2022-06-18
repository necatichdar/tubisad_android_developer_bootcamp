package com.chdarsoft.kotlindersleri.nesnetabanli.paket1

//open: Özellik aktarmaya açık
open class A {
    //public
    var varsayilanDegisken = 1
    public var publicDegisken = 2 //Heryerden erişilebilir.

    //sadece kalıtım yoluyla erişebilmek için
    protected var protectedDegisken = 3 //Kalıtım olursa erişim var
    private var privateDegisken = 4 //Sadece sınıf içinden erişim var

    fun metod(){
        println(privateDegisken)
    }
}