package com.jacr.pruebatecnica.model.utilities

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.google.gson.GsonBuilder
import com.jacr.pruebatecnica.model.repository.base.*
import com.jacr.pruebatecnica.model.repository.base.ApiStatus.DONE
import com.jacr.pruebatecnica.model.repository.base.ApiStatus.START
import com.jacr.pruebatecnica.presentation.utilities.LogHelper
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier

/**
 * Created: 3/4/19.
 * Author: jesus.castro
 */
object ApiHelper {

    private val TAG: Class<*> = ApiHelper::class.java
    private val client: Retrofit = buildClient()

    //<editor-fold desc="HTTP Client">

    fun <T> getClient(daoClass: Class<out T>): T = client.create(daoClass)

    private fun buildClient(): Retrofit {
        // Avoid bug java.lang.securityException
        // https://stackoverflow.com/questions/32431279/android-m-retrofit-json-cant-make-field-constructor-accessible
        val builder = GsonBuilder()
        builder.excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
        return Retrofit.Builder()
            .baseUrl(ApiSettings.BASE_API)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(builder.create()))
            .build()
    }

    //</editor-fold>

    //<editor-fold desc="Response Handler">

    // fun jsonToString(t: Any): String = jsonParser.toJson(t)

    fun <T, X> switchMapForApiResponse(
        liveData: LiveData<ApiResponse<T>>,
        doOnSuccess: (((T?) -> X?)?) = null,
        doOnError: (((ApiErrorResponse<*>) -> Unit)?) = null,
        doOnSubscribe: (() -> Unit)? = null,
        doOnComplete: (() -> Unit)? = null
    ): LiveData<X?>? = Transformations.map(liveData) {
        when (it) {
            is ApiSuccessResponse -> {
                val responseBody = it.data
                LogHelper.d(TAG, responseBody.toString())
                doOnSuccess?.invoke(responseBody)
            }
            is ApiErrorResponse<*> -> {
                LogHelper.e(TAG, Exception(it.error.toString()))
                doOnError?.invoke(it)
                null
            }
            is ApiStatusResponse -> {
                when (it.code) {
                    START -> doOnSubscribe?.invoke()
                    DONE -> doOnComplete?.invoke()
                    else -> doOnComplete?.invoke()
                }
                null
            }
            else -> null
        }
    }

    //</editor-fold>

}