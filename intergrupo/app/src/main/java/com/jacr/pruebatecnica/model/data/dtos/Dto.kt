package com.jacr.pruebatecnica.model.data.dtos

import android.accounts.NetworkErrorException
import com.jacr.pruebatecnica.model.base.ApiError
import com.jacr.pruebatecnica.model.data.dtos.response.ErrorDto
import com.jacr.pruebatecnica.model.data.entities.ErrorEntity
import retrofit2.HttpException
import java.net.SocketTimeoutException

/**
 * Created: 4/7/19.
 * Author: jesus.castro
 */
open class Dto<T>(val data: T? = null, val error: ErrorDto? = ErrorDto()) {

    companion object {
        fun <T> fromData(data: T): Dto<T> {
            return Dto(data, null)
        }

        fun <T> fromException(error: ErrorEntity): Dto<T> {
            val err = ErrorDto(description = error.description, code = getErrorCode(error.exception))
            return Dto(null, err)
        }

        private fun getErrorCode(error: Throwable?): ApiError {
            return when (error) {
                is SocketTimeoutException -> ApiError.FAILURE_NETWORK
                is NetworkErrorException -> ApiError.FAILURE_NETWORK
                is HttpException -> ApiError.FAILURE_API
                else -> ApiError.FAILURE_UNHANDLED
            }
        }
    }

    fun isSuccess(): Boolean = data != null
}