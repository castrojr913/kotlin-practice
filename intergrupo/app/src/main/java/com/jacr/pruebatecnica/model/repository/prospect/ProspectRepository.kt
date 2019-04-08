package com.jacr.pruebatecnica.model.repository.prospect

import androidx.lifecycle.LiveData
import com.jacr.pruebatecnica.model.data.entities.Entity
import com.jacr.pruebatecnica.model.data.entities.ProspectEntity

/**
 * Created: 4/8/19.
 * Author: jesus.castro
 */
interface ProspectRepository {

    fun getProspects(token: String = ""): LiveData<List<Entity<ProspectEntity>>>

}