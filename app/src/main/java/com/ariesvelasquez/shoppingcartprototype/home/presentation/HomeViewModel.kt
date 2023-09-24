package com.ariesvelasquez.shoppingcartprototype.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.ariesvelasquez.shoppingcartprototype.common.presentation.BaseViewModel
import com.ariesvelasquez.shoppingcartprototype.home.domain.GetProducts
import com.ariesvelasquez.shoppingcartprototype.home.domain.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val getProducts: GetProducts
) : BaseViewModel() {

    private val _cartList = MutableLiveData<List<Product>>()
    val cartList: LiveData<List<Product>> get() = _cartList

    val cartCount = _cartList.map {
        it.count()
    }

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    fun getProducts() {
        getProducts.execute {
            onComplete {
                _products.value = it
                Timber.e("Success $it")
            }
            onError {
                Timber.e("onError $it")
            }
        }
    }
}