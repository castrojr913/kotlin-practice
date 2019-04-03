package com.jacr.pruebatecnica.presentation.utilities

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputLayout

/**
 * Created: 3/2/19.
 * Author: jesus.castro
 */
object CustomBindings {

    //@JvmStatic
    @BindingAdapter("onNavigationItemSelected")
    fun setOnNavigationItemSelected(
        view: BottomNavigationView,
        listener: BottomNavigationView.OnNavigationItemSelectedListener
    ) = view.setOnNavigationItemSelectedListener(listener)

    //@JvmStatic
    @BindingAdapter("error")
    fun setErrorMessage(view: TextInputLayout, errorMessage: ObservableField<String>) {
       view.error = errorMessage.get()
    }

}

