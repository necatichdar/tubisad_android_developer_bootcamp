package com.chdarsoft.daggerkullanimi

import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideAdres() : Adres {
        return Adres("Polatlı/Ankara")
    }
    // Singleton : Nesnenin bir kere oluşturulup, heryerden erişilmesi.
}