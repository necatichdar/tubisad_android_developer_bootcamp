package com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.R
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.data.entity.MySingleton
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.data.entity.YaziClass
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.data.entity.YemekClass
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.databinding.FragmentAnasayfaBinding
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.adapter.FavorilerAdapter
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.adapter.TumUrunlerAdapter
import com.chdarsoft.kotlin_bootcamp_bitirme_projesi.ui.adapter.YazilarAdapter
import org.json.JSONException

class AnasayfaFragment : Fragment() {
    private lateinit var tasarim: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)
        //Layout Ayarları
        tasarim.rvFav.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        tasarim.rvTum.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        tasarim.rvYazi.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)

        val yaziListesi = ArrayList<YaziClass>()
        val y1 = YaziClass(1, "Beslenme", "Beslenme açlık duygusunu bastırmak, karın doyurmak ya da canının çektiği şeyleri yemek içmek değildir.\n" +
                "\n" +
                "Beslenme; sağlığı korumak, geliştirmek ve yaşam kalitesini yükseltmek için vücudun gereksinimi olan besin öğelerini yeterli miktarlarda ve uygun zamanlarda almak için bilinçli yapılması gereken bir davranıştır.\n" +
                "\n" +
                "Besin öğeleri vücudun gereksinmesi düzeyinde alınamadığında Yetersiz Beslenme oluşur.", "https://sagligim.gov.tr/depo/sagligimyeni/sagliklihayat/saglikli_beslenme/kucuk_resimler/hsgm_resim_4.jpg")
        val y2 = YaziClass(2, "Besin Grupları", "Başta yetişkin kadınlar, çocuklar ve gençler olmak üzere tüm yaş gruplarının bu grubu her gün tüketmesi gerekir.\n" +
                "\n" +
                "Bu grupta yer alan besinler:\n" +
                "\n" +
                "Süt ve yerine geçen besinler; yoğurt, peynir ve süttozu gibi sütten yapılan besinler\n" +
                "\n" +
                "İçerdiği Önemli Besinler :\n" +
                "\n" +
                "Protein, kalsiyum, fosfor, B2 vitamini (riboflavin) ve vitamin B12 olmak üzere birçok besin öğesinin önemli kaynağıdır.\n" +
                "\n" +
                "Başlıca Görevleri:\n" +
                "\n" +
                "Kalsiyumdan zengin olan bu grup kemiklerin ve dişlerin sağlıklı gelişiminde ve hücre çalışmasında önemli rol oynar.", "https://sagligim.gov.tr/depo/sagligimyeni/sagliklihayat/saglikli_beslenme/resim_9.jpg")
        val y3 = YaziClass(3, "Okul Öncesi", "Bir ülkenin sosyal ve ekonomik yönden beklenen uygarlık seviyesine ulaşabilmesi ancak bedensel ve zihinsel yönden güçlü, sağlıklı ve yetenekli bireylerin varlığına bağlıdır. Ülkemiz nüfusunun büyük çoğunluğunu oluşturan çocuk ve gençlerin yeterli ve dengel i beslenmiş olmaları, onların gelecekte sağlıklı ve üretken bireyler olması için ön koşuldur. Çocuğun kişiliği özellikle okul öncesi dönemde şekillenmekte, yetişkinlik çağındaki davranışları üzerinde etkili olacak alışkanlıkların edinilmesi bu yıllara dayanmaktadır. Okul öncesi çocuklarda hızlı büyüme ve gelişme nedeniyle pek çok besin öğesine olan gereksinim yaşamının diğer dönemlerine oranla daha fazladır. Bu nedenle bu dönemde yeterli ve dengeli beslenme kadar, iyi geliştirilmiş beslenme alışkanlıkları edinmek de çok önemlidir. Çocuğun bu yaşlarda kazandığı sağlıklı beslenme alışkanlıkları hayatının sonraki dönemlerini etkileyerek ileride ortaya çıkabilecek beslenme sorunlarını önlemede temel çözüm yolunu oluşturmaktadır. Çünkü sağlıklı beslenme çocuğun bedensel, sosyal ve duygusal gelişmesi ve davranışları üzerinde önemli bir rol oynamaktadır.", "https://sagligim.gov.tr/depo/sagligimyeni/sagliklihayat/saglikli_beslenme/kucuk_resimler/hsgm_resim_3.jpg")
        val y4 = YaziClass(3, "Bebek", "Büyümenin en hızlı olduğu bu dönemde oluşan büyüme geriliğinin iki yaş sonrasında düzeltilmesi oldukça güçtür. Bu nedenle, süt çocuğu ve küçük çocukların beslenmesiyle ilgili alışkanlıkların bu dönem\u00ADde kazandırılması ve annelerin bu konuda bilinçlendirilmesi gerekmektedir.\n" +
                "\n" +
                "Anne Sütü\n" +
                "\n" +
                "Bir toplumun geleceği sağlıklı bireylerin varlığı ile süreklidir. Çocuk\u00ADların sağlıklı olarak dünyaya gelmesi ve yetişmesi için annelerin gebe ve emziklilik döneminde, fetal gelişme, süt yapımı, besinlere olan gereksin\u00ADmelerinin artması ve buna bağlı olarak yeterli ve dengeli beslenmeleri ve sağlıklarını korumaları konusunda bilinçlendirilmeleri gereklidir.\n" +
                "\n" +
                "Yenidoğan bir bebek için en uygun besin ANNE SÜTÜ’dür. Anne sütü bebeğin sağlıklı olması, tüm besin öğeleri gereksinmelerini karşılaması, kolaylıkla sindirilebilmesi ve enfeksiyonlara karşı koruması açısından yeri doldurulamaz bir besindir.", "https://sagligim.gov.tr/depo/sagligimyeni/sagliklihayat/saglikli_beslenme/kucuk_resimler/hsgm_resim_1.jpg")
        val y5 =
            YaziClass(3, "Sağlık", "Sağlık hizmetlerinin etkinliğinin artırılması ile birlikte bireysel diyet ve sağlık uygulamalarının düzeltilmesi önlenebilir hastalıkları, sakatlıkları ve erken ölümleri azaltmaktadır. Beslenme yetersizliği ve dengesizliği bazı hastalıkların oluşmasında doğrudan, bazılarında ise dolaylı nedendir.\n" +
                    "\n" +
                    "Aşağıda hastalıklara yönelik genel bilgileri bulabilirsiniz. Ancak hastalıklarda diyet planlamasının kişiye özel olduğunu unutmayınız. Bunun için mutlaka diyetisyene başvurunuz.\n" +
                    "\n", "https://sagligim.gov.tr/depo/sagligimyeni/sagliklihayat/saglikli_beslenme/kucuk_resimler/hsgm_resim_6.jpg")
        yaziListesi.add(y1)
        yaziListesi.add(y2)
        yaziListesi.add(y3)
        yaziListesi.add(y4)
        yaziListesi.add(y5)

        val yaziAdapter = YazilarAdapter(requireContext(), yaziListesi)
        tasarim.rvYazi.adapter = yaziAdapter

        getUrunler()

        tasarim.imageViewSepet.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.sepeteGecis)
        }

        tasarim.imageView3.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.cikisYap)
        }

        return tasarim.root
    }

    fun getUrunler() {
        val urunListesi = ArrayList<YemekClass>()
        val url = "http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php"
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                //Log.e("proje","Response: %s".format(response.toString()))
                try {
                    val jsonArray = response.getJSONArray("yemekler")
                    for (i in 0 until jsonArray.length()) {
                        val employee = jsonArray.getJSONObject(i)
                        val yemek_id = employee.getString("yemek_id")
                        val yemek_adi = employee.getString("yemek_adi")
                        val yemek_resim_adi = employee.getString("yemek_resim_adi")
                        val yemek_fiyat = employee.getString("yemek_fiyat")
                        val yemek = YemekClass(yemek_id,yemek_adi,yemek_resim_adi,yemek_fiyat)
                        urunListesi.add(yemek)
                    }
                    val tumAdaptor = TumUrunlerAdapter(requireContext(), urunListesi)
                    tasarim.rvTum.adapter = tumAdaptor
                    val favoriAdapter = FavorilerAdapter(requireContext(), urunListesi.reversed())
                    tasarim.rvFav.adapter = favoriAdapter
                }catch (e: JSONException){
                    e.printStackTrace()
                    urunListesi.clear()
                }
            },
            { error ->
                Log.e("proje",error.toString())
            }
        )
        MySingleton.getInstance(requireContext()).addToRequestQueue(jsonObjectRequest)
    }
}