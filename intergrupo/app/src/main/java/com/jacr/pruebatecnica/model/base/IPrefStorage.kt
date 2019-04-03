package com.jacr.pruebatecnica.model.base

import io.reactivex.Observable

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
interface IPrefStorage<T> {

    fun remove(key: String)

    fun save(dto: T)

    fun get(): Observable<T>

}