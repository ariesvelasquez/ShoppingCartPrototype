package com.ariesvelasquez.shoppingcartprototype.common.presentation.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ariesvelasquez.shoppingcartprototype.R
import com.ariesvelasquez.shoppingcartprototype.databinding.DialogProgressBinding

class ProgressDialog : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, R.style.BaseDialogTheme)
        dialog?.window?.attributes?.windowAnimations = R.style.FadeInFadeOutAnimation
        isCancelable = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return DialogProgressBinding.inflate(inflater).root
    }

    companion object {
        fun newInstance() = ProgressDialog()
    }
}