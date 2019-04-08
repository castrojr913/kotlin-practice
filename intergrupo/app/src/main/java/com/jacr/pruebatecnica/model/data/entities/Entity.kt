package com.jacr.pruebatecnica.model.data.entities

import com.google.gson.GsonBuilder
import com.jacr.pruebatecnica.presentation.utilities.LogHelper
import retrofit2.HttpException

/**
 * Created: 4/6/19.
 * Author: jesus.castro
 */
open class Entity<T>(val data: T? = null, val error: ErrorEntity? = null) {

    // Ref
    // https://medium.com/@stustirling/responses-errors-with-retrofit-2-rxjava2-6d55eafecf5a

    companion object {
        fun <T> fromData(data: T): Entity<T> {
            return Entity(data, null)
        }

        fun <T> fromException(source: Class<Any>, error: Throwable): Entity<T> {
            LogHelper.e(source, error)
            var err = ErrorEntity()
            if (error is HttpException) {
                val body = error.response().errorBody()
                val parser = GsonBuilder().create()
                try {
                    err = parser.fromJson(body?.string(), ErrorEntity::class.java)
                } catch (e: Exception) {
                }
            }
            err.exception = error
            return Entity(null, err)
        }

    }

    fun isSuccess(): Boolean = data != null
}