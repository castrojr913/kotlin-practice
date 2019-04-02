package com.jacr.movieapp.model.repository.entities

import com.google.gson.annotations.SerializedName

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
data class UserResponse(

    val success: Boolean,

    @SerializedName(value = "authToken")
    val token: String,

    val email: String

)