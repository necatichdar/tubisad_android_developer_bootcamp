package com.chdarsoft.customlisteleme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.chdarsoft.customlisteleme.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var tasarim: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)

        tasarim.rv.layoutManager = LinearLayoutManager(requireContext())

        val liste = ArrayList<CustomClass>()
        val obje1 = CustomClass("Lorem Ipsum", "https://picsum.photos/seed/picsum/1200/800")
        val obje2 = CustomClass("Lorem Ipsum 2", "https://picsum.photos/seed/picsum/1100/802")
        val obje3 = CustomClass("Lorem Ipsum 3", "https://picsum.photos/seed/picsum/1300/802")
        val obje4 = CustomClass("Lorem Ipsum 4", "https://picsum.photos/seed/picsum/1500/802")
        val obje5 = CustomClass("Lorem Ipsum 5", "https://picsum.photos/seed/picsum/1600/802")
        liste.add(obje1)
        liste.add(obje2)
        liste.add(obje3)
        liste.add(obje4)
        liste.add(obje5)
        val yaziAdapter = CardAdapter(requireContext(), liste)
        tasarim.rv.adapter = yaziAdapter

        return return tasarim.root
    }
}