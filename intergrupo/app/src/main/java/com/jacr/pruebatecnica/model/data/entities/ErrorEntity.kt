package com.jacr.pruebatecnica.model.data.entities

import com.google.gson.annotations.SerializedName

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
data class ErrorEntity (

    val code: Long = 0,

    @SerializedName(value = "error")
    val description: String = "",

    var exception: Throwable? = null

)