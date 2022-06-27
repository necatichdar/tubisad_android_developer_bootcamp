package com.chdarsoft.odev4navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.chdarsoft.odev4navigation.databinding.FragmentABinding

class AFragment : Fragment() {
    private lateinit var tasarim: FragmentABinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentABinding.inflate(inflater, container, false)

        tasarim.buttonB.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.goB)
        }

        return tasarim.root
    }
}