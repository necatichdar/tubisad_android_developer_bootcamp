package com.chdarsoft.konumkullanimi

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.chdarsoft.konumkullanimi.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim: ActivityMainBinding
    private var izinKontrol = 0
    private lateinit var flpc:FusedLocationProviderClient
    private lateinit var locationTask: Task<Location>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        flpc = LocationServices.getFusedLocationProviderClient(this)

        tasarim.buttonKonumAl.setOnClickListener {
            izinKontrol =
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)

            if (izinKontrol == PackageManager.PERMISSION_GRANTED) {// İzin onaylandıysa..
                locationTask = flpc.lastLocation
                konumBilgisiAl()
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    0
                )
            }
        }
    }

    fun konumBilgisiAl() {
        locationTask.addOnSuccessListener {
            if( it != null){
                tasarim.textViewSonuc.text = "${it.latitude} - ${it.longitude}"
            }else{
                tasarim.textViewSonuc.text = "Konum Bilgisi Yok"
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        izinKontrol =
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(applicationContext, "İzin onaylandı.", Toast.LENGTH_LONG).show()
            locationTask = flpc.lastLocation
            konumBilgisiAl()
        } else {
            Toast.makeText(applicationContext, "İzin reddedildi.", Toast.LENGTH_LONG).show()
        }
    }
}