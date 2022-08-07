package com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.R
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.data.entity.MySingleton
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.data.entity.SepetYemekClass
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.data.entity.YemekClass
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.databinding.CardTasarimFavoriBinding
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.databinding.CardTasarimSepetBinding
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.databinding.CardTasarimUrunlerBinding
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.fragment.AnasayfaFragmentDirections
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.fragment.username
import com.squareup.picasso.Picasso

class SepetAdapter(var mContext: Context, var favUrunlerListesi: List<SepetYemekClass>) :
    RecyclerView.Adapter<SepetAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim: CardTasarimSepetBinding) :
        RecyclerView.ViewHolder(tasarim.root) {
        var tasarim: CardTasarimSepetBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimSepetBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val urun = favUrunlerListesi.get(position)
        val t = holder.tasarim

        t.textViewFiyat2.text = "${urun.yemek_fiyat}₺"
        t.textViewAdet.text = "${urun.yemek_siparis_adet} Adet"
        t.textViewUrunAdi2.text = "${urun.yemek_adi}"
        Picasso.get().load("http://kasimadalan.pe.hu/yemekler/resimler/${urun.yemek_resim_adi}").into(t.imageViewImage);
        t.imageViewDelete.setOnClickListener {
            sepettenSil(urun.sepet_yemek_id, it)
        }
    }

    override fun getItemCount(): Int {
        return favUrunlerListesi.size
    }

    fun sepettenSil(sepet_yemek_id:String, it:View){
        Log.e("sil", sepet_yemek_id)
        val url = "http://kasimadalan.pe.hu/yemekler/sepettenYemekSil.php"
        val jsonObjectRequest = object : StringRequest(Method.POST,url, Response.Listener { cevap ->
            Log.e("sil", cevap)
            Navigation.findNavController(it).navigate(R.id.refreshSepet)
        }, Response.ErrorListener { e -> e.printStackTrace() }){
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                params["sepet_yemek_id"] = sepet_yemek_id
                params["kullanici_adi"] = username
                return params
            }
        }
        MySingleton.getInstance(mContext).addToRequestQueue(jsonObjectRequest)
    }
}