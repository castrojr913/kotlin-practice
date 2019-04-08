package com.jacr.pruebatecnica.model.data.dtos.response

import com.jacr.pruebatecnica.model.data.dtos.request.UserRequestDto

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */

data class UserDto(
    var token: String? = "",
    var user: UserRequestDto? = null
)