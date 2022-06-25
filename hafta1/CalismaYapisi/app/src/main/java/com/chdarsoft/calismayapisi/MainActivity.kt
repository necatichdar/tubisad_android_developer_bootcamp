package com.chdarsoft.calismayapisi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.chdarsoft.calismayapisi.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_oyun_ekrani.*

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        tasarim.buttonBasla.setOnClickListener {
            //Snackbar.make(it, "Merhaba", Snackbar.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity,OyunEkraniActivity::class.java)
            intent.putExtra("ad","Necati")
            intent.putExtra("yas", 23)
            intent.putExtra("boy", 1.78)
            intent.putExtra("bekar", true)
            startActivity(intent)
        }

        Log.e("Yaşam Döngüsü", "onCreate Çalıştı")
    }

    override fun onStart() {
        super.onStart()
        Log.e("Yaşam Döngüsü", "onStart Çalıştı")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Yaşam Döngüsü", "onResume Çalıştı")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Yaşam Döngüsü", "onResume Çalıştı")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Yaşam Döngüsü", "onStop Çalıştı")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Yaşam Döngüsü", "onDestroy Çalıştı")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("Yaşam Döngüsü", "onRestart Çalıştı")
    }


}