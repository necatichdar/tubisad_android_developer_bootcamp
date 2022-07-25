package com.example.kisileruygulamasi.retrofit

import com.example.kisileruygulamasi.data.entity.CRUDCevap
import com.example.kisileruygulamasi.data.entity.KisilerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KisilerDao {
    //http://kasimadalan.pe.hu/kisiler/tum_kisiler.php

    @GET("kisiler/tum_kisiler.php")
    fun tumKisiler(): Call<KisilerCevap>

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    fun kisiAra(@Field("kisi_ad") aramaKelimesi: String): Call<KisilerCevap>

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    fun kisiEkle(
        @Field("kisi_ad") kisi_ad: String, @Field("kisi_tel") kisi_tel: String
    ): Call<CRUDCevap>

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    fun kisiGuncelle(
        @Field("kisi_id") kisi_id: Int,
        @Field("kisi_ad") kisi_ad: String,
        @Field("kisi_tel") kisi_tel: String
    ): Call<CRUDCevap>

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    fun kisiSil(
        @Field("kisi_id") kisi_id: Int
    ): Call<CRUDCevap>
}