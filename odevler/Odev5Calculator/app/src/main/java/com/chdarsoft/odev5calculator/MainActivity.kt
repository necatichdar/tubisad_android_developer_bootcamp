package com.chdarsoft.odev5calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chdarsoft.odev5calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        var degisken = 0;
        var islemler = " ";

        fun sonucuYaz() {
            tasarim.sonuc.text = degisken.toString()
            tasarim.islemler.text = islemler.toString()
        }
        fun islemYap(sayi:Int){
            if (islemler.last() == sayi.toChar()){
            }else if (islemler.last() == '+' || islemler.last() == ' '){
                islemler += " $sayi"
                degisken += sayi
            }
            println(degisken)
            sonucuYaz()
        }

        tasarim.button1.setOnClickListener {
            islemYap(1)
        }
        tasarim.button2.setOnClickListener {
            islemYap(2)
        }
        tasarim.button3.setOnClickListener {
            islemYap(3)
        }
        tasarim.button4.setOnClickListener {
            islemYap(4)
        }
        tasarim.button5.setOnClickListener {
            islemYap(5)
        }
        tasarim.button6.setOnClickListener {
            islemYap(6)
        }
        tasarim.button7.setOnClickListener {
            islemYap(7)
        }
        tasarim.button8.setOnClickListener {
            islemYap(8)
        }
        tasarim.button9.setOnClickListener {
            islemYap(9)
        }
        tasarim.button0.setOnClickListener {
            islemYap(0)
        }
        tasarim.buttonC.setOnClickListener {
            degisken = 0
            islemler = " ";
            sonucuYaz()
        }
        tasarim.buttonPlus.setOnClickListener {

            if (islemler.last() != '+' && islemler.last() != ' '){
                islemler += " +"
                sonucuYaz()
            }
        }



    }
}