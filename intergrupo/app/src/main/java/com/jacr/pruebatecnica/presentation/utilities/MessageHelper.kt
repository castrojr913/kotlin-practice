package com.jacr.pruebatecnica.presentation.utilities

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast

/**
 * Created: 4/5/19.
 * Author: jesus.castro
 */
object MessageHelper {

    @SuppressLint("ShowToast")
    fun show(ctx: Context, msg: String) = Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show()

}


