package com.ariesvelasquez.shoppingcartprototype.home.domain

import com.ariesvelasquez.shoppingcartprototype.common.domain.BaseUseCase
import com.ariesvelasquez.shoppingcartprototype.home.domain.model.Product
import javax.inject.Inject

class GetProducts
@Inject
constructor(
    private val homeRepository: HomeRepository
) : BaseUseCase<List<Product>>() {

    override suspend fun executeOnBackground(): List<Product> {
        return homeRepository.getProducts()
    }
}