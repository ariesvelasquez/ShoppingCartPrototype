package com.ariesvelasquez.shoppingcartprototype.home.presentation.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.ariesvelasquez.shoppingcartprototype.common.presentation.BaseFragment
import com.ariesvelasquez.shoppingcartprototype.databinding.FragmentCartBinding
import com.ariesvelasquez.shoppingcartprototype.home.presentation.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class CartFragment : BaseFragment<FragmentCartBinding>() {

    private val viewModel: HomeViewModel by activityViewModels()

    override fun initViewModel() {
        super.initViewModel()

        viewModel.cartItems.observe(viewLifecycleOwner) {
            Timber.e("Cart $it")
        }
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCartBinding
        get() = FragmentCartBinding::inflate
}