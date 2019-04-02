package com.jacr.movieapp.presentation.viewmodel.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * Created: 3/2/19.
 * Author: jesus.castro
 */
@Suppress("UNCHECKED_CAST")
class NavViewModelProvider @Inject constructor(): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>) = NavViewModel() as T

}