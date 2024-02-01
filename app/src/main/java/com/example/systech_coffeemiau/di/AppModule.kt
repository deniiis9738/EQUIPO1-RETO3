package com.example.systech_coffeemiau.di

import com.example.systech_coffeemiau.data.repositories.ApiRepositoryImpl
import com.example.systech_coffeemiau.data.repositories.ISystechApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesApiRepositoryImpl(iSystechApiService: ISystechApiService): ApiRepositoryImpl {
        return ApiRepositoryImpl(iSystechApiService)
    }
}