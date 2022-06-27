package com.chdarsoft.navigationcomponent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.chdarsoft.navigationcomponent.databinding.FragmentOyunEkraniBinding
import com.google.android.material.snackbar.Snackbar

class OyunEkraniFragment : Fragment() {
    private lateinit var tasarim:FragmentOyunEkraniBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentOyunEkraniBinding.inflate(inflater, container, false)

        //by = Delegate
        val bundle: OyunEkraniFragmentArgs by navArgs()
        val gelenAd = bundle.ad
        val gelenBoy = bundle.boy
        val gelenYas = bundle.yas
        val gelenBekar = bundle.bekar
        val gelenNesne = bundle.nesne

        Log.e("Gelen -> ", gelenAd)
        Log.e("Gelen -> ", gelenBoy.toString())
        Log.e("Gelen -> ", gelenYas.toString())
        Log.e("Gelen -> ", gelenBekar.toString())
        Log.e("Gelen Nesne-> ", gelenNesne.toString())

        tasarim.buttonBitir.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.sonucEkraninaGecis)
        }

        return tasarim.root
    }

}