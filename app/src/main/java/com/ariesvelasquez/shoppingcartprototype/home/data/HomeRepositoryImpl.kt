package com.ariesvelasquez.shoppingcartprototype.home.data

import com.ariesvelasquez.shoppingcartprototype.home.data.source.ProductSource
import com.ariesvelasquez.shoppingcartprototype.home.domain.HomeRepository
import com.ariesvelasquez.shoppingcartprototype.home.domain.model.Product
import javax.inject.Inject

class HomeRepositoryImpl
@Inject constructor(
    private val productSource: ProductSource
) : HomeRepository {

    override fun getProducts(): List<Product> {
        return productSource.getProducts()
    }
}