package com.chdarsoft.daggerkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    //Dagger yapısı private değişkene erişemez
    @Inject
    lateinit var kargo: Kargo

    @Inject
    lateinit var internet: Internet
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerAppComponent.builder().build().inject(this)

        kargo.gonder()

        internet.basvuruYap()
    }
}