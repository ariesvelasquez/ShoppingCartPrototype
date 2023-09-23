package com.ariesvelasquez.shoppingcartprototype.home.data.source

import android.content.Context
import com.ariesvelasquez.shoppingcartprototype.common.helper.JsonHelper
import com.ariesvelasquez.shoppingcartprototype.home.data.mapper.Mapper.transform
import com.ariesvelasquez.shoppingcartprototype.home.data.model.ProductEntity
import com.ariesvelasquez.shoppingcartprototype.home.domain.model.Product
import com.google.gson.JsonParseException
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class ProductLocalDataSourceImpl
@Inject constructor(
    @ApplicationContext private val appContext: Context
) : ProductSource {

    override fun getProducts(): List<Product> {
        lateinit var jsonString: String
        try {
            jsonString = appContext.assets.open("products.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (e: IOException) {
            Timber.e("$e")
            throw JsonParseException("")
        }

        return JsonHelper.fromJson<ProductEntity>(jsonString).let {
            it.products?.transform()
        } ?: mutableListOf()
    }
}