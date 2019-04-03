package com.jacr.pruebatecnica.model.repository.base

/**
 * Created: 3/3/19.
 * Author: jesus.castro
 */
enum class ApiStatus {
    OK,
    START,
    DONE,
    FAILURE_NETWORK,
    FAILURE_API,
    FAILURE_UNHANDLED
}