package com.chdarsoft.odev7todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.chdarsoft.odev7todoapp.R
import com.chdarsoft.odev7todoapp.data.entity.YapilacakIs
import com.chdarsoft.odev7todoapp.databinding.CardTasarimBinding
import com.chdarsoft.odev7todoapp.ui.fragment.AnasayfaFragmentDirections
import com.chdarsoft.odev7todoapp.ui.viewmodel.AnasayfaFragmentViewModel
import com.chdarsoft.odev7todoapp.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

//1. Parametre Tanımla
class YapilacaklarAdapter(
    var mContext: Context,
    var yapilacakListesi: List<YapilacakIs>,
    var viewModel: AnasayfaFragmentViewModel
) :
    RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>() { //3. inner class'ı adapter'a bağla
    //2. Card tasarımı sınıfı oluştur.
    inner class CardTasarimTutucu(tasarim: CardTasarimBinding) :
        RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: CardTasarimBinding

        init {
            this.tasarim = tasarim //Shadowing
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim: CardTasarimBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.card_tasarim, parent, false
        )

        return CardTasarimTutucu(tasarim)//5. Card Tasarim için viewbinding kurulumu
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacak = yapilacakListesi.get(position)
        val t = holder.tasarim
        t.yapilacakNesne = yapilacak

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(yapilacakIs = yapilacak)
            Navigation.gecisYap(it,gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it, "${yapilacak.yapilacak_is} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("Evet") {
                    viewModel.sil(yapilacak.yapilacak_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return yapilacakListesi.size
    }
}