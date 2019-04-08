package com.jacr.pruebatecnica.model.data.entities

/**
 * Created: 4/7/19.
 * Author: jesus.castro
 */
data class ProspectEntity(
    val id: String? = "",
    val name: String? = "",
    val surname: String? = "",
    val telephone: String? = "",
    val schProspectIdentification: String? = "",
    val address: String? = "",
    val createdAt: String? = "",
    val updatedAt: String? = "",
    val statusCD: Long? = 0,
    val zoneCode: String? = "",
    val neighborhoodCode: String? = "",
    val cityCode: String? = "",
    val sectionCode: String? = "",
    val roleID: Long? = 0,
    val appointableID: Any? = null,
    val rejectedObservation: Any? = null,
    val observation: String? = "",
    val disable: Boolean? = false,
    val visited: Boolean? = false,
    val callcenter: Boolean? = false,
    val acceptSearch: Boolean? = false,
    val campaignCode: String? = "",
    val userID: Any? = null
)