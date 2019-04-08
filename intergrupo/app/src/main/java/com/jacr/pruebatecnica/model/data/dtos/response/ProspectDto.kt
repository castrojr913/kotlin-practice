package com.jacr.pruebatecnica.model.data.dtos.response

/**
 * Created: 4/7/19.
 * Author: jesus.castro
 */
data class ProspectDto (
    var name: String? = "",
    var lastname: String? = "",
    var idNumber: String? = "",
    var phone: String? = ""
){

    fun getFullName() = "$name $lastname"

}
