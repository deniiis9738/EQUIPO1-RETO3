package com.example.systech_coffeemiau.di

import android.app.Application
import com.example.systech_coffeemiau.data.repositories.ApiRepositoryImpl
import com.example.systech_coffeemiau.data.repositories.FallBackRepositoryImpl
import com.example.systech_coffeemiau.data.repositories.ISystechApiService
import com.example.systech_coffeemiau.data.repositories.JsonRepositoryImpl
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val loggingInterceptor = okhttp3.logging.HttpLoggingInterceptor()
        loggingInterceptor.level = okhttp3.logging.HttpLoggingInterceptor.Level.BODY
        val okHttpClient = okhttp3.OkHttpClient.Builder().addInterceptor(loggingInterceptor)
            .writeTimeout(0, java.util.concurrent.TimeUnit.MILLISECONDS)
            .readTimeout(2, java.util.concurrent.TimeUnit.MINUTES)
            .connectTimeout(1, java.util.concurrent.TimeUnit.MINUTES).build()

        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssX").create()

        return Retrofit.Builder()
            .baseUrl("http://192.168.56.1:8888/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun providesSystechService(retrofit: Retrofit): ISystechApiService {
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
}