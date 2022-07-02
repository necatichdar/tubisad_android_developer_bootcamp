package com.chdarsoft.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.Navigation
import com.chdarsoft.kisileruygulamasi.R
import com.chdarsoft.kisileruygulamasi.data.entity.Kisiler
import com.chdarsoft.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.google.android.material.snackbar.Snackbar

class AnasayfaFragment : Fragment(), SearchView.OnQueryTextListener{
    private lateinit var tasarim:FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)

        tasarim.toolbarAnasayfa.title = "Kişiler"
        //acitivity deki özelliklere erişmemizi sağlar
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        tasarim.fab.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        }

        tasarim.buttonDetay.setOnClickListener {
            val kisi = Kisiler(1,"Necati", "5075925339")
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi)
            Navigation.findNavController(it).navigate(gecis)
        }

        return tasarim.root
    }

    //Fragment'te olması gerekir. Activityde gerekmez
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)

        val item = menu.findItem(R.id.action_ara)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

  /*  override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_ara -> {
                Log.e("Kişi Menü", "Ara seçildi")
                return true
            }
            R.id.action_cikis -> {
                Log.e("Kişi Menü", "Çıkış seçildi")
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }*/

    override fun onQueryTextSubmit(query: String): Boolean {//Klavyedeki arama iconu seçilirse çalışır
        TODO("Not yet implemented")
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {//Harf girdikçe ve sildikçe çalışır.
        ara(newText)
        return true
    }

    fun ara(aramaKelimesi:String){
        Log.e("Kişi Ara", aramaKelimesi)
    }

}