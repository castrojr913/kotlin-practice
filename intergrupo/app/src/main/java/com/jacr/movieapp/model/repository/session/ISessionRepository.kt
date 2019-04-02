package com.jacr.movieapp.model.repository.session

import androidx.lifecycle.LiveData
import com.jacr.movieapp.model.domain.dtos.UserDto
import com.jacr.movieapp.model.repository.base.ApiResponse
import com.jacr.movieapp.model.repository.entities.UserResponse

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
interface ISessionRepository {

    fun signIn(user: UserDto) : LiveData<ApiResponse<UserResponse>>

}