package com.jacr.movieapp.presentation.utilities

import java.util.regex.Pattern

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
object ValidationHelper {

    fun checkEmail(email: String): Boolean {
        val emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        val matcher = Pattern.compile(emailRegex).matcher(email)
        return matcher.matches()
    }

}