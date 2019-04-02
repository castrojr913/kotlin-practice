package com.jacr.movieapp.settings

import android.content.Context
import com.jacr.movieapp.DroidApplication
import com.jacr.movieapp.model.base.IPrefStorage
import com.jacr.movieapp.model.domain.session.ISessionDomain
import com.jacr.movieapp.model.domain.session.SessionDomain
import com.jacr.movieapp.model.domain.session.SessionUserCache
import com.jacr.movieapp.model.repository.session.ISessionRepository
import com.jacr.movieapp.model.repository.session.SessionApiRepository
import com.jacr.movieapp.presentation.viewmodel.login.ILoginProvider
import com.jacr.movieapp.presentation.viewmodel.login.LoginViewModelProvider
import toothpick.config.Module

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
class InjectionModule : Module() {

    init {
        bind(Context::class.java).toInstance(DroidApplication.instance.applicationContext)
        // Login
        bind(IPrefStorage::class.java).toInstance(SessionUserCache())
        bind(ISessionRepository::class.java).to(SessionApiRepository::class.java)
        bind(ISessionDomain::class.java).to(SessionDomain::class.java)
        bind(ILoginProvider::class.java).to(LoginViewModelProvider::class.java)
    }

}