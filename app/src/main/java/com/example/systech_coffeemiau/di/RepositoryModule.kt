package com.example.systech_coffeemiau.di

import com.example.systech_coffeemiau.data.repositories.FallBackRepositoryImpl
import com.example.systech_coffeemiau.domain.repositories.ISystechSolutionsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(fallBackRepositoryImpl: FallBackRepositoryImpl): ISystechSolutionsRepository
}