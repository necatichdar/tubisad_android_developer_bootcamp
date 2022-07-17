package com.chdarsoft.odev6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.chdarsoft.odev6.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var tasarim:FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)

        tasarim.recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        var urunlerListesi = ArrayList<Urunler>()
        val u1 = Urunler(1,"Çizgi Baskılı Tişört Siyah", "resim1", 129.9, 99.9)
        val u2 = Urunler(2,"Cepli Basic Tişört Siyah", "resim2", 99.99, 79.99)
        val u3 = Urunler(3,"Straight Fit Kot Pantolon", "resim3", 249.99, 229.99)
        val u4 = Urunler(4,"Çiçek Desenli Gömlek", "resim4", 239.99, 199.99)
        val u5 = Urunler(5,"Slim Fit Dokulu Tişört Gri", "resim5", 199.99, 179.99)

        urunlerListesi.add(u1)
        urunlerListesi.add(u2)
        urunlerListesi.add(u3)
        urunlerListesi.add(u4)
        urunlerListesi.add(u5)

        val adapter = UrunAdapter(requireContext(), urunlerListesi)
        tasarim.recyclerView.adapter = adapter

        return tasarim.root
    }

}