package com.chdarsoft.odev4navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.chdarsoft.odev4navigation.databinding.FragmentXBinding

class XFragment : Fragment() {
    private lateinit var tasarim:FragmentXBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentXBinding.inflate(inflater, container, false)

        tasarim.buttonY.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.goY)
        }

        return tasarim.root

    }
}