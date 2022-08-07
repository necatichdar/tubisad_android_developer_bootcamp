package com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.data.entity.YemekClass
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.databinding.CardTasarimFavoriBinding
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.databinding.CardTasarimUrunlerBinding
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.fragment.AnasayfaFragmentDirections
import com.squareup.picasso.Picasso

class TumUrunlerAdapter(var mContext: Context, var favUrunlerListesi: List<YemekClass>) :
    RecyclerView.Adapter<TumUrunlerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim: CardTasarimUrunlerBinding) :
        RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: CardTasarimUrunlerBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimUrunlerBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val urun = favUrunlerListesi.get(position)
        val t = holder.tasarim

        t.textViewFiyati.text = "${urun.yemek_fiyat}₺"
        t.textViewBaslik.text = "${urun.yemek_adi}"
        Picasso.get().load("http://kasimadalan.pe.hu/yemekler/resimler/${urun.yemek_resim_adi}").into(t.imageViewUrunResmi);
        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.urunDetayGecis(yemek = urun)
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return favUrunlerListesi.size
    }
}