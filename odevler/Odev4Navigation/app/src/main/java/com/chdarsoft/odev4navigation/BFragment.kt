package com.chdarsoft.odev4navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.chdarsoft.odev4navigation.databinding.FragmentBBinding

class BFragment : Fragment() {
    private lateinit var tasarim: FragmentBBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentBBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        tasarim.buttonBY.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.goBY)
        }
        return tasarim.root
    }
}