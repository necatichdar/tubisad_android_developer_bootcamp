package com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.fragment
import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.R
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.databinding.FragmentLoginBinding


var username = "necatichdar"

class LoginFragment : Fragment() {
    private lateinit var tasarim: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentLoginBinding.inflate(inflater, container, false)


        tasarim.button.setOnClickListener {

            val alertTasarim = layoutInflater.inflate(R.layout.alert_tasarim, null)
            val editTextAlert = alertTasarim.findViewById(R.id.editTextAlert) as EditText

            val ad = androidx.appcompat.app.AlertDialog.Builder(requireContext())
            ad.setMessage("Kullanıcı adınızı giriniz.")
            ad.setTitle("Giriş Yap")
            ad.setView(alertTasarim)

            ad.setPositiveButton("Giriş Yap"){ dialogInterface, i ->
                val alinanVeri = editTextAlert.text.toString()
                username = alinanVeri
                Navigation.findNavController(it).navigate(R.id.anasayfaGecis)
            }
            ad.setNegativeButton("Vazgeç"){ dialog,i ->
            }

            ad.create().show()



            // Data Aktarma
            /*val kisi = TempClass(1,"Kisi Adı")
            val gecis = AnasayfaDirections.kisiDetayGecis(kisi = kisi)
            Navigation.findNavController(it).navigate(gecis)*/

            // Data Yakalama
            /*val bundle:KisiDetayFragmentArgs by navArgs()
            val gelenKisi = bundle.kisi*/
        }

        return tasarim.root
    }

}