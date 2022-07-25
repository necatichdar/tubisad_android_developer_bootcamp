package com.chdarsoft.picassokullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import com.chdarsoft.picassokullanimi.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        tasarim.buttonResim1.setOnClickListener {
            resimGoster("ayran")
        }

        tasarim.buttonResim2.setOnClickListener {
            resimGoster("su")
        }
    }

    fun resimGoster(resimAdi:String) {
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/$resimAdi.png"
        Picasso.get().load(url).into(tasarim.imageView)
    }

}