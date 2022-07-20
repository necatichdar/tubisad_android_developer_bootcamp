package com.example.kisileruygulamasi.room

import androidx.room.*
import com.example.kisileruygulamasi.data.entity.Kisiler

@Dao
interface KisilerDao {
    @Query("select * from kisiler")
    suspend fun tumKisiler() : List<Kisiler>

    @Insert
    suspend fun kisiEkle(kisi:Kisiler)

    @Update
    suspend fun kisiGuncelle(kisi:Kisiler)

    @Delete
    suspend fun kisiSil(kisi:Kisiler)

    @Query("select * from kisiler where kisi_ad like '%' || :aramaKelimesi || '%'")
    suspend fun kisiAra(aramaKelimesi :String) : List<Kisiler>

}