package com.chdarsoft.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.chdarsoft.kisileruygulamasi.data.entity.Kisiler
import com.chdarsoft.kisileruygulamasi.databinding.CardTasarimBinding
import com.chdarsoft.kisileruygulamasi.databinding.FragmentKisiDetayBinding
import com.chdarsoft.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar


//1.Parametre tanımları
class KisilerAdapter (var mContext:Context, var kisilerListesi:List<Kisiler>)
    : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() //3. inner class'ı adapter a bağla
{
    //2. Card tasarımı sınıfı oluştur. - inner class
    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim: CardTasarimBinding
        init {
            this.tasarim = tasarim //Shadowing
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater, parent, false)
        return CardTasarimTutucu(tasarim) //5. Card Tasarım için viewbinding kurulumu
    }

    //Eleman sayısına göre döngü gibi çalışır
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi = kisilerListesi.get(position)
        val t = holder.tasarim
        t.textViewKisiBilgi.text = "${kisi.kisi_ad} - ${kisi.kisi_tel}"

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageViewSil.setOnClickListener{
            Snackbar.make(it, "${kisi.kisi_ad} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    Log.e("Kişi Sil", kisi.kisi_id.toString())
                }
                .show()
        }
    }

    override fun getItemCount(): Int {
        return kisilerListesi.size //4. Satır sayısını belirle
    }
}