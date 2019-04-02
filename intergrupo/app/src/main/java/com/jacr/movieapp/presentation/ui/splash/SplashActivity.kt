package com.jacr.movieapp.presentation.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.jacr.movieapp.AppSettings
import com.jacr.movieapp.R
import com.jacr.movieapp.presentation.ui.login.LoginActivity
import com.jacr.movieapp.presentation.utilities.NavigationHelper

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
