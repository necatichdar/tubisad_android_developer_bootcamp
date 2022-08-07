package com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.R
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.data.entity.MySingleton
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.data.entity.SepetYemekClass
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.data.entity.YaziClass
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.databinding.FragmentSepetBinding
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.adapter.FavorilerAdapter
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.adapter.SepetAdapter
import org.json.JSONException
import org.json.JSONObject

class SepetFragment : Fragment() {
    private lateinit var tasarim: FragmentSepetBinding
    var urunListesi = ArrayList<SepetYemekClass>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentSepetBinding.inflate(inflater, container, false)

        tasarim.rv.layoutManager =
            LinearLayoutManager(requireContext())
        getUrunler()

        tasarim.button2.setOnClickListener {
            if(urunListesi.isNotEmpty()){

                val ad = AlertDialog.Builder(requireContext())
                ad.setMessage("Siparişinizi onaylıyor musunuz?")
                ad.setTitle("Sipariş Onayı")

                ad.setPositiveButton("Tamamla"){ dialogInterface, i ->
                    for (urun in urunListesi) {
                        sepettenSil(urun.sepet_yemek_id)
                    }
                    Toast.makeText(requireContext(),"Sipariş Verildi", Toast.LENGTH_SHORT).show()
                    Navigation.findNavController(it).navigate(R.id.sepetToAnasayfa)
                }
                ad.setNegativeButton("Vazgeç"){ dialog,i ->
                }

                ad.create().show()

            }else{
                Toast.makeText(requireContext(),"Sepette Ürün Bulunmamaktadır.", Toast.LENGTH_SHORT).show()
            }
        }


        return tasarim.root
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

        val url = "http://kasimadalan.pe.hu/yemekler/sepettekiYemekleriGetir.php"
        val jsonObjectRequest = object : StringRequest(Method.POST,url, Response.Listener { cevap ->
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

                tasarim.button2.text = "${urunListesi.sumOf { it.yemek_fiyat.toInt()}}₺ SİPARİŞ VER"

                urunListesi.sortBy { it.yemek_adi }

                val sepetAdapter = SepetAdapter(requireContext(), urunListesi)
                tasarim.rv.adapter = sepetAdapter
            }catch (e: JSONException){

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