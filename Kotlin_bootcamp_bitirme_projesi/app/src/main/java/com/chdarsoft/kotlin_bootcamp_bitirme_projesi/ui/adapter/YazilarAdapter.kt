package com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.data.entity.YaziClass
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.databinding.CardTasarimYaziBinding
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.fragment.AnasayfaFragmentDirections
import com.squareup.picasso.Picasso

class YazilarAdapter(var mContext: Context, var yazilarListesi: List<YaziClass>) :
    RecyclerView.Adapter<YazilarAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim: CardTasarimYaziBinding) :
        RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: CardTasarimYaziBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimYaziBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yazi = yazilarListesi.get(position)
        val t = holder.tasarim
        t.textViewTitle.text = "${yazi.yazi_title}"
        Picasso.get().load("${yazi.yazi_image}").into(t.imageView2);
        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.yaziDetayGecis(yazi = yazi)
            Navigation.findNavController(it).navigate(gecis)
        }
    }

    override fun getItemCount(): Int {
        return yazilarListesi.size
    }
}