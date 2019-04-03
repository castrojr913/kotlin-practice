package com.jacr.pruebatecnica.model.domain.session

import androidx.lifecycle.LiveData
import com.jacr.pruebatecnica.model.base.IPrefStorage
import com.jacr.pruebatecnica.model.domain.dtos.UserDto
import com.jacr.pruebatecnica.model.repository.base.ApiResponse
import com.jacr.pruebatecnica.model.repository.entities.UserResponse
import com.jacr.pruebatecnica.model.repository.session.ISessionRepository
import com.jacr.pruebatecnica.model.utilities.ApiHelper
import javax.inject.Inject

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
class SessionDomain @Inject constructor(
    private val userCache: IPrefStorage<UserResponse>,
    private val apiRepository: ISessionRepository
) : ISessionDomain {

    override fun signIn(user: UserDto): LiveData<ApiResponse<UserResponse>> {
        val rs = apiRepository.signIn(user)
        ApiHelper.switchMapForApiResponse(rs, {
            if (it is UserResponse) {
                userCache.save(it)
            }
        })
        return rs
    }

    override fun getLastSessionUser(): LiveData<UserResponse> {
        return userCache.get()
    }

}