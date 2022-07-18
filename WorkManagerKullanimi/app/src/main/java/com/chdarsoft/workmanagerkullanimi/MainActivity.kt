package com.chdarsoft.workmanagerkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.*
import com.chdarsoft.workmanagerkullanimi.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        tasarim.buttonYap.setOnClickListener {
            /*
            val calismaKosulu = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
            val istek = OneTimeWorkRequestBuilder<MyWorker>()
                .setInitialDelay(4, TimeUnit.SECONDS)
                .build()
            WorkManager.getInstance(this).enqueue(istek)


            WorkManager.getInstance(this).getWorkInfoByIdLiveData(istek.id).observe(this) {
                val durum = it.state.name
                Log.e("Arkaplan", durum)
            }*/

            val istek = PeriodicWorkRequestBuilder<MyWorkerBildirim>(15, TimeUnit.MINUTES)
                .setInitialDelay(10, TimeUnit.SECONDS)
                .build()
            WorkManager.getInstance(this).enqueue(istek
            )
        }
    }
}