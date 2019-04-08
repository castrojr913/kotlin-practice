package com.jacr.pruebatecnica.model.repository.session

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jacr.pruebatecnica.model.data.dtos.request.UserRequestDto
import com.jacr.pruebatecnica.model.data.entities.Entity
import com.jacr.pruebatecnica.model.data.entities.UserEntity
import com.jacr.pruebatecnica.model.utilities.ApiHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
@SuppressLint("CheckResult")
class SessionApiRepository @Inject constructor() : ISessionRepository {

    companion object {
        var TAG: Class<Any> = SessionApiRepository.javaClass
    }

    private var api: SessionApiEndpoint = ApiHelper.getClient(SessionApiEndpoint::class.java)

    override fun signIn(user: UserRequestDto): LiveData<Entity<UserEntity>> {
        val rs = MutableLiveData<Entity<UserEntity>>()
        api.getSession(user.email, user.password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { rs.value = Entity.fromException(TAG, it); }
            .subscribe { rs.value = Entity.fromData(it) }
        return rs
    }

}