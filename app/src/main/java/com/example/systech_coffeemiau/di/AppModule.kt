package com.example.systech_coffeemiau.di

import android.app.Application
import com.example.systech_coffeemiau.data.repositories.ApiRepositoryImpl
import com.example.systech_coffeemiau.data.repositories.FallBackRepositoryImpl
import com.example.systech_coffeemiau.data.repositories.ISystechApiService
import com.example.systech_coffeemiau.data.repositories.JsonRepositoryImpl
import com.example.systech_coffeemiau.domain.repositories.ISystechSolutionsRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): ISystechApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.56.1:8888/api/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .client(OkHttpClient.Builder().build())
            .build()

        return retrofit.create(ISystechApiService::class.java)
    }
    @Provides
    @Singleton
    fun providesApiRepositoryImpl(iSystechApiService: ISystechApiService): ApiRepositoryImpl {
        return ApiRepositoryImpl(iSystechApiService)
    }

    @Provides
    @Singleton
    fun providesJsonRepositoryImpl(application: Application): JsonRepositoryImpl {
        return JsonRepositoryImpl(application)
    }

    @Provides
    @Singleton
    fun provideFallBackRepositoryImpl(apiRepositoryImpl: ApiRepositoryImpl, jsonRepositoryImpl: JsonRepositoryImpl): FallBackRepositoryImpl {
        return FallBackRepositoryImpl(apiRepositoryImpl, jsonRepositoryImpl)
    }

    @Provides
    @Singleton
    fun provideSystechRepository(fallBackRepositoryImpl: FallBackRepositoryImpl): ISystechSolutionsRepository {
        return fallBackRepositoryImpl
    }
}