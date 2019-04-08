package com.jacr.pruebatecnica.model.data.dtos.response

import com.jacr.pruebatecnica.model.base.ApiError

/**
 * Created: 4/7/19.
 * Author: jesus.castro
 */
data class ErrorDto(
    val description: String = "",
    val code: ApiError = ApiError.FAILURE_UNHANDLED
)