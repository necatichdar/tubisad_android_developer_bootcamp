package com.chdarsoft.odev7todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chdarsoft.odev7todoapp.data.entity.YapilacakIs

@Database(entities = [YapilacakIs::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun getYapilacaklarDao(): YapilacaklarDao
}