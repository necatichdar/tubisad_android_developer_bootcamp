package com.chdarsoft.odev7todoapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.chdarsoft.odev7todoapp.data.entity.YapilacakIs
import com.chdarsoft.odev7todoapp.room.YapilacaklarDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class YapilacakIsDaoRepository(var dao:YapilacaklarDao) {
    var yapilacakListesi:MutableLiveData<List<YapilacakIs>>

    init {
        yapilacakListesi = MutableLiveData()
    }

    fun yapilacaklariGetir(): MutableLiveData<List<YapilacakIs>>{
        return yapilacakListesi
    }

    fun kayit(yapilacakis_ad:String){
        val job = CoroutineScope(Dispatchers.Main).launch{
            val yeni = YapilacakIs(0, yapilacakis_ad)
            dao.yapilacakEkle(yeni)
        }
    }

    fun guncelle(yapilacak_id: Int, yapilacak_is:String){
        val job = CoroutineScope(Dispatchers.Main).launch{
            val guncel = YapilacakIs(yapilacak_id, yapilacak_is)
            dao.yapilacakGuncelle(guncel)
        }
    }

    fun ara(aramaKelimesi:String){
        val job = CoroutineScope(Dispatchers.Main).launch{
            yapilacakListesi.value = dao.yapilacakAra(aramaKelimesi)
        }
    }

    fun sil(yapilacak_id: Int){
        val job = CoroutineScope(Dispatchers.Main).launch{
            val silinecek = YapilacakIs(yapilacak_id, "")
            dao.yapilacakSil(silinecek)
            tumYapilacaklariAl()
        }
    }

    fun tumYapilacaklariAl(){
        val job = CoroutineScope(Dispatchers.Main).launch{
            yapilacakListesi.value = dao.tumYapilacaklar()
        }
    }

}