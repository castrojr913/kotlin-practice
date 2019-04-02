package com.jacr.movieapp.model.repository.session

import androidx.lifecycle.LiveData
import com.jacr.movieapp.model.domain.dtos.UserDto
import com.jacr.movieapp.model.repository.base.ApiResponse
import com.jacr.movieapp.model.repository.entities.UserResponse
import retrofit2.http.Body
import retrofit2.http.HTTP

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
interface SessionApiEndpoint {

    @HTTP(method = "GET", path = "/application/login", hasBody = true)
    fun getSession(@Body user: UserDto): LiveData<ApiResponse<UserResponse>>

}