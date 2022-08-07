package com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.R
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.data.entity.YemekClass
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.databinding.CardTasarimFavoriBinding
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.fragment.AnasayfaFragmentDirections
import com.squareup.picasso.Picasso

class FavorilerAdapter(var mContext: Context, var favUrunlerListesi: List<YemekClass>) :
    RecyclerView.Adapter<FavorilerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim: CardTasarimFavoriBinding) :
        RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: CardTasarimFavoriBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimFavoriBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val urun = favUrunlerListesi.get(position)
        val t = holder.tasarim
        t.textViewUrunAdi.text = "${urun.yemek_adi}"
        t.textViewFiyat.text = "${urun.yemek_fiyat}₺"
        Picasso.get().load("http://kasimadalan.pe.hu/yemekler/resimler/${urun.yemek_resim_adi}")
            .into(t.imageViewResim);
        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.urunDetayGecis(yemek = urun)
            Navigation.findNavController(it).navigate(gecis)
        }
        t.buttonDetay.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.urunDetayGecis(yemek = urun)
            Navigation.findNavController(it).navigate(gecis)
        }

    }

    override fun getItemCount(): Int {
        return favUrunlerListesi.size
    }
}