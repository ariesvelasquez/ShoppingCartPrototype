package com.ariesvelasquez.shoppingcartprototype.app.di

import com.ariesvelasquez.shoppingcartprototype.home.data.HomeRepositoryImpl
import com.ariesvelasquez.shoppingcartprototype.home.domain.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideHomeRepository(
        impl: HomeRepositoryImpl
    ): HomeRepository
}