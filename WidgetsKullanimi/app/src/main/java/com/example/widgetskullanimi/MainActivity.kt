package com.example.widgetskullanimi

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import com.example.widgetskullanimi.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        tasarim.buttonResim1.setOnClickListener {
            tasarim.imageView.setImageResource(R.drawable.resim1)
        }

        tasarim.buttonResim2.setOnClickListener {
            tasarim.imageView.setImageResource(resources
                .getIdentifier("resim2","drawable",packageName))
        }

        tasarim.switch1.setOnCheckedChangeListener { s, b ->
            if(b){
                Log.e("Widgets","Switch : ON")
            }else{
                Log.e("Widgets","Switch : OFF")
            }
        }

        tasarim.checkBoxKotlin.setOnCheckedChangeListener { c, b ->
            if(b){
                Log.e("Widgets","Kotlin : ON")
            }else{
                Log.e("Widgets","Kotlin : OFF")
            }
        }

        tasarim.checkBoxJava.setOnCheckedChangeListener { c, b ->
            if(b){
                Log.e("Widgets","Java : ON")
            }else{
                Log.e("Widgets","Java : OFF")
            }
        }

        tasarim.radioButtonBarcelona.setOnCheckedChangeListener { r, b ->
            if(b){
                Log.e("Widgets","Barcelona : ON")
            }else{
                Log.e("Widgets","Barcelona : OFF")
            }
        }

        tasarim.radioButtonRealMadrid.setOnCheckedChangeListener { r, b ->
            if(b){
                Log.e("Widgets","Real Madrid : ON")
            }else{
                Log.e("Widgets","Real Madrid : OFF")
            }
        }

        tasarim.buttonAc.setOnClickListener {
            tasarim.progressBar.visibility = View.VISIBLE
        }

        tasarim.buttonKapa.setOnClickListener {
            tasarim.progressBar.visibility = View.INVISIBLE
        }

        tasarim.textViewSlider.text = tasarim.slider.progress.toString()
        tasarim.slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tasarim.textViewSlider.text = p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        tasarim.buttonSaat.setOnClickListener {
            val calendar = Calendar.getInstance()
            val saat = calendar.get(Calendar.HOUR_OF_DAY)
            val dakika = calendar.get(Calendar.MINUTE)

            val tp = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                tasarim.editTextSaat.setText("$i : $i2")
            }, saat,dakika, true)

            tp.setButton(DialogInterface.BUTTON_POSITIVE, "Seç", tp)
            tp.setButton(DialogInterface.BUTTON_NEGATIVE, "İptal", tp)
            tp.show()
        }

        tasarim.buttonTarih.setOnClickListener {
            val calendar = Calendar.getInstance()
            val yil = calendar.get(Calendar.YEAR)
            val ay = calendar.get(Calendar.MONTH)
            val gun = calendar.get(Calendar.DAY_OF_MONTH)

            val dp = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { d, y, a, g->
                tasarim.editTextTarih.setText("$g/${a+1}/$y")
            }, yil, ay, gun)

            dp.setButton(DialogInterface.BUTTON_POSITIVE, "Seç", dp)
            dp.setButton(DialogInterface.BUTTON_NEGATIVE, "İptal", dp)
            dp.show()
        }

        val ulkeler = ArrayList<String>()
        ulkeler.add("Türkiye")
        ulkeler.add("Almanya")
        ulkeler.add("İtalya")
        ulkeler.add("İngiltere")

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, android.R.id.text1, ulkeler)
        tasarim.spinner.adapter = adapter

        tasarim.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View, p2: Int, p3: Long) {
                Snackbar.make(p1, "${ulkeler.get(p2)} seçildi.", Snackbar.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        tasarim.buttonGoster.setOnClickListener {
            Log.e("Widgets","Switch en son durum : ${tasarim.switch1.isChecked}")
            Log.e("Widgets","Kotlin en son durum : ${tasarim.checkBoxKotlin.isChecked}")
            Log.e("Widgets","Java en son durum : ${tasarim.checkBoxJava.isChecked}")
            Log.e("Widgets","Barcelona en son durum : ${tasarim.radioButtonBarcelona.isChecked}")
            Log.e("Widgets","Real Madrid en son durum : ${tasarim.radioButtonRealMadrid.isChecked}")
            Log.e("Widgets","Slider en son durum : ${tasarim.slider.progress}")
            Log.e("Widgets","Spinner en son durum : ${tasarim.spinner.selectedItemPosition}")
            Log.e("Widgets","Spinner en son durum : ${ulkeler.get(tasarim.spinner.selectedItemPosition)}")
        }
    }
}