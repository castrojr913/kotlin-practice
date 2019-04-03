package com.jacr.pruebatecnica.model.repository.session

import androidx.lifecycle.LiveData
import com.jacr.pruebatecnica.model.domain.dtos.UserDto
import com.jacr.pruebatecnica.model.repository.base.ApiResponse
import com.jacr.pruebatecnica.model.repository.entities.UserResponse

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
interface ISessionRepository {

    fun signIn(user: UserDto) : LiveData<ApiResponse<UserResponse>>

}