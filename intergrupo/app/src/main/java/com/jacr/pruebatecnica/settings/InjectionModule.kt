package com.jacr.pruebatecnica.settings

import android.content.Context
import com.jacr.pruebatecnica.DroidApplication
import com.jacr.pruebatecnica.model.base.IPrefStorage
import com.jacr.pruebatecnica.model.data.mapper.ModelMapper
import com.jacr.pruebatecnica.model.data.mapper.UserMapper
import com.jacr.pruebatecnica.model.domain.session.ISessionDomain
import com.jacr.pruebatecnica.model.domain.session.SessionDomain
import com.jacr.pruebatecnica.model.domain.session.SessionUserStorage
import com.jacr.pruebatecnica.model.repository.session.ISessionRepository
import com.jacr.pruebatecnica.model.repository.session.SessionApiRepository
import com.jacr.pruebatecnica.presentation.viewmodel.login.ILoginProvider
import com.jacr.pruebatecnica.presentation.viewmodel.login.LoginViewModelProvider
import toothpick.config.Module

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
class InjectionModule : Module() {

    init {
        bind(Context::class.java).toInstance(DroidApplication.instance.applicationContext)
        // Login
        bind(IPrefStorage::class.java).toInstance(SessionUserStorage())
        bind(ModelMapper::class.java).toInstance(UserMapper())
        bind(ISessionRepository::class.java).to(SessionApiRepository::class.java)
        bind(ISessionDomain::class.java).to(SessionDomain::class.java)
        bind(ILoginProvider::class.java).to(LoginViewModelProvider::class.java)
    }

}