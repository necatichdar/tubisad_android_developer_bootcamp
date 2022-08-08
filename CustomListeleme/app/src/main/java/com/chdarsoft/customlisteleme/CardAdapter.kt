package com.chdarsoft.customlisteleme

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chdarsoft.customlisteleme.databinding.CustomDesignBinding
import com.squareup.picasso.Picasso


class CardAdapter(var mContext: Context, var gelenListe: List<CustomClass>) :
    RecyclerView.Adapter<CardAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim: CustomDesignBinding) :
        RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: CustomDesignBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CustomDesignBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val customObje = gelenListe.get(position)
        val t = holder.tasarim

        t.textView.text = customObje.yazi_adi
        Picasso.get().load("${customObje.yazi_resim_adi}")
            .into(t.imageView2);
    }

    override fun getItemCount(): Int {
        return gelenListe.size
    }
}
