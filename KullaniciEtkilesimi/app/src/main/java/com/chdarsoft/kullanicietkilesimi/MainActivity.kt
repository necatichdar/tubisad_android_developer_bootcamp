package com.chdarsoft.kullanicietkilesimi

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.chdarsoft.kullanicietkilesimi.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        tasarim.buttonToast.setOnClickListener {
            Toast.makeText(this,"Merhaba", Toast.LENGTH_SHORT).show()
        }

        tasarim.buttonSnackbar.setOnClickListener {
            Snackbar.make(it, "Silmek istiyor musunuz?", Snackbar.LENGTH_SHORT).setAction("EVET") {
                Snackbar.make(it, "Silindi", Snackbar.LENGTH_SHORT).show()
            }.setBackgroundTint(Color.BLUE)
                .setTextColor(Color.WHITE)
                .setActionTextColor(Color.RED)
                .show()
        }

        tasarim.buttonAlert.setOnClickListener {
         /*   val ad = AlertDialog.Builder(this)
            ad.setTitle("Başlık")
            ad.setMessage("İçerik")
            ad.setIcon(R.drawable.ic_android_black_24dp)

            ad.setPositiveButton("Tamam"){ s,d ->
                Toast.makeText(this, "Tamam Seçildi", Toast.LENGTH_SHORT).show()
            }

            ad.setNegativeButton("İptal"){ s,d ->
                Toast.makeText(this, "İptal Seçildi", Toast.LENGTH_SHORT).show()
            }
            ad.create().show()*/

            val ad = AlertDialog.Builder(this)
            //inflate
            var alertTasarim = layoutInflater.inflate(R.layout.alert_tasarim,null)
            val textViewAlert = alertTasarim.findViewById(R.id.textView) as TextView
            val editTextAlert = alertTasarim.findViewById(R.id.editText) as EditText
            val checBoxAlert = alertTasarim.findViewById(R.id.checkBox) as CheckBox
            val buttonKaydet = alertTasarim.findViewById(R.id.button) as Button
            ad.setView(alertTasarim)

            textViewAlert.text = "Yapılacaklar"
            val d = ad.create()

            buttonKaydet.setOnClickListener {
                val yapilacakIs = editTextAlert.text.toString()
                val acilDurum = checBoxAlert.isChecked
                Toast.makeText(this, "$yapilacakIs - $acilDurum", Toast.LENGTH_SHORT).show()
                d.dismiss()
            }


            ad.create().show()
        }
    }
}