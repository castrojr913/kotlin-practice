package com.jacr.pruebatecnica.model.data.entities

import com.google.gson.annotations.SerializedName

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
data class UserEntity(

    var success: Boolean? = false,

    @SerializedName(value = "authToken")
    var token: String? = "",

    var email: String? = ""

)