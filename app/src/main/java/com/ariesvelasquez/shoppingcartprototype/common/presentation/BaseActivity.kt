package com.ariesvelasquez.shoppingcartprototype.common.presentation


import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.ariesvelasquez.shoppingcartprototype.R
import com.ariesvelasquez.shoppingcartprototype.common.presentation.dialog.ProgressDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder

abstract class BaseActivity<VB : ViewBinding> :
    AppCompatActivity() {

    lateinit var binding: VB
        private set

    abstract val bindingInflater: (LayoutInflater) -> VB

    private var progressDialog: ProgressDialog? = null

    protected open fun handleIntentData(savedInstanceState: Bundle?) = Unit
    protected open fun initToolbar(savedInstanceState: Bundle?) = Unit
    protected open fun initViewModel() = Unit
    protected open fun initViews() = Unit // Initialize adapters, etc.
    protected open fun initViewEvents() = Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleIntentData(savedInstanceState)
        bindContentLayout()
        initToolbar(savedInstanceState)
        initViewModel()
        initViews()
        initViewEvents()
    }

    private fun bindContentLayout() {
        binding = bindingInflater.invoke(layoutInflater)
        setContentView(binding.root)
    }

    fun showProgressDialog(tag: String) {
        progressDialog = ProgressDialog.newInstance()
        progressDialog?.show(supportFragmentManager, tag)
    }

    fun dismissProgressDialog() {
        progressDialog?.dismiss()
    }

    fun handleOnError(throwable: Throwable) {
        showDialog(message = throwable.message)
    }

    fun showDialog(
        title: String? = getString(R.string.error),
        message: String? = getString(R.string.error_something_went_wrong)
    ) {

        MaterialAlertDialogBuilder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(
                R.string.okay
            ) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}