package com.jacr.pruebatecnica.model.repository.session

import androidx.lifecycle.LiveData
import com.jacr.pruebatecnica.model.data.dtos.request.UserRequestDto
import com.jacr.pruebatecnica.model.data.entities.Entity
import com.jacr.pruebatecnica.model.data.entities.UserEntity

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
interface ISessionRepository {

    fun signIn(user: UserRequestDto): LiveData<Entity<UserEntity>>

}