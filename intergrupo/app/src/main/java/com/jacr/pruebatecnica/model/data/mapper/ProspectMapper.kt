package com.jacr.pruebatecnica.model.data.mapper

import com.jacr.pruebatecnica.model.data.dtos.Dto
import com.jacr.pruebatecnica.model.data.dtos.response.ProspectDto
import com.jacr.pruebatecnica.model.data.entities.Entity
import com.jacr.pruebatecnica.model.data.entities.ProspectEntity

/**
 * Created: 4/7/19.
 * Author: jesus.castro
 */
class ProspectMapper : ModelMapper<Entity<ProspectEntity>, Dto<ProspectDto>>() {

    override fun fromEntity(entity: Entity<ProspectEntity>?): Dto<ProspectDto> {
        return if (entity?.isSuccess()!!) {
            val ent = entity.data!!
            Dto.fromData(
                ProspectDto(
                    name = ent.name, lastname = ent.surname, idNumber = ent.schProspectIdentification,
                    phone = ent.telephone
                )
            )
        } else Dto.fromException(entity.error!!)
    }
}