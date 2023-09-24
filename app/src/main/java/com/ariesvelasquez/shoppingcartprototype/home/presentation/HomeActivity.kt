package com.ariesvelasquez.shoppingcartprototype.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ariesvelasquez.shoppingcartprototype.R
import com.ariesvelasquez.shoppingcartprototype.common.presentation.BaseActivity
import com.ariesvelasquez.shoppingcartprototype.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()

    override fun initViewModel() {
        super.initViewModel()
        viewModel.getProducts()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override val bindingInflater: (LayoutInflater) -> ActivityHomeBinding
        get() = ActivityHomeBinding::inflate
}