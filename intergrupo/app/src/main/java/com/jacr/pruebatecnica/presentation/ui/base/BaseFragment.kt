package com.jacr.pruebatecnica.presentation.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import toothpick.Toothpick

/**
 * Created: 3/2/19.
 * Author: jesus.castro
 */
abstract class BaseFragment<in T : ViewDataBinding, V: ViewModel> : Fragment(),
    BaseView<T, V> {

    open fun getFragment(): Fragment = this

    //<editor-fold desc="UI Overrides">

    override fun onAttach(context: Context?) {
        val f = getFragment()
        Toothpick.inject(f, Toothpick.openScopes(activity?.applicationContext, f))
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<T>(inflater, getLayoutResource(), container, false)
        val viewModel = ViewModelProviders.of(this, getViewModelProvider()).get(getViewModelClass())
        onInit(binding, viewModel)
        return binding.root
    }

    override fun onDetach() {
        Toothpick.closeScope(getFragment())
        super.onDetach()
    }

    //</editor-fold>

}