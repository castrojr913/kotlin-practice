package com.jacr.pruebatecnica.presentation.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.jacr.pruebatecnica.AppSettings
import com.jacr.pruebatecnica.R
import com.jacr.pruebatecnica.presentation.ui.login.LoginActivity
import com.jacr.pruebatecnica.presentation.utilities.NavigationHelper

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
    }

    override fun onStart() {
        super.onStart()
        Handler(Looper.myLooper()).postDelayed({
            NavigationHelper.redirectTo(this, LoginActivity::class.java, true)
        }, AppSettings.SplashTimeout)
    }

}
