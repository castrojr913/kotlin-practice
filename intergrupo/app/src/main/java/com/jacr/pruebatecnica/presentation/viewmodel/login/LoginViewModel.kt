package com.jacr.pruebatecnica.presentation.viewmodel.login

import android.annotation.SuppressLint
import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.jacr.pruebatecnica.R
import com.jacr.pruebatecnica.model.data.dtos.Dto
import com.jacr.pruebatecnica.model.data.dtos.request.UserRequestDto
import com.jacr.pruebatecnica.model.data.dtos.response.UserDto
import com.jacr.pruebatecnica.model.domain.session.ISessionDomain
import com.jacr.pruebatecnica.presentation.utilities.MessageHelper
import com.jacr.pruebatecnica.presentation.utilities.ValidationHelper
import com.jacr.pruebatecnica.presentation.viewmodel.navigation.Navigation
import com.jacr.pruebatecnica.presentation.viewmodel.navigation.NavigationView
import com.jacr.pruebatecnica.presentation.viewmodel.navigation.NavigationView.*
import javax.inject.Inject


/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
class LoginViewModel @Inject constructor(
    private val domain: ISessionDomain,
    private val context: Context,
    private val navigation: Navigation
) : ViewModel(), Observer<Dto<UserDto>> {

    //<editor-fold desc="Variables">

    private val emailErrorId = R.string.error_format_invalid
    private val emptyErrorId = R.string.error_empty
    private var sessionLiveData: LiveData<Dto<UserDto>> = MutableLiveData()
    private var isRememberChecked = false

    //</editor-fold>

    //<editor-fold desc="Observable Properties">

    var email: ObservableField<String> = ObservableField()
    var password: ObservableField<String> = ObservableField()
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
        if (sessionLiveData.hasActiveObservers()
            || onEmailTextChangeCommand(user) || onPasswordTextChangeCommand(password)
        ) return
        sessionLiveData = domain.signIn(UserRequestDto(user, password))
        sessionLiveData.observeForever(this)
    }

    fun onRememberCommand(isChecked: Boolean) {
        if (!isChecked) return
        isRememberChecked = true
        sessionLiveData = domain.getLastAuthInfo()
        sessionLiveData.observeForever(this)
    }

    override fun onChanged(dto: Dto<UserDto>?) {
        if (dto != null) {
            when {
                isRememberChecked -> {
                    email.set(dto.data?.user?.email)
                    password.set(dto.data?.user?.password)
                }
                else -> when {
                    dto.isSuccess() -> navigation.redirectTo(PROSPECTS)
                    else -> MessageHelper.show(context, dto.error!!.description)
                }
            }
        }
        isRememberChecked = false
        sessionLiveData.removeObserver(this)
    }

    //</editor-fold>


}