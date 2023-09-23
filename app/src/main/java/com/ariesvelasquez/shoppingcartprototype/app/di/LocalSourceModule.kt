package com.ariesvelasquez.shoppingcartprototype.app.di

import com.ariesvelasquez.shoppingcartprototype.home.data.source.ProductLocalDataSourceImpl
import com.ariesvelasquez.shoppingcartprototype.home.data.source.ProductSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSourceModule {

    @Binds
    abstract fun product(impl: ProductLocalDataSourceImpl): ProductSource
}