package com.jacr.pruebatecnica.presentation.ui.prospects

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jacr.pruebatecnica.R
import com.jacr.pruebatecnica.presentation.ui.base.BaseActivity
import com.jacr.pruebatecnica.presentation.viewmodel.login.LoginViewModel
import com.jacr.pruebatecnica.presentation.viewmodel.prospects.ProspectViewModel
import com.jacr.pruebatecnica.presentation.viewmodel.prospects.ProspectViewModelProvider
import javax.inject.Inject

class ProspectsActivity : BaseActivity<ActivityProspectsBinding, ProspectViewModel> {

    @Inject
    lateinit var provider: ProspectViewModelProvider

    override fun getActivity(): AppCompatActivity = this
    override fun getViewModelProvider(): ViewModelProvider.Factory = provider
    override fun getViewModelClass(): Class<out ProspectViewModel> = ProspectViewModel::class.java
    override fun getLayoutResource(): Int = R.layout.activity_prospects

    override fun onInit(binding: ActivityProspectsBinding, viewModel: ProspectViewModel) {
        binding.vm = viewModel
    }

}
