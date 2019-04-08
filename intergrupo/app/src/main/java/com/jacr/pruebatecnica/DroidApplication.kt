package com.jacr.pruebatecnica

import android.app.Activity
import android.app.Application
import com.jacr.pruebatecnica.settings.InjectionModule
import khangtran.preferenceshelper.PrefHelper
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
        PrefHelper.initHelper(this)
        if (BuildConfig.DEBUG) forDevelopment() else forProduction()
        val appScope = Toothpick.openScope(this)
        appScope.installModules(SmoothieApplicationModule(this), InjectionModule())
    }

}