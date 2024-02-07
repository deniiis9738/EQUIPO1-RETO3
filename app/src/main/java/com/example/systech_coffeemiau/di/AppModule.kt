package com.example.systech_coffeemiau.di

import com.example.systech_coffeemiau.data.repositories.ProductRepositoryImpl
import com.example.systech_coffeemiau.data.sources.local.LocalProductoDataSource
import com.example.systech_coffeemiau.data.sources.remote.ISystechApiService
import com.example.systech_coffeemiau.data.sources.remote.RemoteProductoDataSource
import com.example.systech_coffeemiau.domain.repositories.IProductRepository
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
            .baseUrl("http://127.0.0.1:8888/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .client(OkHttpClient.Builder().build())
            .build()

        return retrofit.create(ISystechApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(
        remoteDataSource: RemoteProductoDataSource,
        localDataSource: LocalProductoDataSource
    ): IProductRepository {
        return ProductRepositoryImpl(remoteDataSource, localDataSource)
    }
}
