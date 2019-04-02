package com.jacr.movieapp.model.repository.session

import androidx.lifecycle.LiveData
import com.jacr.movieapp.model.domain.dtos.UserDto
import com.jacr.movieapp.model.repository.base.ApiResponse
import com.jacr.movieapp.model.repository.entities.UserResponse
import com.jacr.movieapp.model.utilities.ApiHelper
import javax.inject.Inject

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
class SessionApiRepository @Inject constructor() : ISessionRepository {

    private var client: SessionApiEndpoint = ApiHelper.getClient(SessionApiEndpoint::class.java)

    override fun signIn(user: UserDto) : LiveData<ApiResponse<UserResponse>> {
        return client.getSession(user)
    }

}