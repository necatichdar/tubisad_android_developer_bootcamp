package com.chdarsoft.odev7todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.chdarsoft.odev7todoapp.data.repo.YapilacakIsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetayFragmentViewModel @Inject constructor (var repo:YapilacakIsDaoRepository): ViewModel() {

    fun guncelle(yapilacak_id: Int, yapilacak_is:String){
        repo.guncelle(yapilacak_id, yapilacak_is)
    }
}