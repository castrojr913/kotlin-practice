package com.jacr.movieapp.model.domain.session

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jacr.movieapp.model.base.IPrefStorage
import com.jacr.movieapp.model.repository.entities.UserResponse
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

    override fun get(): LiveData<UserResponse> {
        return MutableLiveData<UserResponse>(
            PrefHelper.getObjectVal("$TAG", UserResponse::class.java)
        )
    }

}