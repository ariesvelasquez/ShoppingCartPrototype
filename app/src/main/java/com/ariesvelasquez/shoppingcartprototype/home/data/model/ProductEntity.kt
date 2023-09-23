package com.ariesvelasquez.shoppingcartprototype.home.data.model

import com.google.gson.annotations.SerializedName

@kotlinx.serialization.Serializable
data class ProductEntity(
    @SerializedName("products")
    val products: List<ProductDto>? = null
)