package com.chdarsoft.calismayapisi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.chdarsoft.calismayapisi.databinding.ActivityOyunEkraniBinding

class OyunEkraniActivity : AppCompatActivity() {
    private lateinit var tasarim:ActivityOyunEkraniBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityOyunEkraniBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        val gelenAd = intent.getStringExtra("ad")
        val gelenYas = intent.getIntExtra("yas",0)
        val gelenBoy = intent.getDoubleExtra("boy", 0.0)
        val gelenBekar  = intent.getBooleanExtra("bekar", false)

        Log.e("Gelen Ad", gelenAd!!)
        Log.e("Gelen yas", gelenYas.toString())
        Log.e("Gelen boy", gelenBoy.toString())
        Log.e("Gelen bekar", gelenBekar.toString())

        tasarim.buttonBitir.setOnClickListener {
            val intent = Intent(this@OyunEkraniActivity,SonucEkraniActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}