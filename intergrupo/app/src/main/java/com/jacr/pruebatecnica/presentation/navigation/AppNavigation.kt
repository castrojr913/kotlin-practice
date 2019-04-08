package com.jacr.pruebatecnica.presentation.navigation

import com.jacr.pruebatecnica.presentation.ui.prospects.ProspectsActivity
import com.jacr.pruebatecnica.presentation.utilities.NavigationHelper
import com.jacr.pruebatecnica.presentation.viewmodel.navigation.Navigation
import com.jacr.pruebatecnica.presentation.viewmodel.navigation.NavigationView

/**
 * Created: 4/8/19.
 * Author: jesus.castro
 */
class AppNavigation : Navigation {

    override fun redirectTo(view: NavigationView) {
        when (view) {
            // TODO Resolve this
            NavigationView.PROSPECTS -> NavigationHelper.redirectTo(null, ProspectsActivity::javaClass, true)
        }
    }

}