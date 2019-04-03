package com.jacr.pruebatecnica.model.repository.session

import com.jacr.pruebatecnica.model.domain.dtos.UserDto
import com.jacr.pruebatecnica.model.repository.entities.UserResponse
import io.reactivex.Observable

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
interface ISessionRepository {

    fun signIn(user: UserDto) : Observable<UserResponse>

}