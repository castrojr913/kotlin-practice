package com.jacr.pruebatecnica.model.base

import androidx.lifecycle.LiveData

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
interface IPrefStorage<T> {

    fun remove(key: String)

    fun save(dto: T)

    fun get(): LiveData<T>

}