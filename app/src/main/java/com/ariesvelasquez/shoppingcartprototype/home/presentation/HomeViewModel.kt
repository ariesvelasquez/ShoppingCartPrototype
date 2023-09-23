package com.ariesvelasquez.shoppingcartprototype.home.presentation

import com.ariesvelasquez.shoppingcartprototype.common.presentation.BaseViewModel
import com.ariesvelasquez.shoppingcartprototype.home.domain.GetProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val getProducts: GetProducts
) : BaseViewModel() {

    fun getProducts() {
        getProducts.execute {
            onComplete {
                Timber.e("Success $it")
            }
            onError {
                Timber.e("onError $it")
            }
        }
    }
}