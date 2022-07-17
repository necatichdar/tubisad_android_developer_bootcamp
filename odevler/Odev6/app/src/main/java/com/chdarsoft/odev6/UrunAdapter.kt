package com.chdarsoft.odev6

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chdarsoft.odev6.databinding.CardTasarimBinding
import com.chdarsoft.odev6.databinding.FragmentAnasayfaBinding

class UrunAdapter(var mContext: Context, var urunListesi:List<Urunler>)
    :RecyclerView.Adapter<UrunAdapter.CardTasarimTutucu>(){
    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim: CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater, parent, false)
        return  CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val urun = urunListesi.get(position)
        val t = holder.tasarim

        t.imageViewUrun.setImageResource(mContext.resources.getIdentifier(urun.urunResim, "drawable", mContext.packageName))
        t.textViewUrunAdi.text = urun.urunAdi
        t.textViewEskiFiyat.text = "${urun.urunEskiFiyat}₺"
        t.textViewYeniFiyat.text = "${urun.urunFiyat}₺"
        t.textViewEskiFiyat.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        t.cardViewUrun.setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
        return  urunListesi.count()
    }
}