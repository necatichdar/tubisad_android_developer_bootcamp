package com.example.kisileruygulamasi.di

import com.example.kisileruygulamasi.data.repo.KisilerDaoRepository
import com.example.kisileruygulamasi.retrofit.ApiUtils
import com.example.kisileruygulamasi.retrofit.KisilerDao
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
    fun provideKisilerDaoRepository(kdao:KisilerDao) : KisilerDaoRepository {
        return  KisilerDaoRepository(kdao)
    }

    @Provides
    @Singleton
    fun provideKisilerDao() : KisilerDao {
        return ApiUtils.getKisilerDao()
    }
}