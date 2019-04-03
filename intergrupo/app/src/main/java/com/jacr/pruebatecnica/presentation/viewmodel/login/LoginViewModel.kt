package com.jacr.pruebatecnica.presentation.viewmodel.login

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.jacr.pruebatecnica.R
import com.jacr.pruebatecnica.model.domain.dtos.UserDto
import com.jacr.pruebatecnica.model.domain.session.ISessionDomain
import com.jacr.pruebatecnica.presentation.utilities.ValidationHelper
import javax.inject.Inject


/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
class LoginViewModel @Inject constructor(
    private val domain: ISessionDomain,
    private val context: Context
) : ViewModel() {

    private val emailErrorId = R.string.error_format_invalid
    private val emptyErrorId = R.string.error_empty

    //<editor-fold desc="Properties">

    var email: ObservableField<String> = ObservableField()
    var password: ObservableField<String> = ObservableField()
    var remmemberMe: ObservableField<Boolean> = ObservableField()
    // ----
    var errorEmailVisible: ObservableField<Boolean> = ObservableField()
    var errorEmailText: ObservableField<String> = ObservableField()
    var errorPasswordVisible: ObservableField<Boolean> = ObservableField()
    var errorPasswordText: ObservableField<String> = ObservableField()

    //</editor-fold>

    //<editor-fold desc="Actions">

    fun onEmailTextChangeCommand(text: CharSequence): Boolean {
        if (ValidationHelper.checkEmail(text.toString())) {
            errorEmailVisible.set(false)
            errorEmailText.set(null)
        } else {
            errorEmailVisible.set(true)
            errorEmailText.set(context.getString(emailErrorId))
        }
        return errorEmailVisible.get()!!
    }

    fun onPasswordTextChangeCommand(text: CharSequence): Boolean {
        if (text.isEmpty()) {
            errorPasswordVisible.set(true)
            errorPasswordText.set(context.getString(emptyErrorId))
        } else {
            errorPasswordVisible.set(false)
            errorPasswordText.set(null)
        }
        return errorPasswordVisible.get()!!
    }

    @SuppressLint("CheckResult")
    fun onLoginCommand() {
        val user = email.get().orEmpty()
        val password = password.get().orEmpty()
        if (!onEmailTextChangeCommand(user) &&
            !onPasswordTextChangeCommand(password)
        ) {
            val rq = domain.signIn(user = UserDto(user, password))
            rq.subscribe(
                { rs -> Log.d("LoginViewModel", "Login Exitoso -> ${rs.token}") },
                { error -> Log.e("LoginViewModel", error.message) }
            )
        }
    }

    //</editor-fold>


}