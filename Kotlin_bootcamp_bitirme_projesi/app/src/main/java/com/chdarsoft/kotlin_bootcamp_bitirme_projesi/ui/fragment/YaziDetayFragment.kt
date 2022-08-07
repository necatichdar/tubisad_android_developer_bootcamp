package com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.R
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.databinding.FragmentYaziDetayBinding
import com.squareup.picasso.Picasso

class YaziDetayFragment : Fragment() {
    private lateinit var tasarim: FragmentYaziDetayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentYaziDetayBinding.inflate(inflater, container, false)

        val bundle:YaziDetayFragmentArgs by navArgs()
        val gelenYazi = bundle.yazi

        tasarim.textViewBaslik1.text = gelenYazi.yazi_title
        tasarim.textViewAciklama1.text = gelenYazi.yazi_description
        Picasso.get().load(gelenYazi.yazi_image).into(tasarim.imageView5);


        return tasarim.root
    }
}