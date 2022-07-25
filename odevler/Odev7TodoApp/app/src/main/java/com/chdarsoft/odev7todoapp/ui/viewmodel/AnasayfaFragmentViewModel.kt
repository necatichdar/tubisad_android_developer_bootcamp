package com.chdarsoft.odev7todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chdarsoft.odev7todoapp.data.entity.YapilacakIs
import com.chdarsoft.odev7todoapp.data.repo.YapilacakIsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnasayfaFragmentViewModel @Inject constructor (var repo:YapilacakIsDaoRepository) : ViewModel() {
    var yapilacaklarListesi = MutableLiveData<List<YapilacakIs>>()

    init {
        yapilacaklariGetir()
        yapilacaklarListesi = repo.yapilacaklariGetir()
    }

    fun ara(aramaKelimesi:String){
        repo.ara(aramaKelimesi)
    }

    fun sil(yapilacak_id: Int){
        repo.sil(yapilacak_id)
    }

    fun yapilacaklariGetir(){
        repo.tumYapilacaklariAl()
    }

}