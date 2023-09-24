package com.ariesvelasquez.shoppingcartprototype.home.presentation.shop

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ariesvelasquez.shoppingcartprototype.common.presentation.BaseFragment
import com.ariesvelasquez.shoppingcartprototype.databinding.FragmentShopBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopFragment : BaseFragment<FragmentShopBinding>() {

    override fun initViewEvents() {
        super.initViewEvents()

    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentShopBinding
        get() = FragmentShopBinding::inflate
}