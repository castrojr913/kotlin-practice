package com.jacr.pruebatecnica.model.repository.session

import com.jacr.pruebatecnica.model.repository.entities.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
interface SessionApiEndpoint {

    @GET("/application/login")
    fun getSession(@Query("email") email: String, @Query("password") password: String): Observable<UserResponse>

}