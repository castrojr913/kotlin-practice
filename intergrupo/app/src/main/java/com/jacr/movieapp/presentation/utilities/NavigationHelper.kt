package com.jacr.movieapp.presentation.utilities

import android.app.Activity
import android.content.Intent

/**
 * Created: 2/28/19.
 * Author: jesus.castro
 */
object NavigationHelper {

    fun redirectTo(source: Activity, target: Class<out Any>, isFinished: Boolean = false) {
        source.startActivity(Intent(source, target))
        if (isFinished)
            source.finish()
    }

}