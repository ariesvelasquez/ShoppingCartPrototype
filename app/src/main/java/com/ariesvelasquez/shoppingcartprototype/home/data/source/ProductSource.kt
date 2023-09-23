package com.ariesvelasquez.shoppingcartprototype.home.data.source

import com.ariesvelasquez.shoppingcartprototype.home.domain.model.Product

interface ProductSource {
    fun getProducts() : List<Product>
}