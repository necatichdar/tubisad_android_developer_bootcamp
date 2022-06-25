package com.chdarsoft.calismayapisi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chdarsoft.calismayapisi.databinding.ActivityOyunEkraniBinding
import com.chdarsoft.calismayapisi.databinding.ActivitySonucEkraniBinding
import com.google.android.material.snackbar.Snackbar

class SonucEkraniActivity : AppCompatActivity() {
    private lateinit var tasarim: ActivitySonucEkraniBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivitySonucEkraniBinding.inflate(layoutInflater)
        setContentView(tasarim.root)
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        Snackbar.make(tasarim.textView3, "Geri dönmek istiyor musunuz?", Snackbar.LENGTH_SHORT)
            .setAction("EVET"){
                super.onBackPressed()
            }.show()
    }
}