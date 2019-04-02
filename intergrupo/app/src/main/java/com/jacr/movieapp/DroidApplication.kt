package com.jacr.movieapp

import android.app.Application
import com.jacr.movieapp.settings.InjectionModule
import toothpick.Toothpick
import toothpick.configuration.Configuration.forDevelopment
import toothpick.configuration.Configuration.forProduction
import toothpick.smoothie.module.SmoothieApplicationModule


/**
 * Created: 2/28/19.
 * Author: jesus.castro
 */
class DroidApplication : Application() {

    companion object {
        lateinit var instance: DroidApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        // Resolve dependencies
        if (BuildConfig.DEBUG) forDevelopment() else forProduction()
        val appScope = Toothpick.openScope(this)
        appScope.installModules(SmoothieApplicationModule(this), InjectionModule())
    }

}