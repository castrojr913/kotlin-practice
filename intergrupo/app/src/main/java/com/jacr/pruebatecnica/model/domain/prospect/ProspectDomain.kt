package com.jacr.pruebatecnica.model.domain.prospect

import androidx.lifecycle.LiveData
import com.jacr.pruebatecnica.model.data.dtos.Dto
import com.jacr.pruebatecnica.model.data.dtos.response.ProspectDto

/**
 * Created: 4/7/19.
 * Author: jesus.castro
 */
interface ProspectDomain {

    fun getProspects(): LiveData<List<Dto<ProspectDto>>>

}