package com.jacr.pruebatecnica.model.domain.prospect

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.jacr.pruebatecnica.model.base.IPrefStorage
import com.jacr.pruebatecnica.model.data.dtos.Dto
import com.jacr.pruebatecnica.model.data.dtos.response.ProspectDto
import com.jacr.pruebatecnica.model.data.dtos.response.UserDto
import com.jacr.pruebatecnica.model.data.entities.Entity
import com.jacr.pruebatecnica.model.data.entities.ProspectEntity
import com.jacr.pruebatecnica.model.data.mapper.ModelMapper
import com.jacr.pruebatecnica.model.repository.prospect.ProspectRepository
import javax.inject.Inject

/**
 * Created: 4/7/19.
 * Author: jesus.castro
 */
class ProspectDefaultDomain @Inject constructor(
    private val modelMapper: ModelMapper<Entity<ProspectEntity>, Dto<ProspectDto>>,
    private val userStorage: IPrefStorage<UserDto>,
    private val apiRepository: ProspectRepository
) : ProspectDomain {

    private var token: String = userStorage.get().token!!

    override fun getProspects(): LiveData<List<Dto<ProspectDto>>> {
        val repositoryLiveData = apiRepository.getProspects(token)
        return Transformations.switchMap(repositoryLiveData) {
            val dtos = ArrayList<Dto<ProspectDto>>()
            it.forEach { i -> dtos.add(modelMapper.fromEntity(i)) }
            MutableLiveData<List<Dto<ProspectDto>>>(dtos)
        }
    }

}