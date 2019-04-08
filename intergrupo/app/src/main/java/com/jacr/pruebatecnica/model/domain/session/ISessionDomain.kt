package com.jacr.pruebatecnica.model.domain.session

import androidx.lifecycle.LiveData
import com.jacr.pruebatecnica.model.data.dtos.Dto
import com.jacr.pruebatecnica.model.data.dtos.request.UserRequestDto
import com.jacr.pruebatecnica.model.data.dtos.response.UserDto

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
interface ISessionDomain {

    fun getLastAuthInfo(): LiveData<Dto<UserDto>>

    fun signIn(user: UserRequestDto): LiveData<Dto<UserDto>>

}