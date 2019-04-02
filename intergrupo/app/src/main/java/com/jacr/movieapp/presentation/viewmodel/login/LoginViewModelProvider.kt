package com.jacr.movieapp.presentation.viewmodel.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jacr.movieapp.model.domain.session.ISessionDomain
import javax.inject.Inject

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
@Suppress("UNCHECKED_CAST")
class LoginViewModelProvider @Inject constructor(
    private val domain: ISessionDomain,
    private val context: Context
) : ViewModelProvider.NewInstanceFactory(), ILoginProvider {

    override fun <T : ViewModel?> create(modelClass: Class<T>) = LoginViewModel(domain, context) as T

}