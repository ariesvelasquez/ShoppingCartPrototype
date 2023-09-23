package com.ariesvelasquez.shoppingcartprototype.home.domain

import com.ariesvelasquez.shoppingcartprototype.home.domain.model.Product
import java.io.IOException

interface HomeRepository {
    @Throws(IOException::class)
    fun getProducts() : List<Product>
}