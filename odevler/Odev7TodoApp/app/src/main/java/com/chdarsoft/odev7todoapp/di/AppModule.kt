package com.chdarsoft.odev7todoapp.di

import android.content.Context
import androidx.room.Room
import com.chdarsoft.odev7todoapp.data.repo.YapilacakIsDaoRepository
import com.chdarsoft.odev7todoapp.room.Veritabani
import com.chdarsoft.odev7todoapp.room.YapilacaklarDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYapilacakIsDaoRepository(dao:YapilacaklarDao) : YapilacakIsDaoRepository{
        return YapilacakIsDaoRepository(dao)
    }

    @Provides
    @Singleton
    fun provideYapilacaklarDao(@ApplicationContext context: Context) : YapilacaklarDao{
        val vt = Room.databaseBuilder(context,Veritabani::class.java, "todo.sqlite" )
            .createFromAsset("todo.sqlite").build()
        return vt.getYapilacaklarDao()
    }
}