package com.chdarsoft.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.chdarsoft.navigationcomponent.databinding.FragmentAnasayfaBinding
import com.google.android.material.snackbar.Snackbar

class AnasayfaFragment : Fragment() {
    private lateinit var tasarim:FragmentAnasayfaBinding
    //OnCreate Metodu
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)
        //Tasarım Kodlamaları

        tasarim.buttonBasla.setOnClickListener {
            //Snackbar.make(it,"Merhaba",Snackbar.LENGTH_SHORT).show()
            val kisi = Kisiler("Necati", 21,1.75f, false)
            val gecis = AnasayfaFragmentDirections.oyunEkraninaGecis(ad = "Necati", yas = 21, boy = 1.75f, bekar = true, nesne = kisi)
            //Navigation.findNavController(it).navigate(R.id.oyunEkraninaGecis)
            Navigation.findNavController(it).navigate(gecis)
        }


        return tasarim.root
    }

}