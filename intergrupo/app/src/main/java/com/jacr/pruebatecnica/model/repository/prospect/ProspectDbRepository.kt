package com.jacr.pruebatecnica.model.repository.prospect

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jacr.pruebatecnica.model.data.entities.Entity
import com.jacr.pruebatecnica.model.data.entities.ProspectEntity
import javax.inject.Inject

/**
 * Created: 4/8/19.
 * Author: jesus.castro
 */
class ProspectDbRepository @Inject constructor() : ProspectRepository {

    override fun getProspects(token: String): LiveData<Entity<ProspectEntity>> {
        return MutableLiveData()
    }

}