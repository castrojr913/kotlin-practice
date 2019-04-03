package com.jacr.pruebatecnica.model.domain.session

import com.jacr.pruebatecnica.model.base.IPrefStorage
import com.jacr.pruebatecnica.model.repository.entities.UserResponse
import io.reactivex.Observable
import khangtran.preferenceshelper.PrefHelper

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
class SessionUserCache : IPrefStorage<UserResponse> {

    companion object {
        private val TAG = SessionUserCache::javaClass
    }

    override fun remove(key: String)
        = PrefHelper.removeKey("$TAG")

    override fun save(dto: UserResponse)
        = PrefHelper.setVal("$TAG", dto)

    override fun get(): Observable<UserResponse> {
        return Observable.fromArray(PrefHelper.getObjectVal("$TAG", UserResponse::class.java))
    }

}