package com.jacr.movieapp.presentation.viewmodel.navigation

import android.view.MenuItem
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created: 3/2/19.
 * Author: jesus.castro
 */
class NavViewModel : ViewModel() {

    var navigationEventLiveData = MutableLiveData<Int>()
        private set

    //<editor-fold desc="Actions">

    fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.isChecked = true
        navigationEventLiveData.postValue(item.itemId)
        return false
    }

    //</editor-fold>

}