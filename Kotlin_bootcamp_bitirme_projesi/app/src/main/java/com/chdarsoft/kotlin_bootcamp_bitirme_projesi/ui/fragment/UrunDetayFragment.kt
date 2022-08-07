package com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.R
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.data.entity.MySingleton
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.data.entity.SepetYemekClass
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.data.entity.YemekClass
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.databinding.FragmentUrunDetayBinding
import com.squareup.picasso.Picasso
import org.json.JSONException
import org.json.JSONObject

class UrunDetayFragment : Fragment() {
    private lateinit var tasarim:FragmentUrunDetayBinding
    private lateinit var yemek:YemekClass
    var urunListesi = ArrayList<SepetYemekClass>()

    var adet = 1
    var toplamFiyat = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentUrunDetayBinding.inflate(inflater, container, false)
        getUrunler()
        val bundle:UrunDetayFragmentArgs by navArgs()
        val gelenYemek = bundle.yemek
        yemek = gelenYemek
        print(gelenYemek)
        Log.e("yemek", gelenYemek.toString())
        tasarim.textViewUrunFiyat.text = gelenYemek.yemek_fiyat + "₺"
        tasarim.textViewUrunAdi1.text = gelenYemek.yemek_adi
        Picasso.get().load("http://kasimadalan.pe.hu/yemekler/resimler/${gelenYemek.yemek_resim_adi}").into(tasarim.imageViewUrunDetay);

        adetGuncelle(adet)

        tasarim.imageViewArttir.setOnClickListener {
            Log.e("proje", adet.toString())
            adet += 1
            adetGuncelle(adet)
        }

        tasarim.imageViewAzalt.setOnClickListener {
            if (adet >= 2){
                adet -= 1
            }
            adetGuncelle(adet)
        }

        tasarim.buttonSepeteEkle.setOnClickListener {
            sepeteEkle()
        }

        return tasarim.root
    }

    fun adetGuncelle(adet:Int){
        tasarim.textViewUrunAdeti.text = adet.toString()
        toplamFiyat = adet * yemek.yemek_fiyat.toInt()
        tasarim.buttonSepeteEkle.text = "${toplamFiyat}₺ SEPETE EKLE"
    }

    fun sepeteEkle(){
        var varMi = false
        var indexYemek = 0
        Log.e("sepeteEkleyeTıklandı", "urunListesi.toString()")
        for ((index,value) in urunListesi.withIndex()) {
            if (yemek.yemek_adi == value.yemek_adi){
                varMi = true
                indexYemek = index
                Log.e("proje22", "ürün sepette mevcut")
                sepettenSil(value.sepet_yemek_id)
                break
            }else {
            }
        }
        val url = "http://kasimadalan.pe.hu/yemekler/sepeteYemekEkle.php"
        val jsonObjectRequest = object : StringRequest(Method.POST,url,Response.Listener { cevap ->
            Log.e("proje", cevap)
            Toast.makeText(requireContext(),"Ürün sepete eklendi",Toast.LENGTH_SHORT).show()
            adet = 1
            adetGuncelle(adet)
            toplamFiyat = yemek.yemek_fiyat.toInt()
            Navigation.findNavController(requireView()).navigate(R.id.anasayfayaGeriDonüs)
        }, Response.ErrorListener { e -> e.printStackTrace() }){
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                if (varMi){
                    var sepettekiYemek = urunListesi.get(indexYemek)
                    params["yemek_fiyat"] = (toplamFiyat + sepettekiYemek.yemek_fiyat.toInt()).toString()
                    params["yemek_siparis_adet"] = (adet + sepettekiYemek.yemek_siparis_adet.toInt()).toString()
                }else{
                    params["yemek_fiyat"] = toplamFiyat.toString()
                    params["yemek_siparis_adet"] = adet.toString()
                }
                params["yemek_adi"] = yemek.yemek_adi
                params["yemek_resim_adi"] = yemek.yemek_resim_adi

                params["kullanici_adi"] = username
                return params
            }
        }
        MySingleton.getInstance(requireContext()).addToRequestQueue(jsonObjectRequest)
    }

    fun sepettenSil(sepet_yemek_id:String){
        Log.e("sil", sepet_yemek_id)
        val url = "http://kasimadalan.pe.hu/yemekler/sepettenYemekSil.php"
        val jsonObjectRequest = object : StringRequest(Method.POST,url,Response.Listener { cevap ->
            Log.e("sil", cevap)
        }, Response.ErrorListener { e -> e.printStackTrace() }){
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                params["sepet_yemek_id"] = sepet_yemek_id
                params["kullanici_adi"] = username
                return params
            }
        }
        MySingleton.getInstance(requireContext()).addToRequestQueue(jsonObjectRequest)
    }

    fun getUrunler() {
        urunListesi.clear()
        val url = "http://kasimadalan.pe.hu/yemekler/sepettekiYemekleriGetir.php"
        val jsonObjectRequest = object : StringRequest(Method.POST,url,Response.Listener { cevap ->
            Log.e("proje", cevap)
            try {
                val jsonObject = JSONObject(cevap)
                val jsonArray = jsonObject.getJSONArray("sepet_yemekler")
                for (i in 0 until jsonArray.length()) {
                    val employee = jsonArray.getJSONObject(i)
                    val sepet_yemek_id = employee.getString("sepet_yemek_id")
                    val yemek_adi = employee.getString("yemek_adi")
                    val yemek_resim_adi = employee.getString("yemek_resim_adi")
                    val yemek_fiyat = employee.getString("yemek_fiyat")
                    val yemek_siparis_adet = employee.getString("yemek_siparis_adet")
                    val yemek = SepetYemekClass(sepet_yemek_id,yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,
                        username)
                    urunListesi.add(yemek)
                }
            }catch (e:JSONException ){

            }
        }, Response.ErrorListener { e -> e.printStackTrace() }){
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                params["kullanici_adi"] = username
                return params
            }
        }
        MySingleton.getInstance(requireContext()).addToRequestQueue(jsonObjectRequest)
    }
}