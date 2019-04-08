package com.jacr.pruebatecnica.model.repository.prospect

import com.jacr.pruebatecnica.model.data.entities.ProspectEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * Created: 4/8/19.
 * Author: jesus.castro
 */
interface ProspectApiEndpoint {

    @GET("/sch/prospects.json")
    fun getProspects(@Header("token") token: String): Observable<List<ProspectEntity>>

}