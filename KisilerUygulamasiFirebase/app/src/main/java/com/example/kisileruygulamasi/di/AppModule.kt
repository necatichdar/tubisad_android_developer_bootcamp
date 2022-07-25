package com.example.kisileruygulamasi.di

import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerDaoRepository(refKisiler: DatabaseReference) : KisilerDaoRepository {
        return  KisilerDaoRepository(refKisiler)
    }

    @Provides
    @Singleton
    fun provideDatabaseReference() : DatabaseReference {
        val db = FirebaseDatabase.getInstance()
        return db.getReference("kisiler")
    }

}