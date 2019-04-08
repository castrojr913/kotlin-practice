package com.jacr.pruebatecnica.model.utilities

import com.google.gson.GsonBuilder
import com.jacr.pruebatecnica.model.base.ApiSettings
import com.jacr.pruebatecnica.presentation.utilities.LogHelper
import io.reactivex.plugins.RxJavaPlugins
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor



/**
 * Created: 3/4/19.
 * Author: jesus.castro
 */
object ApiHelper {

    private val TAG: Class<*> = ApiHelper::class.java
    private val client: Retrofit = buildClient()

    init {
        // This workaround fix bug https://github.com/ReactiveX/RxJava/issues/4807 too
        RxJavaPlugins.setErrorHandler {
            LogHelper.e(TAG, it)
        }
    }

    //<editor-fold desc="HTTP Client">

    fun <T> getClient(daoClass: Class<out T>): T = client.create(daoClass)

    private fun buildClient(): Retrofit {
        // Avoid bug java.lang.securityException
        // https://stackoverflow.com/questions/32431279/android-m-retrofit-json-cant-make-field-constructor-accessible
        val interceptor = HttpLoggingInterceptor()
        val builder = GsonBuilder()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
        return Retrofit.Builder()
            .baseUrl(ApiSettings.BASE_API)
            .client(OkHttpClient.Builder().addInterceptor(interceptor).build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(builder.create()))
            .build()
    }

    // fun jsonToString(t: Any): String = jsonParser.toJson(t)

    //</editor-fold>


}