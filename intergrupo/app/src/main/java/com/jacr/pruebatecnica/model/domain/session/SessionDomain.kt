package com.jacr.pruebatecnica.model.domain.session

import android.annotation.SuppressLint
import com.jacr.pruebatecnica.model.base.IPrefStorage
import com.jacr.pruebatecnica.model.domain.dtos.UserDto
import com.jacr.pruebatecnica.model.repository.entities.UserResponse
import com.jacr.pruebatecnica.model.repository.session.ISessionRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
@SuppressLint("CheckResult")
class SessionDomain @Inject constructor(
    private val userCache: IPrefStorage<UserResponse>,
    private val apiRepository: ISessionRepository
) : ISessionDomain {


    override fun signIn(user: UserDto): Observable<UserResponse> {
        val rs = apiRepository.signIn(user)
        rs.subscribe { response -> userCache.save(response) }
        return rs
    }

    override fun getLastSessionUser(): Observable<UserResponse> {
        return userCache.get()
    }

}