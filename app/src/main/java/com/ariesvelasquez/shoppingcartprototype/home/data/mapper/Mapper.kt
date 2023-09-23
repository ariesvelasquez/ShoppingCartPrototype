package com.ariesvelasquez.shoppingcartprototype.home.data.mapper

import com.ariesvelasquez.shoppingcartprototype.home.data.model.ProductDto
import com.ariesvelasquez.shoppingcartprototype.home.domain.model.Product

object Mapper {

    fun List<ProductDto>.transform(): List<Product> {
        return this.map {
            Product(
                id = it.id,
                name = it.name,
                category = it.category,
                price = it.price,
                bgColor = it.bgColor
            )
        }
    }
}