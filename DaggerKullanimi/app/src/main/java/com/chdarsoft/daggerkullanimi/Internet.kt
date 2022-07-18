package com.chdarsoft.daggerkullanimi

import android.util.Log
import javax.inject.Inject

class Internet @Inject constructor (var adres: Adres) {
    fun basvuruYap(){
        Log.e("Sonuç", "Internet başvurusu ${adres.adresBilgisi} adresi için yapıldı.")
    }
}