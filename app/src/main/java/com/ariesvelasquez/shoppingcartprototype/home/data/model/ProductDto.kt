package com.ariesvelasquez.shoppingcartprototype.home.data.model

@kotlinx.serialization.Serializable
data class ProductDto(
    val id: String? = null,
    val name: String? = null,
    val category: String? = null,
    val price: String? = null,
    val bgColor: String? = null
)