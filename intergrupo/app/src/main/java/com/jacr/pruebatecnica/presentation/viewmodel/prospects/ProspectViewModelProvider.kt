package com.jacr.pruebatecnica.presentation.viewmodel.prospects

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * Created: 4/7/19.
 * Author: jesus.castro
 */
@Suppress("UNCHECKED_CAST")
class ProspectViewModelProvider @Inject constructor() : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>) = ProspectViewModel() as T

}