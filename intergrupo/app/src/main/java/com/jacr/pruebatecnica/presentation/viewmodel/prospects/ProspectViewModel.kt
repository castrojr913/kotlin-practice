package com.jacr.pruebatecnica.presentation.viewmodel.prospects

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.jacr.pruebatecnica.model.data.dtos.Dto
import com.jacr.pruebatecnica.model.data.dtos.response.ProspectDto
import com.jacr.pruebatecnica.model.domain.prospect.ProspectDomain
import com.jacr.pruebatecnica.presentation.utilities.MessageHelper
import javax.inject.Inject

/**
 * Created: 4/7/19.
 * Author: jesus.castro
 */
class ProspectViewModel @Inject constructor(val domain: ProspectDomain, val context: Context) : ViewModel(),
    Observer<List<Dto<ProspectDto>>> {


    //<editor-fold desc="Variables">

    var prospectCollectionLiveData: LiveData<List<Dto<ProspectDto>>> = MutableLiveData()

    //</editor-fold>

    //<editor-fold desc="Observable Props">

    //</editor-fold>

    init {
        prospectCollectionLiveData = domain.getProspects()
        prospectCollectionLiveData.observeForever(this)
    }

    //<editor-fold desc="Actions">

    override fun onChanged(data: List<Dto<ProspectDto>>?) {
        if (data != null) {
            MessageHelper.show(context, "${data.count()}")
        }
        prospectCollectionLiveData.removeObserver(this)
    }

    //</editor-fold>


}