package com.jacr.pruebatecnica.model.data.mapper

import com.jacr.pruebatecnica.model.data.dtos.Dto
import com.jacr.pruebatecnica.model.data.dtos.response.UserDto
import com.jacr.pruebatecnica.model.data.entities.Entity
import com.jacr.pruebatecnica.model.data.entities.UserEntity

/**
 * Created: 4/7/19.
 * Author: jesus.castro
 */
class UserMapper : ModelMapper<Entity<UserEntity>, Dto<UserDto>>() {

    override fun fromEntity(entity: Entity<UserEntity>?): Dto<UserDto> {
        return if (entity?.isSuccess()!!) {
            val ent = entity.data!!
            Dto.fromData(UserDto(token = ent.token))
        } else Dto.fromException(entity.error!!)
    }

}