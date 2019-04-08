package com.jacr.pruebatecnica.presentation.utilities

import android.util.Log


/**
 * Created: 3/3/19.
 * Author: jesus.castro
 */
object LogHelper {

    //<editor-fold desc="Log">

    fun d(sourceClass: Class<*>, message: String) = Log.d(sourceClass.simpleName.toUpperCase(), message)

    fun e(sourceClass: Class<*>, e: Throwable?) = Log.e(sourceClass.simpleName.toUpperCase(), e.toString())

    //</editor-fold>

    //<editor-fold desc="Http">

    fun httpRequest(source: Class<*>, type: String, url: String, headers: Any?, params: Any?) {
        d(
            source,
            "______________________________\n $type -> $url \n - HEADERS: ${headers?.toString()
                ?: ""} \n - PARAMS: ${params?.toString() ?: ""}"
        )
    }

    //</editor-fold>

}