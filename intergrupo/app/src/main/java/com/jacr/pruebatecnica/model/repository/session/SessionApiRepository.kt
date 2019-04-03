package com.jacr.pruebatecnica.model.repository.session

import android.annotation.SuppressLint
import com.jacr.pruebatecnica.model.domain.dtos.UserDto
import com.jacr.pruebatecnica.model.repository.entities.UserResponse
import com.jacr.pruebatecnica.model.utilities.ApiHelper
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
@SuppressLint("CheckResult")
class SessionApiRepository @Inject constructor() : ISessionRepository {

    private var api: SessionApiEndpoint = ApiHelper.getClient(SessionApiEndpoint::class.java)

    override fun signIn(user: UserDto) : Observable<UserResponse> {
        return api.getSession(user.email, user.password).
            subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}