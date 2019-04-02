package com.jacr.movieapp.model.repository.base

import androidx.lifecycle.LiveData
import com.jacr.movieapp.model.repository.base.ApiStatus.*
import com.jacr.movieapp.model.repository.entities.ApiError
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.net.ConnectException
import java.net.SocketTimeoutException

/**
 * A Retrofit adapter that converts the Call into a LiveData of ApiResponse.
 * @param <R>
</R> */
class LiveDataCallAdapter<R>(private val responseType: Type) : CallAdapter<R, LiveData<ApiResponse<R>>> {

    override fun responseType() = responseType

    override fun adapt(call: Call<R>): LiveData<ApiResponse<R>> {
        return object : LiveData<ApiResponse<R>>() {

            override fun onActive() {
                super.onActive()
                call.enqueue(object : Callback<R> {

                    override fun onResponse(call: Call<R>, response: Response<R>) {
                        postValue(ApiResponse.create(response))
                        onComplete()
                    }

                    override fun onFailure(call: Call<R>, throwable: Throwable) {
                        postValue(
                            ApiErrorResponse(
                                when (throwable) {
                                    is ConnectException -> FAILURE_NETWORK
                                    is SocketTimeoutException -> FAILURE_NETWORK
                                    else -> FAILURE_UNHANDLED
                                }, ApiError(exception = throwable)
                            )
                        )
                        onComplete()
                    }

                    private fun onComplete() = postValue(ApiStatusResponse(DONE))

                })
            }

        }
    }
}