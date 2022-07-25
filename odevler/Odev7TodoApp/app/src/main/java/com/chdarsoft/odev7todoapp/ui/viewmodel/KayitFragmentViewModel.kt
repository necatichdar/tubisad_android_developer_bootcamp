package com.chdarsoft.odev7todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.chdarsoft.odev7todoapp.data.repo.YapilacakIsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KayitFragmentViewModel @Inject constructor (var repo:YapilacakIsDaoRepository): ViewModel() {

    fun kayit(yapilacakis_ad:String){
        repo.kayit(yapilacakis_ad)
    }

}