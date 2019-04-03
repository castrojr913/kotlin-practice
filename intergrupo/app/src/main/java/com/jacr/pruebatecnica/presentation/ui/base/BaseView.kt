package com.jacr.pruebatecnica.presentation.ui.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created: 3/2/19.
 * Author: jesus.castro
 */
interface BaseView<in T : ViewDataBinding, V : ViewModel> {

    fun getViewModelProvider(): ViewModelProvider.Factory
    fun getViewModelClass(): Class<out V>
    fun getLayoutResource(): Int
    fun onInit(binding: T, viewModel: V)

}