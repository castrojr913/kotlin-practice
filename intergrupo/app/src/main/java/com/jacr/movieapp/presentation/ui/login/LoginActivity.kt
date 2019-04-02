package com.jacr.movieapp.presentation.ui.login

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jacr.movieapp.R
import com.jacr.movieapp.databinding.ActivityLoginBinding
import com.jacr.movieapp.presentation.ui.base.BaseActivity
import com.jacr.movieapp.presentation.viewmodel.login.LoginViewModel
import com.jacr.movieapp.presentation.viewmodel.login.LoginViewModelProvider
import javax.inject.Inject

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    @Inject
    lateinit var provider: LoginViewModelProvider

    override fun getActivity(): AppCompatActivity = this
    override fun getViewModelProvider(): ViewModelProvider.Factory = provider
    override fun getViewModelClass(): Class<out LoginViewModel> = LoginViewModel::class.java
    override fun getLayoutResource(): Int = R.layout.activity_login

    override fun onInit(binding: ActivityLoginBinding, viewModel: LoginViewModel) {
        binding.vm = viewModel
    }


}
