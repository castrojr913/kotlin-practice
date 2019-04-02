package com.jacr.movieapp.presentation.viewmodel.login

import android.content.Context
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.jacr.movieapp.R
import com.jacr.movieapp.model.domain.dtos.UserDto
import com.jacr.movieapp.model.domain.session.ISessionDomain
import com.jacr.movieapp.model.utilities.ApiHelper.switchMapForApiResponse
import com.jacr.movieapp.presentation.utilities.ValidationHelper
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

    fun onLoginCommand() {
        val user = email.get().orEmpty()
        val password = password.get().orEmpty()
        if (!onEmailTextChangeCommand(user) &&
            !onPasswordTextChangeCommand(password)
        ) {
            switchMapForApiResponse(domain.signIn(user = UserDto(email = user, password = password)),
                doOnSuccess = {
                    Log.d("LOGIN", "Is_Correct!!!")
                    return@switchMapForApiResponse it
                }, doOnSubscribe = {
                    Log.d("LOGIN", "Iniciando Peticion")
                }, doOnError = {
                    Log.e("LOGIN", "Error")
                }, doOnComplete = {
                    Log.d("LOGIN", "Accion Completada")
                })
        }
    }

    //</editor-fold>


}