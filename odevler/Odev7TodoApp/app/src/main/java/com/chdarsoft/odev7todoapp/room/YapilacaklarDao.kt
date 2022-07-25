package com.chdarsoft.odev7todoapp.room

import androidx.room.*
import com.chdarsoft.odev7todoapp.data.entity.YapilacakIs

@Dao
interface YapilacaklarDao {
    @Query("select * from yapilacaklar")
    suspend fun tumYapilacaklar() : List<YapilacakIs>

    @Insert
    suspend fun yapilacakEkle(yapilacakIs: YapilacakIs)

    @Update
    suspend fun yapilacakGuncelle(yapilacakIs: YapilacakIs)

    @Delete
    suspend fun yapilacakSil(yapilacakIs: YapilacakIs)

    @Query("select * from yapilacaklar where yapilacak_is like '%' || :aramaKelimesi || '%'")
    suspend fun yapilacakAra(aramaKelimesi:String) : List<YapilacakIs>

}