package com.chdarsoft.kotlindersleri.nesnetabanli

class Odev2 {
    //Derece
    fun soru1(derece: Double): Double {
        return derece * 1.8 + 32
    }

    //Dikdörtgen
    fun soru2(kisaKenar: Double, uzunKenar: Double): Double {
        return (kisaKenar * 2) + (uzunKenar * 2)
    }

    //Faktöriyel
    fun soru3(sayi: Int) : Int{
        if(sayi == 1 || sayi == 0){
            return 1
        }else if (sayi < 1){
            return 0
        }else {
            var sonuc = 1
            for (i in 1..sayi){
                sonuc *= i
            }
            return sonuc
        }
    }

    fun soru4(kelime: String, harf:Char): Int{
        var sayac = 0
        for (h in kelime){
            if(h.lowercase() == harf.lowercase()){
                sayac += 1
            }
        }
        return sayac
    }

    fun soru5(kenarSayisi : Int) : Int{
        return (kenarSayisi-2) * 180
    }

    fun soru6(gunSayisi: Int) : Int{
        var toplamSaat = gunSayisi * 8
        return if (toplamSaat > 160) {
            (160 * 10) + ((toplamSaat - 160) * 20)
        }else{
            toplamSaat * 10
        }
    }

    fun soru7(kota: Double): Double{
        if (kota > 50) {
            return 100 + ((kota - 50) * 4)
        }else {
            return 100.0
        }
    }

}