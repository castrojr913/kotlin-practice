package com.jacr.pruebatecnica.model.domain.session

import com.jacr.pruebatecnica.model.base.IPrefStorage
import com.jacr.pruebatecnica.model.data.dtos.response.UserDto
import khangtran.preferenceshelper.PrefHelper

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
class SessionUserStorage : IPrefStorage<UserDto> {

    companion object {
        private val TAG = SessionUserStorage::javaClass
    }

    override fun remove(key: String) = PrefHelper.removeKey("$TAG")

    override fun save(dto: UserDto?) = PrefHelper.setVal("$TAG", dto)

    override fun get(): UserDto = PrefHelper.getObjectVal("$TAG", UserDto::class.java)

}