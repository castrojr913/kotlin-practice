package com.jacr.pruebatecnica.model.repository.entities

import com.google.gson.annotations.SerializedName

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
data class ApiError (

    val code: Long = 0,

    @SerializedName(value = "error")
    val description: String = "",

    val exception: Throwable = Exception()

)