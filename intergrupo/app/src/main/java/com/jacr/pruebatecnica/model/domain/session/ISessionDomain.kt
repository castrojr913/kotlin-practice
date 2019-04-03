package com.jacr.pruebatecnica.model.domain.session

import androidx.lifecycle.LiveData
import com.jacr.pruebatecnica.model.domain.dtos.UserDto
import com.jacr.pruebatecnica.model.repository.base.ApiResponse
import com.jacr.pruebatecnica.model.repository.entities.UserResponse

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
interface ISessionDomain {

    fun getLastSessionUser() : LiveData<UserResponse>

    fun signIn(user: UserDto) : LiveData<ApiResponse<UserResponse>>

}