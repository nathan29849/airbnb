package com.example.airbnb.di

import android.app.Application
import com.example.airbnb.common.MainApplication
import com.example.airbnb.ui.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    fun provideApplication(): Application {
        return MainApplication()
    }
}