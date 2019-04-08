package com.jacr.pruebatecnica.presentation.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.*
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import toothpick.Toothpick


/**
 * Created: 3/2/19.
 * Author: jesus.castro
 */
abstract class BaseActivity<in T : ViewDataBinding, V : ViewModel> : AppCompatActivity(),
    BaseView<T, V> {

    lateinit var navController: NavController

    open fun getNavigationContainerResource(): Int = -1
    open fun getActivity(): AppCompatActivity = this

    //<editor-fold desc="UI Overrides">

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activity = getActivity()
        Toothpick.inject(activity, Toothpick.openScope(application))
        val binding = DataBindingUtil.setContentView<T>(activity, getLayoutResource())
        val viewModel = ViewModelProviders.of(this, getViewModelProvider()).get(getViewModelClass())
        val navContentRes = getNavigationContainerResource()
        if (navContentRes != -1)
            navController = findNavController(activity, getNavigationContainerResource())
        onInit(binding, viewModel)
    }

    override fun onDestroy() {
        Toothpick.closeScope(getActivity())
        super.onDestroy()
    }

    //</editor-fold>

}