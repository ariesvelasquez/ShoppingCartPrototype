package com.ariesvelasquez.shoppingcartprototype.common.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding>: Fragment() {

    lateinit var binding: VB
        private set

    protected open fun handleBundleData(savedInstanceState: Bundle?) = Unit
    protected open fun initActivityToolbar(savedInstanceState: Bundle?) = Unit
    protected open fun initViewModel() = Unit
    protected open fun initViews() = Unit // Initialize adapters, etc.
    protected open fun initViewEvents() = Unit


    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleBundleData(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindingInflater.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initActivityToolbar(savedInstanceState)
        initViewModel()
        initViews()
        initViewEvents()
    }

    fun showProgressAlertDialog(tag: String) {
        (activity as BaseActivity<*>).showProgressDialog(tag)
    }

    fun dismissProgressAlertDialog() {
        (activity as BaseActivity<*>).dismissProgressDialog()
    }

    fun handleOnError(throwable: Throwable) {
        (activity as BaseActivity<*>).handleOnError(throwable)
    }
}