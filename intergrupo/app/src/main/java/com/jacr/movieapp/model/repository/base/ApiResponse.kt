package com.jacr.movieapp.model.repository.base

import com.google.gson.Gson
import com.jacr.movieapp.model.repository.base.ApiStatus.*
import com.jacr.movieapp.model.repository.entities.ApiError
import retrofit2.Response

/**
 * Created: 3/3/19.
 * Author: jesus.castro
 */
data class ApiStatusResponse<T>(val code: ApiStatus) : ApiResponse<T>()
data class ApiSuccessResponse<T>(val code: ApiStatus, val data: T) : ApiResponse<T>()
data class ApiErrorResponse<T>(val code: ApiStatus, val error: ApiError) : ApiResponse<T>()

@Suppress("UNCHECKED_CAST")
sealed class ApiResponse<T> {

    companion object {

        fun <T> create(response: Response<T>): ApiResponse<T> = if (response.isSuccessful) {
            val body = response.body() as T
            ApiSuccessResponse(OK, body)
        } else {
            val parser = Gson()
            val error = parser.fromJson(response.errorBody()?.string(), ApiError::class.java)
            ApiErrorResponse(FAILURE_API, error)
        }

    }

}